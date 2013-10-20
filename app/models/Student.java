package models;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a Tutor.me student
 */
public class Student extends User {

  public Long id;
  public String label;

  public static List<Student> all() {
    return new ArrayList<Student>();
  }

  public static void create(Student student) {
  }

  public static void delete(Long id) {
  }

  /**
   * Creates a new tutoring session request
   * @param tutor: The tutor that is being request to hold the session
   * @param startTime: The start time of the tutoring session
   * @param endTime: The end time of the tutoring session
   * @return: The request that was created
   */
  public static Request createRequest(Tutor tutor, long startTime, long endTime) {
    //TODO
    return null;
  }

  /**
   * @param request: The request to be cancelled
   */
  public static void cancelRequest(Request request) {
    //TODO
  }

  /**
   * Rates a tutor on their performance
   * @param tutor: The tutor to rate
   * @param rating: The rating to give the tutor
   */
  public static void rateTutor(Tutor tutor, int rating) {
    //TODO
  }
}
