package models;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a tutoring session
 */
public class Session {
  public Long id;
  public String label;

  public static List<Session> all() {
    return new ArrayList<Session>();
  }

  public static void create(Student student) {
  }

  public static void delete(Long id) {
  }

  // The start time of this tutoring session
  private long startTime;

  // The end time of this tutoring session
  private long endTime;

  // The id of the scribblar room that will be used for this tutoring session
  private String scribblarId;

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
