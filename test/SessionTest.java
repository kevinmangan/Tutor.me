import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.inMemoryDatabase;

import java.util.Arrays;
import java.util.List;

import models.Student;
import models.Tutor;
import models.Request;
import models.Session;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import play.test.FakeApplication;
import play.test.Helpers;

//For session tests:
import models.Session;

import java.util.Date;



public class SessionTest {

  private static FakeApplication app;

  private static final String TEST_USERNAME = "Test Username";
  private static final String TEST_EMAIL = "test@email.com";
  private static final String TEST_NAME = "Test Name";
  private static final String TEST_PASSWORD = "Test Password";
  private static final String TEST_SALT = "1";

  private static final String INVALID_SUBJECT = "INVALID";
  private static final String MATH_SUBJECT = "MATH";
  private static final String HISTORY_SUBJECT = "HISTORY";
  private static final String SCIENCE_SUBJECT = "SCIENCE";
  private static final double CHEAP_COST = 1.0;
  private static final double EXPENSIVE_COST = 100.0;
  private static final double LOW_RATING = 1.0;
  private static final double HIGH_RATING = 5.0;

  private Student testStudent;
  private Tutor testMathTutor;
  private Tutor testHistoryTutorCheapHighRated;
  private Tutor testHistoryTutorCheapLowRated;
  private Tutor testHistoryTutorExpensiveHighRated;
  private Tutor testHistoryTutorExpensiveLowRated;
  private Tutor testMultiSubjectTutor;

  private Request testFarFutureRequest;
  private Request testFutureRequest;
  private Request testFarPastRequest;
  private Request testPastRequest;
  private Request testPresentRequest;

  @Before
  public void setUp() {
    app = fakeApplication(inMemoryDatabase());
    Helpers.start(app);

    testStudent = new Student();
    testStudent.setUsername(TEST_USERNAME);
    testStudent.setEmail(TEST_EMAIL);
    testStudent.setName(TEST_NAME);
    testStudent.setSalt(TEST_SALT);
    testStudent.setPwhash(Student.encrypt(TEST_PASSWORD, TEST_SALT));
    testStudent.save();

    testMathTutor = new Tutor();
    testMathTutor.setSubjects(Arrays.asList(MATH_SUBJECT));
    testMathTutor.setCostUSD(EXPENSIVE_COST);
    testMathTutor.setRating(LOW_RATING);
    testMathTutor.save();

    testHistoryTutorCheapHighRated = new Tutor();
    testHistoryTutorCheapHighRated.setSubjects(Arrays.asList(HISTORY_SUBJECT));
    testHistoryTutorCheapHighRated.setCostUSD(CHEAP_COST);
    testHistoryTutorCheapHighRated.setRating(HIGH_RATING);
    testHistoryTutorCheapHighRated.save();

    testHistoryTutorCheapLowRated = new Tutor();
    testHistoryTutorCheapLowRated.setSubjects(Arrays.asList(HISTORY_SUBJECT));
    testHistoryTutorCheapLowRated.setCostUSD(CHEAP_COST);
    testHistoryTutorCheapLowRated.setRating(LOW_RATING);
    testHistoryTutorCheapLowRated.save();

    testHistoryTutorExpensiveHighRated = new Tutor();
    testHistoryTutorExpensiveHighRated.setSubjects(Arrays
        .asList(HISTORY_SUBJECT));
    testHistoryTutorExpensiveHighRated.setCostUSD(EXPENSIVE_COST);
    testHistoryTutorExpensiveHighRated.setRating(HIGH_RATING);
    testHistoryTutorExpensiveHighRated.save();

    testHistoryTutorExpensiveLowRated = new Tutor();
    testHistoryTutorExpensiveLowRated.setSubjects(Arrays
        .asList(HISTORY_SUBJECT));
    testHistoryTutorExpensiveLowRated.setCostUSD(EXPENSIVE_COST);
    testHistoryTutorExpensiveLowRated.setRating(LOW_RATING);
    testHistoryTutorExpensiveLowRated.save();

    testMultiSubjectTutor = new Tutor();
    testMultiSubjectTutor.setSubjects(Arrays.asList(HISTORY_SUBJECT,
        SCIENCE_SUBJECT));
    testMultiSubjectTutor.save();

    long oneMinute = 1000*60;
    long oneHour = oneMinute*60;
    long oneDay = oneHour*24;
    Date date = new Date();
    testFarFutureRequest = new Request(testStudent, testMathTutor, date.getTime()+30*oneDay, date.getTime()+30*oneDay+oneHour);
    testFutureRequest = new Request(testStudent, testMathTutor, date.getTime()+3*oneDay, date.getTime()+3*oneDay+oneHour);
    testFarPastRequest = new Request(testStudent, testMathTutor, date.getTime()-30*oneDay, date.getTime()-30*oneDay+oneHour);
    testPastRequest = new Request(testStudent, testMathTutor, date.getTime()-3*oneDay, date.getTime()-3*oneDay+oneHour);
    testPresentRequest = new Request(testStudent, testMathTutor, date.getTime()-oneHour, date.getTime()+oneHour);
  }

  

  /**
   * Test session
   */
  @Test
  public void testSession() {
    //TODO
    assertTrue(1==0);
  }
  

  @After
  public void tearDown() {
    Helpers.stop(app);
  }
}