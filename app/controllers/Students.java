package controllers;

import models.Request;
import play.mvc.Controller;
import play.mvc.Result;

public class Students extends Controller {

  public static Result cancelRequest(Long requestId) {
    Request request = Request.find.byId(requestId);

    if (request != null) {
      request.getRequestingStudent().cancelRequest(request);
      return ok("You have successfully cancelled this request!");
    } else {
      return ok("That request does not exist, it may have already been deleted.");
    }
  }
}