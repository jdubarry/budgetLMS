import java.io.*;
import java.util.ArrayList;
import java.util.UUID;
import java.util.Date;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Jordan's super swaggin Data Loader class
 */
public class DataLoader {

    public static void LoadUsers() {
        JSONParser parser = new JSONParser();

        try {     
            JSONArray arr = (JSONArray) parser.parse(new FileReader("json/users.json"));
            
            for(Object obj : arr) {
                JSONObject json =  (JSONObject) obj;

                UUID id = (UUID) (json.get("id"));
                String firstName = (String) json.get("firstName");
                String lastName = (String) json.get("lastName");
                String email = (String) json.get("email");
                String phone = (String) json.get("phone");
                String username = (String) json.get("userName");
                String password = (String) json.get("password");
                Date dateOfBirth = (Date) json.get("DateOfBirth");

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return;
    }

    public static void LoadAuthors() {
        JSONParser parser = new JSONParser();

        try {     
            JSONArray arr = (JSONArray) parser.parse(new FileReader("json/users.json"));
            
            for(Object obj : arr) {
                JSONObject json =  (JSONObject) obj;

                UUID id = (UUID) (json.get("id"));
                String firstName = (String) json.get("firstName");
                String lastName = (String) json.get("lastName");
                String email = (String) json.get("email");
                String phone = (String) json.get("phone");
                String username = (String) json.get("userName");
                String password = (String) json.get("password");
                Date dateOfBirth = (Date) json.get("DateOfBirth");

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return;
    }

    public static void LoadCourses() {
        JSONParser parser = new JSONParser();

        try {     
            JSONArray arr = (JSONArray) parser.parse(new FileReader("json/users.json"));
            
            for(Object obj : arr) {
                JSONObject json =  (JSONObject) obj;

                UUID id = (UUID) (json.get("id"));
                String courseName = (String) json.get("courseName");
                String courseDesc = (String) json.get("courseDescription");
                UUID authorID = (UUID) (json.get("authorID"));

                JSONArray modules = (JSONArray) json.get("modules");

                for (Object m : modules)
                {
                    JSONObject module =  (JSONObject) m;

                    String moduleName = (String) module.get("moduleName");

                    JSONArray lessons = (JSONArray) module.get("lessons");

                    for (Object l : lessons)
                    {
                        JSONObject lesson =  (JSONObject) l;

                        String lessonTitle = (String) lesson.get("lessonTitle");
                        String lessonContent = (String) lesson.get("lessonContent");

                        JSONArray comments = (JSONArray) lesson.get("comments");

                        for (Object c : comments)
                        {
                            
                        }
                    }
                }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return;
    }

    private Comment parseComment(Object comm) {
        JSONObject comment =  (JSONObject) comm;

        String authorName = (String) comment.get("lessonTitle");
        String commentContent = (String) comment.get("lessonContent");

        List<Comment> replies = new ArrayList<Comment>();

        JSONArray comments = (JSONArray) comment.get("comments");

            for (Object c : comments)
            {
                
            }
    }
}