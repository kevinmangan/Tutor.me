package controllers;

import static play.data.Form.*;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.search;

public class Search extends Controller {

	public static Result search() {
        return ok(search.render("Your new application is ready."));
    }

    public static Result submit() {
        return ok(search.render("Your new application is ready."));
    }

}