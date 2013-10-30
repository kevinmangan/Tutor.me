package models;

import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

/**
 * Represents a request for a tutoring session
 */
public class Request extends Model {

  private static final long serialVersionUID = -8504063147212754838L;

  @Id
  @GeneratedValue
  public Long id;

  // The student requesting this session
  private Student requestingStudent;

  // The tutor this request is being made of
  private Tutor requestedTutor;

  // The requested start time
  @Required
  private long requestedStartTime;

  // The requested end time
  @Required
  private long requestedEndTime;

  // True if this request has already been approved, false otherwise
  private boolean approved;

  public Request(Student requestingStudent, Tutor requestedTutor,
      long requestedStartTime, long requestedEndTime) {
    this(requestingStudent, requestedTutor, requestedStartTime,
        requestedEndTime, false);
  }

  public Request(Student requestingStudent, Tutor requestedTutor,
      long requestedStartTime, long requestedEndTime,
      boolean approved) {
    this.requestingStudent = requestingStudent;
    this.requestedTutor = requestedTutor;
    this.requestedStartTime = requestedStartTime;
    this.requestedEndTime = requestedEndTime;
    this.approved = approved;
    Request.create(this);
  }

  public static Finder<Long, Request> find = new Finder<Long, Request>(
      Long.class, Request.class);

  /**
  * @return the list of all requests
  */
  public static List<Request> all() {
    return find.all();
  }

  public static void create(Request request) {
    request.save();
  }

  public static void delete(Long id) {
    find.ref(id).delete();
  }

  /**
   * @return the requestinStudent
   */
  public Student getRequestingStudent() {
    return requestingStudent;
  }

  /**
   * @param requestinStudent the requestinStudent to set
   */
  public void setRequestingStudent(Student requestingStudent) {
    this.requestingStudent = requestingStudent;
  }

  /**
   * @return the requestedTutor
   */
  public Tutor getRequestedTutor() {
    return requestedTutor;
  }

  /**
   * @param requestedTutor the requestedTutor to set
   */
  public void setRequestedTutor(Tutor requestedTutor) {
    this.requestedTutor = requestedTutor;
  }

  /**
   * @return the startTime
   */
  public long getStartTime() {
    return requestedStartTime;
  }

  /**
   * @param startTime the startTime to set
   */
  public void setStartTime(long startTime) {
    this.requestedStartTime = startTime;
  }

  /**
   * @return the endTime
   */
  public long getEndTime() {
    return requestedEndTime;
  }

  /**
   * @param endTime the endTime to set
   */
  public void setEndTime(long endTime) {
    this.requestedEndTime = endTime;
  }

  /**
   * @return the approved
   */
  public boolean isApproved() {
    return approved;
  }

  /**
   * @param approved the approved to set
   */
  public void setApproved(boolean approved) {
    this.approved = approved;
  }

  /**
   * Notifies a tutor that a request has been created or canceled
   * 
   * @param created: True if this is a new request, false otherwise
   */
  public void notifyTutorOfRequest(boolean created) {
    // TODO
  }

  /**
   * Notifies a student of a cancelled request
   * 
   */
  public void notifyStudentOfCancellation() {
    // TODO
  }

  /**
   * Notifies a student and tutor of an upcoming sesssion
   * 
   * @param session: The upcooming session
   */
  public void sendSessionNotifications(Session session) {
    // TODO
  }

  public Session generateSession() {
    Session session = new Session(requestingStudent, requestedTutor,
        requestedStartTime, requestedEndTime);
    return session;
  }
}
