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
    	//String minCost = requestData.get("minCost");
    	//double newmin = Double.parseDouble(minCost);
    	//double maxCost = Double.parseDouble(requestData.get("maxCost"));
    	//double minRating = Double.parseDouble(requestData.get("minRating"));
		//List<Tutor> tutors = Student.searchForTutors(subject, newmin, maxCost, minRating);
    	List<Tutor> tutors = Student.searchForTutors("math", 1, 1000, 3);
        return ok(search.render(tutors));
    }

}