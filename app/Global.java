import play.*;
import play.libs.*;

import java.util.*;

import com.avaje.ebean.*;

import models.*;

public class Global extends GlobalSettings {
    
    public void onStart(Application app) {
        InitialData.insert(app);
    }
    
    static class InitialData {
        
        public static void insert(Application app) {
            if(Ebean.find(Tutor.class).findRowCount() == 0) {
                
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