package models;

import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import play.db.ebean.Model;

/**
 * Represents a tutoring session
 */
public class Session extends Model {
  private static final long serialVersionUID = -1999689496450297894L;

  @Id
  @GeneratedValue
  public Long id;

  // The student for this session
  private Student student;

  // The tutor for this session
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
    this.scribblarId = ""; // TODO assign scribblar id here
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
    //TODO
  }

  /**
   * Deactivates the Scribblar room for this tutoring session
   */
  public void deactivateRoom() {
    //TODO
  }
}
