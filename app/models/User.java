package models;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a user of Tutor.me
 */
public class User {
  public Long id;
  public String label;

  public static List<? extends User> all() {
    return new ArrayList<User>();
  }

  public static void create(Student student) {
  }

  public static void delete(Long id) {
  }

  // The username of this user on Tutor.me
  private String username;

  // The email address of this user
  private String email;

  // The full name of this user
  private String name;

  /**
   * @return the username
   */
  public String getUsername() {
    return username;
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
   * Gets the requests associated with this user
   * @return: The list of Requests associated with this user
   */
  public List<Request> getRequests() {
    //TODO
    return null;
  }

  /**
   * Gets the upcoming tutoring sessions for this user
   * @return: The list of upcoming Sessions associated with this user
   */
  public List<Session> getUpcomingSessions() {
    //TODO
    return null;
  }

  /**
   * Gets the completed tutoring sessions for this user
   * @return: The list of completed Sessions associated with this user
   */
  public List<Session> getCompletedSessions() {
    //TODO
    return null;
  }

  /**
   * Logs this user in
   */
  public void logIn() {
    //TODO
  }

  /**
   * Logs this user out
   */
  public void logOut() {
    //TODO
  }
}
