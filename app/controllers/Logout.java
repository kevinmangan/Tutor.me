package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

public class Logout extends Controller {

  public static Result logout(){
    session().clear();
    //Go to log out page
    return  ok(index.render("Welcome"));
  }
}