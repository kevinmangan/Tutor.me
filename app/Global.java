import java.util.List;
import java.util.Map;

import models.Tutor;
import play.Application;
import play.GlobalSettings;
import play.libs.Yaml;

import com.avaje.ebean.Ebean;

public class Global extends GlobalSettings {

  @Override
  public void onStart(Application app) {
    InitialData.insert(app);
  }

  static class InitialData {

    public static void insert(Application app) {
      if(Ebean.find(Tutor.class).findRowCount() == 0) {

        @SuppressWarnings("unchecked")
        Map<String,List<Object>> all = (Map<String,List<Object>>)Yaml.load("initial-data.yml");

        // Insert users first
        Ebean.save(all.get("tutors"));

        // Insert students
        // Ebean.save(all.get("students"));
        // for(Object project: all.get("students")) {
        // Insert the student/tutor relation
        //   Ebean.saveManyToManyAssociations(student, "members");
        //}

        // Insert tasks
        // Ebean.save(all.get("tasks"));

      }
    }

  }

}