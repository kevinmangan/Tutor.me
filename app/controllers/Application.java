package controllers;

import static play.data.Form.*;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;
import views.html.search;

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

     

}
