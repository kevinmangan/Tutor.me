package controllers;

import play.*;
import play.mvc.*;

import views.html.*;

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
