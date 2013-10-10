package controllers;

import play.*;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {

    public static Result index() {
        return ok(index.render("Your new application is ready."));
    }

    public static Result studentIndex() {
        return ok(studentIndex.render("Sign up as a student!"));
    }

    public static Result tutorIndex() {
        return ok(tutorIndex.render("Sign up as a tutor!"));
    }

    public static Result studentRegister() {
        return TODO;
    }

    public static Result tutorRegister() {
        return TODO;
    }

}
