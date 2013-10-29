package controllers;
import play.data.DynamicForm;
import java.util.*;
import models.*;
import static play.data.Form.*;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.search;

public class Search extends Controller {

	public static Result search() {
		List<Tutor> emptyList = Collections.<Tutor>emptyList();
        return ok(search.render(emptyList));
    }

    public static Result submit() {
    	// make new student and call find tutor

    	DynamicForm requestData = form().bindFromRequest();
    	String subject = requestData.get("subject");
    	double minCost = Double.parseDouble(requestData.get("minCost"));
    	double maxCost = Double.parseDouble(requestData.get("maxCost"));
    	double minRating = Double.parseDouble(requestData.get("minRating"));
		List<Tutor> tutors = Student.searchForTutors(subject, minCost, maxCost, minRating);
        return ok(search.render(tutors));
    }

}