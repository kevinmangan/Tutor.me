package controllers;

import models.Request;
import models.Student;
import models.Tutor;
import play.mvc.Controller;
import play.mvc.Result;

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
