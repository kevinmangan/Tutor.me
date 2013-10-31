package controllers;

import java.util.Arrays;
import java.util.List;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

import com.typesafe.plugin.MailerAPI;
import com.typesafe.plugin.MailerPlugin;

import models.Tutor;
import models.Student;
import com.avaje.ebean.Query;

public class TestController extends Controller {

  /**
  * 
  */
  public static Result userListTest() {
    return ok(
      "Students: " + Student.find.all()+"\n" +
      "Tutors: " + Tutor.find.all()
      );
  }

  public static Result sendRequestTest(Long studentId, Long tutorId, long startTime, long endTime) {
    Student theStudent = Student.find.ref(studentId);
    Tutor theTutor = Tutor.find.ref(tutorId);
    theStudent.createRequest(theTutor, startTime, endTime);

    return ok("The request should have been created. Please check tutor's email.");
  }
}
