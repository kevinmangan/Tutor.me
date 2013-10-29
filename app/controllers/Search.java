package controllers;

import models.*;
import static play.data.Form.*;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.search;

public class Search extends Controller {

	public static Result search() {
		List<tutor> tutors = NULL;
        return ok(search.render(tutors));
    }

    public static Result submit() {
    	// make new student and call find tutor
    	Student student = new Student;
    	DynamicForm requestData = form.bindFromRequest();
    	String subject = requestData.get("subject");
    	double minCost = requestData.get("minCost");
    	double maxCost = requestData.get("maxCost");
    	double minRating = requestData.get("minRating");
		List<tutor> tutors = student.searchForTutors(subject, minCost, maxCost, minRating);
        return ok(search.render(tutors));
    }

}