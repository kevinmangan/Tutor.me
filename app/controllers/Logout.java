package controllers;
import java.security.MessageDigest;
import java.security.*;
import java.io.*;
import java.math.BigInteger;
import models.User;
import models.Student;
import java.util.*;
import models.Tutor;
import play.data.DynamicForm;
import play.mvc.Controller;
import play.mvc.Result;
import play.api.mvc.Session;
import views.html.*;
import com.typesafe.plugin.MailerAPI;
import com.typesafe.plugin.MailerPlugin;
import com.avaje.ebean.Query;
import play.data.*;
import static play.data.Form.*;

public class Logout extends Controller {

	public static Result logout(){
		session().clear();
		//Go to log out page
		return  ok(index.render("Welcome"));

		}

}