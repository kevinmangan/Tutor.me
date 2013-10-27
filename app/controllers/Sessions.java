package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;
import views.html.chatroom;
/*
import play.*;
import play.mvc.*;
import play.data.*;
import static play.data.Form.*;
*/

import models.*;
import views.html.*;


public class Sessions extends Controller {
String ApiKey = "99A2F615-092C-19D5-6621C3B336B411A5";

    public static Result launchSession(String chatRoomId) {
    	return ok(chatroom.render("This is the page title for the chatroom.", "0", "tswv2s0"));
    	//return ok(""+chatRoomId);
        //return ok(index.render("Your new application is ready."));
    }

    public static Result studentRegister() {
        return TODO;
    }

    public static Result tutorRegister() {
        return TODO;
    }

}
