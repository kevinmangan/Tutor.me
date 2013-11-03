package controllers;

import models.Request;
import play.mvc.Controller;
import play.mvc.Result;

public class Tutors extends Controller {

  public static Result respondToRequest(Long requestId, Boolean response) {
    Request request = Request.find.byId(requestId);

    if (request != null) {
      request.getRequestedTutor().respondToRequest(request, response);
      return ok(
          "You have successfully "
          + (response ? "accepted" : "rejected")
          + " this request!");
    } else {
      return ok("That request does not exist, it may have already been deleted.");
    }
  }
}