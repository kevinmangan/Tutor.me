package models;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a request for a tutoring session
 */
public class Request {

  public Long id;
  public String label;

  public static List<Request> all() {
    return new ArrayList<Request>();
  }

  public static void create(Student student) {
  }

  public static void delete(Long id) {
  }

  // The requested start time
  private long requestedStartTime;

  // The requested end time
  private long requestedEndTime;

  // True if this request has already been approved, false otherwise
  private boolean approved;

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
   * Notifies a tutor that a request has been created for them
   * 
   * @param tutor: The tutor to notify
   */
  public void notifyTutor(Tutor tutor) {
    // TODO
  }

  /**
   * Notifies a student that a tutor has responded to their request
   * 
   * @param student: The student to notify
   * @param response: True if the tutor approved the request and false otherwise
   */
  public void notifyStudent(Student student, boolean response) {
    // TODO
  }
}
