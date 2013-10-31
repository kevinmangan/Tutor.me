package controllers;

import java.util.Arrays;
import java.util.List;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

import com.typesafe.plugin.MailerAPI;
import com.typesafe.plugin.MailerPlugin;

public class Application extends Controller {

  public static Result index() {
    return ok(index.render("Your new application is ready."));
  }

  public static Result studentLogin() {
    return TODO;
  }

  public static Result tutorLogin() {
    return TODO;
  }

  public static Result studentRegister() {
    return TODO;
  }

  public static Result tutorRegister() {
    return TODO;
  }

  /**
   * Sends an email to the specified recipients
   * 
   * @param emailSubject: The subject of the email
   * @param emailRecipient: The recipient of the email
   * @param emailHtml: The html text contained in the email
   */
  public static void sendEmail(String emailSubject, String emailRecipient, String emailHtml) {
    sendEmail(emailSubject, Arrays.asList(emailRecipient), emailHtml);
  }

  /**
   * Sends an email to the specified recipients
   * 
   * @param emailSubject: The subject of the email
   * @param emailRecipients: The recipients of the email
   * @param emailHtml: The html text contained in the email
   */
  public static void sendEmail(String emailSubject,
      List<String> emailRecipients, String emailHtml) {
    MailerAPI mail = play.Play.application().plugin(MailerPlugin.class).email();
    mail.addFrom("Tutor.me Mailing Robot <tutor.me.mailer@gmail.com>");
    mail.setSubject(emailSubject);
    for (String emailRecipient : emailRecipients) {
      mail.addRecipient(emailRecipient);
    }
    mail.sendHtml(emailHtml);
  }
}
