package models;

import java.util.List;

/**
 * Represents a Tutor.me student
 */
public class Student extends User {

  private static final String requestSelfFieldName = "requestingStudent";
  private static final String sessionSelfFieldName = "requestedTutor";

  private static final long serialVersionUID = -6347603101193360297L;

  public static Finder<Long, Student> find = new Finder<Long, Student>(
      Long.class, Student.class);

  public static List<Student> all() {
    return find.all();
  }

  public static void create(Student student) {
    student.save();
  }

  public static void delete(Long id) {
    find.ref(id).delete();
  }

  /**
   * Creates a new tutoring session request
   * 
   * @param tutor: The tutor that is being request to hold the session
   * @param startTime: The start time of the tutoring session
   * @param endTime: The end time of the tutoring session
   * @return: The request that was created
   */
  public Request createRequest(Tutor tutor, long startTime, long endTime) {
    Request request = new Request(this, tutor, startTime, endTime);
    request.notifyTutor(true);
    return request;
  }

  /**
   * Cancels a tutoring session request
   * 
   * @param request: The request to be canceled
   */
  public void cancelRequest(Request request) {
    request.notifyTutor(false);
    request.delete();
  }

  /**
   * Rates a tutor on their performance s
   * 
   * @param tutor: The tutor to rate
   * @param rating: The rating to give the tutor
   */
  public static void rateTutor(Tutor tutor, int rating) {
    int numRaters = tutor.getNumRaters();
    int updateNumRaters = numRaters + 1;
    double ratingAggregate = tutor.getRating() * numRaters;
    tutor.setRating((ratingAggregate + rating) / updateNumRaters);
    tutor.setNumRaters(updateNumRaters);
  }
}
