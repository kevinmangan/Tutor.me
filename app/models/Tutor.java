package models;

import java.util.List;

/**
 * Represents a Tutor.me tutor
 */
public class Tutor extends User {

  private static final String requestSelfFieldName = "requestedTutor";
  private static final String sessionSelfFieldName = "tutor";

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

  // Name of the tutor
  private String name;

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

  //The cost in U.S. dollars of a single session with this tutor
  private double costUSD;

  /**
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * @param the name to set
   */
  public void setName(String name) {
    this.name = name;
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
   * Responds to a request for a tutoring session
   * 
   * @param request: The request to respond to
   * @param response: True if the tutor approves of the request, false otherwise
   */
  public void respondToRequest(Request request, boolean response) {
    if (response) {
      Session session = request.generateSession();
      request.sendSessionNotifications(session);
    } else {
      request.notifyStudentOfCancellation(this);
    }
    request.delete();
  }
}
