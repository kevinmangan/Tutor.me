package controllers;

import static play.data.Form.*;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;
import views.html.search;

import com.typesafe.plugin.*;

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

    public static Result mailTest() {
      MailerAPI mail = play.Play.application().plugin(MailerPlugin.class).email();
      mail.setSubject("Tutor.me");
      //mail.setRecipient("some display name <sometoadd@email.com>");
      //mail.setRecipient("Daniel Alexander Perlmutter <dap2163@columbia.edu>", "Jose Daniel Contreras <jdc2168@columbia.edu>"/*, "Joaquín Ruales <jar2262@columbia.edu>", "Kevin Michael Mangan <kmm2256@columbia.edu>"*/);
      //mail.setFrom("Tutor.me <jar2262@columbia.edu>");
      //sends html
      mail.sendHtml("<html>Welcome to Tutor.me!</html>" );
      
      //sends text/text
      //mail.send( "text" );
      //sends both text and html
      //mail.send( "text", "<html>html</html>");
      
      return ok("Email sent!");
    }

     

}
