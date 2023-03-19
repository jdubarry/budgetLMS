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

                users.add(new User(firstName, lastName, username, password, id, dateOfBirth, phone, email));
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

                authors.add(new Author(firstName, lastName, username, password, id, dateOfBirth, phone, email));
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

    public static ArrayList<Course> LoadCourses() {
        JSONParser parser = new JSONParser();
        ArrayList<Course> courses = new ArrayList<Course>();

        try {     
            JSONArray arr = (JSONArray) parser.parse(new FileReader("json/users.json"));

            for(Object obj : arr) {
                JSONObject json =  (JSONObject) obj;

                UUID id = (UUID) (json.get("id"));
                String courseName = (String) json.get("courseName");
                UUID authorID = (UUID) (json.get("authorID"));

                Course courseToAdd = new Course(courseName, UserList.getUserList().getAuthorByID(authorID), id);

                JSONArray modules = (JSONArray) json.get("modules");

                for (Object m : modules)
                {
                    JSONObject module =  (JSONObject) m;

                    String moduleName = (String) module.get("moduleName");
                    Module moduleToAdd = new Module(moduleName);

                    JSONArray lessons = (JSONArray) module.get("lessons");

                    for (Object l : lessons)
                    {
                        JSONObject lesson =  (JSONObject) l;

                        String lessonTitle = (String) lesson.get("lessonTitle");
                        Lesson lessonToAdd = new Lesson(lessonTitle);

                        lessonToAdd.setLessonContent((String) lesson.get("lessonContent"));

                        JSONArray comments = (JSONArray) lesson.get("comments");

                        for (Object c : comments)
                        {
                            lessonToAdd.addComment(parseComment(c));
                        }

                        moduleToAdd.addLesson(lessonToAdd);
                    }

                    JSONObject quiz =  (JSONObject) module.get("quiz");
                    Quiz quizToAdd = new Quiz();
                    JSONArray questions = (JSONArray) quiz.get("questions");
                    for (Object q : questions)
                    {
                        JSONObject question =  (JSONObject) q;

                        String questionTitle = (String) question.get("lessonTitle");
                        Question questionToAdd = new Question(questionTitle);

                        JSONArray answerChoices = (JSONArray) question.get("answerChoices");

                        for (Object a : answerChoices)
                        {
                            questionToAdd.addAnswer((String) a);
                        }
                        int correctAnswer = (int) question.get("correctAnswer");
                        questionToAdd.setCorrectAnswer(correctAnswer);
                        
                        quizToAdd.addQuestion(questionToAdd);
                    }
                    moduleToAdd.setQuiz(quizToAdd);
                    courseToAdd.addModule(moduleToAdd);
                }

                JSONArray comments = (JSONArray) json.get("comments");

                for (Object c : comments)
                {
                    courseToAdd.addComment(parseComment(c));
                }
            }
        } 
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } 
        catch (IOException e) {
            e.printStackTrace();
        } 
        catch (ParseException e) {
            e.printStackTrace();
        }
        return courses;
    }
    private static Comment parseComment(Object comm) {
        if(comm == null) {
            return null;
        }
        
        JSONObject comment =  (JSONObject) comm;
    
        UUID userID = (UUID) comment.get("userid");
        String commentContent = (String) comment.get("commentContent");
        Comment ret = new Comment(UserList.getUserList().getUserByID(userID).getUsername(), commentContent);
    
        JSONArray comments = (JSONArray) comment.get("replies");
    
        for (Object c : comments)
        {
            ret.reply(parseComment(c));
        }

        return ret;
    }
}