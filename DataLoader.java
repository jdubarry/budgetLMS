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

    public static ArrayList<User> LoadUsers() {
        JSONParser parser = new JSONParser();
        ArrayList<User> users = new ArrayList<User>();

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

                users.add(new User(firstName,lastName,username,password,dateOfBirth,phone,email));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return users;
    }

    public static ArrayList<Author> LoadAuthors() {
        JSONParser parser = new JSONParser();
        ArrayList<Author> authors = new ArrayList<Author>();

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

                authors.add(new Author(firstName,lastName,username,password,dateOfBirth,phone,email));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return authors;
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
                            // Add the ArrayList later bc lazy now tbh
                            Comment ex = parseComment(c);
                        }
                    }

                    JSONObject quiz =  (JSONObject) module.get("quiz");

                    JSONArray questions = (JSONArray) quiz.get("questions");
                    for (Object q : questions)
                    {
                        JSONObject question =  (JSONObject) q;

                        String questionTitle = (String) question.get("lessonTitle");
                        JSONArray answerChoices = (JSONArray) question.get("answerChoices");

                        ArrayList<String> answers = new ArrayList<String>();
                        for (Object a : answerChoices)
                        {
                            answers.add((String) a);
                        }
                        int correctAnswer = (int) question.get("correctAnswer");
                    }
                }

                JSONArray comments = (JSONArray) json.get("comments");

                for (Object c : comments)
                {
                    // Add the ArrayList later bc lazy now tbh
                    Comment ex = parseComment(c);
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
    private static Comment parseComment(Object comm) {
        if(comm == null) {
            return null;
        }
        
        JSONObject comment =  (JSONObject) comm;
    
        String authorName = (String) comment.get("lessonTitle");
        String commentContent = (String) comment.get("lessonContent");
    
        ArrayList<Comment> replies = new ArrayList<Comment>();
    
        JSONArray comments = (JSONArray) comment.get("comments");
    
        for (Object c : comments)
        {
            replies.add(parseComment(c));
        }
        Comment ret = new Comment(authorName, commentContent);
        for (Comment r : replies)
        {
            ret.reply(r.getName(), r.getContent());
        }
        return ret;
    }
}