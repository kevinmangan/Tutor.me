package models;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import javax.persistence.*;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import play.db.ebean.*;
import com.avaje.ebean.*;

/**
 * Represents a tutoring session
 */
@Entity
public class Session extends Model {
  private static final long serialVersionUID = -1999689496450297894L;

  @Id
  @GeneratedValue
  public Long id;

  // The student for this session
  @ManyToOne
  private Student student;

  // The tutor for this session
  @ManyToOne
  private Tutor tutor;

  // The start time of this tutoring session
  private long startTime;

  // The end time of this tutoring session
  private long endTime;

  // The id of the scribblar room that will be used for this tutoring session
  private String scribblarId;

  public Session(Student student, Tutor tutor, long startTime, long endTime) {
    this.student = student;
    this.tutor = tutor;
    this.startTime = startTime;
    this.endTime = endTime;
    this.scribblarId = Scribblar.addScribblarRoom();
    if(this.scribblarId==null) {
      //throw new Exception();//Should be a SessionGenerationException
    }
    Session.create(this);
  }

  public static Finder<Long, Session> find = new Finder<Long, Session>(
      Long.class, Session.class);

  public static List<Session> all() {
    return find.all();
  }

  public static void create(Session session) {
    session.save();
  }

  public static void delete(Long id) {
    find.ref(id).delete();

  }

  /**
   * @return the student
   */
  public Student getStudent() {
    return student;
  }

  /**
   * @param student the student to set
   */
  public void setStudent(Student student) {
    this.student = student;
  }

  /**
   * @return the tutor
   */
  public Tutor getTutor() {
    return tutor;
  }

  /**
   * @param tutor the tutor to set
   */
  public void setTutor(Tutor tutor) {
    this.tutor = tutor;
  }

  /**
   * @return the startTime
   */
  public long getStartTime() {
    return startTime;
  }

  /**
   * @param startTime the startTime to set
   */
  public void setStartTime(long startTime) {
    this.startTime = startTime;
  }

  /**
   * @return the endTime
   */
  public long getEndTime() {
    return endTime;
  }

  /**
   * @param endTime the endTime to set
   */
  public void setEndTime(long endTime) {
    this.endTime = endTime;
  }

  /**
   * @return the scribblarId
   */
  public String getScribblarId() {
    return scribblarId;
  }

  /**
   * @param scribblarId the scribblarId to set
   */
  public void setScribblarId(String scribblarId) {
    this.scribblarId = scribblarId;
  }

  /**
   * Activates the Scribblar room for this tutoring session
   */
  public void activateRoom() {
    setScribblarId(Scribblar.addScribblarRoom());
  }

  /**
   * Deactivates the Scribblar room for this tutoring session
   */
  public void deactivateRoom() {
    Scribblar.deleteScribblarRoom(scribblarId);
  }

  /**
   * Makes a scribblar request and returns the Document corresponding to Scribblar's XML response
   */
  public static Document makeScribblarRequest(String requestString) {
    try {
      URL url = new URL("https://api.scribblar.com/v1/?api_key="+PrivateVars.SCRIBBLAR_API_KEY+"&"+requestString);
      BufferedReader reader = null;
      // String returnable = "";
      reader = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));

      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
      DocumentBuilder builder;
      InputSource is;
      try {
        builder = factory.newDocumentBuilder();
        is = new InputSource(reader);
        Document doc = builder.parse(is);
        return doc;
      } catch (ParserConfigurationException e) {
        return null;
      } catch (SAXException e) {
        return null;
      } catch (IOException e) {
        return null;
      }
    } catch (Exception e) {
      return null;
    }
  }
}
