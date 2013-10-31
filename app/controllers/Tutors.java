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

import models.Request;

public class Tutors extends Controller {

  public static Result respondToRequest(Long requestId, Boolean response) {
    Request request = Request.find.byId(requestId);
    //return ok(""+request + ", "+request.getRequestedTutor() + ", student:"+request.getRequestingStudent());

    request.getRequestedTutor().respondToRequest(request, response);
    return ok("You have successfully " + (response?"accepted":"rejected") + " this request!");
  }
}