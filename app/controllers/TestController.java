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
import models.Request;
import com.avaje.ebean.*;

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
    Request theRequest = theStudent.createRequest(theTutor, startTime, endTime);
    return ok("The request should have been created. Please check tutor's email. request:"+theRequest.id + ", tutor"+theRequest.getRequestedTutor() + ", student:"+theRequest.getRequestingStudent());
  }
}
