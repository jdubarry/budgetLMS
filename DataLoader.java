import java.io.*;
import java.util.ArrayList;
import java.util.UUID;
import java.util.Date;
import java.text.SimpleDateFormat;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Jordan's super swaggin Data Loader class
 */
public class DataLoader {

    /**
     * Loads in list of users from the users.json file. Dooes not load in courseProgress
     * @return ArrayList of users in the json file
     */
    public static ArrayList<User> loadUsers() {
        JSONParser parser = new JSONParser();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        ArrayList<User> users = new ArrayList<User>();

        try {     
            JSONArray arr = (JSONArray) parser.parse(new FileReader("json/users.json"));
            
            for(Object obj : arr) {
                JSONObject json =  (JSONObject) obj;

                UUID id = UUID.fromString(json.get("id").toString());
                String firstName = (String) json.get("firstName");
                String lastName = (String) json.get("lastName");
                String email = (String) json.get("email");
                String phone = (String) json.get("phone");
                String username = (String) json.get("userName");
                String password = (String) json.get("password");
                Date dateOfBirth = null;
                try {
                    dateOfBirth = dateFormat.parse((String) json.get("dateOfBirth"));
                } catch (Exception e) {
                    e.printStackTrace();
                }

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

    /**
     * Loads in courseProgress for all users
     * @param users list of users to load CourseProgress for
     * @return ArrayList of users with their associated courseProgress in the json file
     */
    public static ArrayList<User> loadUsersCourseProgress(UserList users) {
        JSONParser parser = new JSONParser();

        try {     
            JSONArray arr = (JSONArray) parser.parse(new FileReader("json/users.json"));
            
            for(Object obj : arr) {
                JSONObject json =  (JSONObject) obj;

                UUID id = UUID.fromString(json.get("id").toString());
                
                JSONArray courses = (JSONArray) json.get("courses");
                ArrayList<CourseProgress> coursesToAdd = new ArrayList<CourseProgress>();

                for (Object c : courses)
                {
                    JSONObject course =  (JSONObject) c;

                    UUID courseID = UUID.fromString(course.get("courseID").toString());
                    JSONArray grades = (JSONArray) course.get("grades");
                    ArrayList<Double> gradesToAdd = new ArrayList<Double>();

                        for (Object g : grades)
                        {
                            gradesToAdd.add((Double) g); //DONT SCREW THIS UP JORDAN
                        }
                    coursesToAdd.add(new CourseProgress(CourseList.getInstance().getCourseByID(courseID), gradesToAdd));
                }
                users.getUserByID(id).setCourseProgress(coursesToAdd);
            }
            return users.getUsers();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Loads in list of authors from the authors.json file. Dooes not load in courseProgress
     * @return ArrayList of authors in the json file
     */
    public static ArrayList<Author> loadAuthors() {
        JSONParser parser = new JSONParser();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        ArrayList<Author> authors = new ArrayList<Author>();

        try {     
            JSONArray arr = (JSONArray) parser.parse(new FileReader("json/authors.json"));
            
            for(Object obj : arr) {
                JSONObject json =  (JSONObject) obj;

                UUID id = UUID.fromString(json.get("id").toString());
                String firstName = (String) json.get("firstName");
                String lastName = (String) json.get("lastName");
                String email = (String) json.get("email");
                String phone = (String) json.get("phone");
                String username = (String) json.get("userName");
                String password = (String) json.get("password");
                Date dateOfBirth = null;
                try {
                    dateOfBirth = dateFormat.parse((String) json.get("dateOfBirth"));
                } catch (Exception e) {
                    e.printStackTrace();
                }

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

    /**
     * Loads in courseProgress for all authors
     * @param users list of authors to load CourseProgress for
     * @return ArrayList of Authors with their associated courseProgress in the json file
     */
    public static ArrayList<Author> loadAuthorsCourseProgress(UserList authors) {
        JSONParser parser = new JSONParser();

        try {     
            JSONArray arr = (JSONArray) parser.parse(new FileReader("json/authors.json"));
            
            for(Object obj : arr) {
                JSONObject json =  (JSONObject) obj;

                UUID id = UUID.fromString(json.get("id").toString());
                
                JSONArray courses = (JSONArray) json.get("courses");
                ArrayList<CourseProgress> coursesToAdd = new ArrayList<CourseProgress>();

                for (Object c : courses)
                {
                    JSONObject course =  (JSONObject) c;

                    UUID courseID = UUID.fromString(course.get("courseID").toString());
                    JSONArray grades = (JSONArray) course.get("grades");
                    ArrayList<Double> gradesToAdd = new ArrayList<Double>();

                        for (Object g : grades)
                        {
                            gradesToAdd.add(Double.parseDouble((String) g));
                        }
                    coursesToAdd.add(new CourseProgress(CourseList.getInstance().getCourseByID(courseID), gradesToAdd));
                }
                authors.getAuthorByID(id).setCourseProgress(coursesToAdd);
            }
            return authors.getAuthors();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Loads in all courses from the courses.json file
     * @return ArrayList of courses from the json file
     */
    public static ArrayList<Course> loadCourses() {
        JSONParser parser = new JSONParser();
        ArrayList<Course> courses = new ArrayList<Course>();

        try {     
            JSONArray arr = (JSONArray) parser.parse(new FileReader("json/courses.json"));

            for(Object obj : arr) {
                JSONObject json =  (JSONObject) obj;

                UUID id = UUID.fromString(json.get("id").toString());
                String courseName = (String) json.get("courseName");
                UUID authorID = UUID.fromString(json.get("authorID").toString());

                Course courseToAdd = new Course(courseName, UserList.getInstance().getAuthorByID(authorID), id);

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

                        String lessonTitle = (String) lesson.get("lessonName");
                        Lesson lessonToAdd = new Lesson(lessonTitle);

                        lessonToAdd.setLessonContent((String) lesson.get("lessonContent"));

                        JSONArray comments = (JSONArray) lesson.get("comments");

                        for (Object c : comments)
                        {
                            lessonToAdd.addComment(parseComment(c));
                        }

                        moduleToAdd.addLesson(lessonToAdd);
                    }

                    JSONObject quiz = (JSONObject) module.get("quiz");
                    Quiz quizToAdd = new Quiz();
                    JSONArray questions = (JSONArray) quiz.get("questions");
                    for (Object q : questions)
                    {
                        JSONObject question =  (JSONObject) q;

                        String questionTitle = (String) question.get("questionTitle");
                        Question questionToAdd = new Question(questionTitle);

                        JSONArray answerChoices = (JSONArray) question.get("answerChoices");

                        for (Object a : answerChoices)
                        {
                            questionToAdd.addAnswer((String) a);
                        }
                        int correctAnswer = Integer.parseInt((String) question.get("correctAnswer"));
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

                courses.add(courseToAdd);
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

    /**
     * Used for loading in comments recursively
     */
    private static Comment parseComment(Object comm) {
        if(comm == null) {
            return null;
        }
        
        JSONObject comment =  (JSONObject) comm;
    
        String user = (String) comment.get("user");
        String commentContent = (String) comment.get("commentContent");
        Comment ret = new Comment(user, commentContent);
    
        JSONArray comments = (JSONArray) comment.get("replies");
    
        for (Object c : comments)
        {
            ret.reply(parseComment(c));
        }

        return ret;
    }
}