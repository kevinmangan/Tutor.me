package controllers;
import static play.data.Form.form;
import java.lang.*;
import java.util.Collections;
import java.util.List;
import com.avaje.ebean.Query;
import models.Tutor;
import play.*;
import play.mvc.*;
import play.data.*;
import views.html.profile;

public class Profile extends Controller {

  public static Result viewProfile(String username) {
    //final User localUser = getLocalUser(session());
    //String localName = localUser.getUsername();
    Query<Tutor> tutorResults  = Tutor.find.where().contains("username", username).orderBy("rating");
    List<Tutor> tutors = tutorResults.findList();
    Tutor tutor = tutors.get(0);

    // If the user viewing the profile is the tutor himself, pass in 1 so view knows to show the edit button  
    //if(localName.equals(username)){
        return ok(profile.render(tutor, 1, 1));
    //}else if(username != null){
    
      //return ok(profile.render(tutor, 0, 1));
    //}else{
    //  return unauthorized("Oops, you are not connected");
   // }
  }

    
/*
  public static Result editProfile(String username) {
    DynamicForm requestData = form().bindFromRequest();
    String tagline = requestData.get("tagline");
    String description = requestData.get("tagline");
    Double cost = Double.parseDouble(requestData.get("cost"));
    
    Tutor tutor = Tutor.find.where().contains("username", username);
    tutor.setTagline(tagline);
    tutor.setDescription(description);
    tutor.setCostUSD(cost);
    return ok(profile.render(tutor, 1, 1));
  }
  */

}