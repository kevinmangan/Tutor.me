package models;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 * Represents a Scribblar database
 */
public class Scribblar {
  private static final long serialVersionUID = -1999689496450297894L;
  /**
   * Makes a scribblar request and returns the Document corresponding to Scribblar's XML response
   */
  public static Document makeScribblarRequest(String requestString) {
    try {
      URL url = new URL("https://api.scribblar.com/v1/?api_key="+PrivateVars.SCRIBBLAR_API_KEY+"&"+requestString);
      BufferedReader reader = null;
      // String returnable = "";
      reader = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));

      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
      DocumentBuilder builder;
      InputSource is;
      try {
        builder = factory.newDocumentBuilder();
        is = new InputSource(reader);
        Document doc = builder.parse(is);
        return doc;
      } catch (ParserConfigurationException e) {
        return null;
      } catch (SAXException e) {
        return null;
      } catch (IOException e) {
        return null;
      }
    } catch (Exception e) {
      return null;
    }
  }
  /*
   * Adds a room to external Scribblar database, returns the room id, which needs to be passed to Sessions.launchSession along with Scribblar user id
   *
   * returns roomId if successful, null if not
   */
  public static String addScribblarRoom() {
    String requestString = "function=rooms.add" +
    "&roomname=testroom" +
    "&allowguests=0" +
    "&roomvideo=1" +
    "&roomwolfram=1" +
    "&hideflickr=1" +
    "&autostartcam=1"+
    "&autostartaudio=1";
    Document doc = makeScribblarRequest(requestString);

    NodeList list = doc.getElementsByTagName("response");
    if(list.item(0).getAttributes().getNamedItem("status").getNodeValue().equals("ok")) {
      // Success!
      Node roomIdNode = doc.getElementsByTagName("roomid").item(0);
      return roomIdNode.getTextContent();
    } else {
      // An error occured!
      return null;
    }
  }
  /*
   * deleteScribblarRoom
   *
   * deletes the room with the given id from Scribblar's database
   * returns roomId if successful, null if not
   */
  public static String deleteScribblarRoom(String roomId) {
    String requestString = "function=rooms.delete" +
    "&roomid="+roomId;
    Document doc = makeScribblarRequest(requestString);

    NodeList list = doc.getElementsByTagName("response");
    if(list.item(0).getAttributes().getNamedItem("status").getNodeValue().equals("ok")) {
      // Success!
      return roomId;
    } else {
      // An error occured!
      return null;
    }
  }

  /**
   * Adds a user to external Scribblar database, returns the user id, which needs to be passed to Sessions.launchSession along with Scribblar room id
   *
   * returns userId if successful, null if not
   */
  public static String addScribblarUser(User user) {
    String requestString = "function=users.add" +
    "&username=" + user.getUsername() +
    /*"&firstname=" + user.getName() +*/
    "&roleid=50";
    Document doc = makeScribblarRequest(requestString);

    NodeList list = doc.getElementsByTagName("response");
    if(list.item(0).getAttributes().getNamedItem("status").getNodeValue().equals("ok")) {
      // Success!
      Node userIdNode = doc.getElementsByTagName("userid").item(0);
      return userIdNode.getTextContent();
    } else {
      // An error occured!
      return null;
    }
  }
}
