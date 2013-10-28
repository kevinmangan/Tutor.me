package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

public class Application extends Controller {

    public static Result index() {
        return ok(index.render("Your new application is ready."));
    }

    public static Result studentRegister() {
        return TODO;
    }

    public static Result tutorRegister() {
        return TODO;
    }

     public static Result search() {
        return ok(search.render("Your new application is ready."));
    }

}
