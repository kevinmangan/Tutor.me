package models;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.joda.time.DateTime;

import play.data.validation.Constraints.Email;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

import com.avaje.ebean.ExpressionList;

/**
 * Represents a user of Tutor.me
 */
@MappedSuperclass
public abstract class User extends Model {

  // The name of the field that could contain a reference to this user in a
  // request object
  protected static String requestSelfFieldName;

  // The name of the field that could contain a reference to this user in a
  // session object
  protected static String sessionSelfFieldName;

  private static final long serialVersionUID = -2547732540294543775L;

  @Id
  @GeneratedValue
  public Long id;

  // The username of this user on Tutor.me
  @Required
  private String username;

  // The email address of this user
  @Required
  @Email
  private String email;

  // The full name of this user
  @Required
  private String name;

  // The id of the scribblar user corresponding to this user
  private String scribblarId;

  //The password hash
  private String pwhash;

  //The password salt
  private String salt;

  public static Finder<Long, User> find = new Finder<Long, User>(Long.class,
      User.class);

  public static List<? extends User> all() {
    return find.all();
  }

  public static void create(User user) {
    user.save();
  }

  public static void delete(Long id) {
    find.ref(id).delete();
  }

  public Long getID(){
    return id;
  }

  /**
   * @return the username
   */
  public String getUsername() {
    return this.username;
  }

  /**
   * @param username the username to set
   */
  public void setUsername(String username) {
    this.username = username;
  }

  /**
   * @return the email
   */
  public String getEmail() {
    return email;
  }

  /**
   * @param email the email to set
   */
  public void setEmail(String email) {
    this.email = email;
  }

  /**
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * @param name the name to set
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * @return the scribblarId
   */
  public String getScribblarId() {
    if(username.equals("dap2163")) {
      return "8407F720-F071-6389-DB2BFC968B95788F";
    } else if(username.equals("jar2262")) {
      return "8407FF3F-959A-BDEE-6CFB7072AA2081D7";
    } else if(username.equals("kmm2256")) {
      return "9D3EC0E5-BBDA-C65E-C303B4D08BC8A1A3";
    }

    if(scribblarId == null) {
      // TODO check if true
      setScribblarId();
    }
    return scribblarId;
  }
  public boolean setScribblarId() {
    if(scribblarId == null) {
      scribblarId = Scribblar.addScribblarUser(this);
      this.save();
    }
    return scribblarId != null;
  }

  /**
   *
   * @return  Users salt
   */
  public String getSalt(){
    return this.salt;
  }

  /**
   *
   * @param s: salt
   */
  public void setSalt(String s){
    this.salt = s;
  }

  public String getPwhash(){
    return this.pwhash;
  }
  public void setPwhash(String phash){
    this.pwhash = phash;
  }
  /**
   * Gets the requests associated with this user
   * 
   * @return: The list of Requests associated with this user
   */
  public List<Request> getRequests() {
    List<Request> requestResults = Request.all();
    ArrayList<Request> returning = new ArrayList<Request>();
    for(Request r: requestResults){
    	if(this.getUsername()==r.getRequestingStudent().getUsername()||this.getUsername()==r.getRequestedTutor().getUsername()){
    		returning.add(r);
    	}
    }
    return returning;
  }

  /**
   * Gets the upcoming tutoring sessions for this user
   * 
   * @return: The list of upcoming Sessions associated with this user
   */
  public List<TMSession> getUpcomingSessions() {
  	Date date = new Date();
    List<TMSession> upcomingSessionResults = TMSession.all();
    ArrayList<TMSession> returning = new ArrayList<TMSession>();
    if(sessionSelfFieldName=="tutor"){
    	for(TMSession sesh: upcomingSessionResults){
      	if(sesh.getTutor().getUsername()==this.getUsername()&&sesh.getStartTime()>date.getTime()){
      		returning.add(sesh);
      	}
      }
  	}else{
  		for(TMSession sesh: upcomingSessionResults){
  			if(sesh.getStudent().getUsername()==this.getUsername()&&sesh.getStartTime()>date.getTime()){
      		returning.add(sesh);
      	}
      }
  	}
    return returning;
  }

  /**
   * Gets the current tutoring sessions for this user
   * 
   * @return: The list of completed Sessions associated with this user
   */
  public List<TMSession> getCurrentSessions() {
  	Date date = new Date();
  	List<TMSession> currentSessionResults = TMSession.all();
    ArrayList<TMSession> returning = new ArrayList<TMSession>();
  	for(TMSession sesh: currentSessionResults){
    	if((sesh.getTutor().getUsername()==this.getUsername()||sesh.getStudent().getUsername()==this.getUsername())&&sesh.getStartTime()<date.getTime()&&sesh.getEndTime()>date.getTime()){
    		returning.add(sesh);
    	}
    }
    return returning;
  }

  /**
   * Gets the completed tutoring sessions for this user
   * 
   * @return: The list of completed Sessions associated with this user
   */
  public List<TMSession> getCompletedSessions() {
  	Date date = new Date();
  	List<TMSession> completedSessionResults = TMSession.all();
    ArrayList<TMSession> returning = new ArrayList<TMSession>();
  	for(TMSession sesh: completedSessionResults){
    	if((sesh.getTutor().getUsername()==this.getUsername()||sesh.getStudent().getUsername()==this.getUsername())&&sesh.getEndTime()<date.getTime()){
    		returning.add(sesh);
    	}
    }
    return returning;
  }

  /**
   *
   * @return random Salt
   */
  public static String saltGenerate()
  {
    SecureRandom random = new SecureRandom();
    return new BigInteger(130, random).toString(32);
  }

  /**
   *
   * @param text: string to hash
   * @return encoded string
   */

  public static byte[] getMd5OfUtf8(String text) {
    try {
      MessageDigest digest = MessageDigest.getInstance("MD5");
      return digest.digest(text.getBytes("UTF-8"));
    } catch (NoSuchAlgorithmException ex) {
      throw new RuntimeException("No MD5 implementation? Really?");
    } catch (UnsupportedEncodingException ex) {
      throw new RuntimeException("No UTF-8 encoding? Really?");
    }
  }

  /**
   *
   * @param pw: Password
   * @param salt
   * @return hashed Password
   */
  public static String encrypt(String pw, String salt){
    String temp1;
    String temp2;
    try {
      temp1 = new String(getMd5OfUtf8(pw+salt),"UTF-8");
      temp2 = new String(getMd5OfUtf8(temp1+salt),"UTF-8");
      temp1 = new String(getMd5OfUtf8(temp2+salt),"UTF-8");
      temp2 = new String(getMd5OfUtf8(temp1+salt),"UTF-8");
    }
    catch(Exception e){
      return e.getLocalizedMessage();
    }
    return temp2;
  }
  public boolean validate(){
    if(this.username!=null&&this.email!=null&&this.pwhash!=null&&this.name!=null&&this.salt!=null){
      return true;
    } else {
      return false;
    }
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof User) {
      User other = (User) obj;
      return this.getEmail().equals(other.getEmail())
      && this.getUsername().equals(other.getUsername());
    } else {
      return false;
    }
  }
}
