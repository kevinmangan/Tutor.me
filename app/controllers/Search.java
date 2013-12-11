package controllers;
import static play.data.Form.form;

import java.util.Collections;
import java.util.List;

import models.Student;
import models.Tutor;
import play.data.DynamicForm;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.search;

public class Search extends Controller {

  public static boolean isLoggedIn(){
    String user = session("connected");
    if(user==null){
      return false;
    }
    else{
      return true;
    }
  }

  public static String loggedUser(){
    String username = session("connected");
    return username;
  }

  public static Result search() {
    if (isLoggedIn()) {
      List<Tutor> emptyList = Collections.<Tutor>emptyList();
      return ok(search.render(emptyList));
    } else {
      return unauthorized("Oops, you are not connected");
      //user is logged out
      //return redirect()
    }
  }

  public static Result submit() {
    DynamicForm requestData = form().bindFromRequest();
    String subject = requestData.get("subject");
    double minCost, maxCost, minRating;
    try {
      minCost = Double.parseDouble(requestData.get("minCost"));
    } catch(NumberFormatException e) {
      minCost = 0;
    }
    try {
      maxCost = Double.parseDouble(requestData.get("maxCost"));
    } catch(NumberFormatException e) {
      maxCost = 1000;
    }
    try {
      minRating = Double.parseDouble(requestData.get("minRating"));
    } catch(NumberFormatException e) {
      minRating = 0;
    }
    List<Tutor> tutors = Student.searchForTutors(subject, minCost, maxCost,
        minRating);
    return ok(search.render(tutors));
  }
}