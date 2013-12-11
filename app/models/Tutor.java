package models;

import java.util.List;

import javax.persistence.Entity;

import org.apache.commons.lang3.StringUtils;

/**
 * Represents a Tutor.me tutor
 */
@Entity
public class Tutor extends User {

  protected static final String requestSelfFieldName = "requestedTutor";
  protected static final String sessionSelfFieldName = "tutor";

  private static final long serialVersionUID = 7353992572780743627L;

  public static Finder<Long, Tutor> find = new Finder<Long, Tutor>(Long.class,
      Tutor.class);

  public static List<Tutor> all() {
    return find.all();
  }

  public static void create(Tutor tutor) {
    tutor.save();
  }

  public static void delete(Long id) {
    find.ref(id).delete();
  }

  // Profile picture
  private String picture;

  // The rating of this tutor
  private double rating;

  // The number of students that have rated this tutor
  private int numRaters;

  // A description of the tutor
  private String description;

  // The tutor's tagline
  private String tagline;

  // A list of the subjects the tutor teaches
  private List<String> subjects;

  // A csv list of the subjects the tutor teaches
  @SuppressWarnings("unused")
  public String subjectsCSV;

  //The cost in U.S. dollars of a single session with this tutor
  private double costUSD;


  /**
   * @return the picture
   */
  public String getPicture() {
    if(picture != null){
      return "images/profilePics/" + picture;
    }else{ return "none";}
  }

  /**
   * @param
   */
  public void setPicture(String picture) {
    this.picture = picture;
  }

  /**
   * @return the rating
   */
  public double getRating() {
    return rating;
  }

  /**
   * @param rating the rating to set
   */
  public void setRating(double rating) {
    this.rating = rating;
  }

  /**
   * @return the numRaters
   */
  public int getNumRaters() {
    return numRaters;
  }

  /**
   * @param numRaters the numRaters to set
   */
  public void setNumRaters(int numRaters) {
    this.numRaters = numRaters;
  }

  /**
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * @param description the description to set
   */
  public void setDescription(String description) {
    this.description = description;
  }

  /**
   * @return the tagline
   */
  public String getTagline() {
    return tagline;
  }

  /**
   * @param tagline the tagline to set
   */
  public void setTagline(String tagline) {
    this.tagline = tagline;
  }

  /**
   * @return the subjects
   */
  public List<String> getSubjects() {
    return subjects;
  }

  /**
   * @param subjects the subjects to set
   */
  public void setSubjects(List<String> subjects) {
    subjectsCSV = StringUtils.join(subjects, ",");
    this.subjects = subjects;
  }

  /**
   * @return the costUSD
   */
  public double getCostUSD() {
    return costUSD;
  }

  /**
   * @param costUSD the costUSD to set
   */
  public void setCostUSD(double costUSD) {
    this.costUSD = costUSD;
  }

  /**
   * Validates a student
   * @param identifier: The student's email or username
   * @param password: The student's password
   * @return: True if the validation was succesful, false otherwise
   */
  public static boolean authenticate(String identifier, String password){
    Tutor tutor = findTutor(identifier);
    if(tutor != null && encrypt(password,tutor.getSalt()).equals(tutor.getPwhash())){
      return true;
    }
    return false;
  }

  /**
   * Finds the student corresponding to the given identifier
   * @param identifier: The student's email or username
   * @return: The student corresponding to the given identifier
   */
  public static Tutor findTutor(String identifier) {
    Tutor matchingTutor = find.where().eq("email",identifier).findUnique();
    if(matchingTutor==null){
      matchingTutor = find.where().eq("username",identifier).findUnique();
      if(matchingTutor==null){
        return null;
      }
      else{
        return matchingTutor;
      }
    }
    else{
      return matchingTutor;
    }
  }

  /**
   * Checks if Tutor exists in database
   * 
   * @param username: The potential username for the Student
   * @param email: The potential email for the Student
   */
  public static boolean existsTutor(String username, String email){
    Tutor matchingTutors = find.where()
    .or(com.avaje.ebean.Expr.eq("username",username),
        com.avaje.ebean.Expr.eq("email", email)).findUnique();
    if(matchingTutors==null){
      return false;
    }
    else{
      return true;
    }
  }

  /**
   * Responds to a request for a tutoring session
   * 
   * @param request: The request to respond to
   * @param response: True if the tutor approves of the request, false otherwise
   */
  public void respondToRequest(Request request, boolean response) {
    if (response) {
      TMSession session = request.generateSession();
      request.sendSessionNotifications(session);
    } else {
      request.sendCancellationNotification(true);
    }
    request.delete();
  }
}
