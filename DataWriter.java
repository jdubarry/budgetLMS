import java.io.*;
import java.util.ArrayList;
import java.util.UUID;
import java.util.Date;
import java.text.SimpleDateFormat;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * Jordan's super swaggin Data Writer class 100
 */
public class DataWriter {
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

    public static void writeUsers(ArrayList<User> users) {
        try {     
            JSONArray allUsers = new JSONArray();
            for(User user : users) {
                JSONObject userToAdd = new JSONObject();
                userToAdd.put("id", user.getUserID().toString());
                userToAdd.put("firstName", user.getFirstName());
                userToAdd.put("lastName", user.getLastName());
                userToAdd.put("email", user.getEmailAddress());
                userToAdd.put("phone", user.getPhoneNumber());
                userToAdd.put("dateOfBirth", dateFormat.format(user.getDateOfBirth()));
                userToAdd.put("userName", user.getUserName());
                userToAdd.put("password", user.getPassword());
                JSONArray courses = new JSONArray();
                for (CourseProgress course : user.getCourseProgress()) {
                    JSONObject courseToAdd = new JSONObject();
                    courseToAdd.put("moduleName", course.getCourse().getCourseID());
                    courseToAdd.put("grades", course.getGrades());
                }
                userToAdd.put("courses", courses);

                allUsers.add(userToAdd);
            }
            File file = new File("json/users.json");
            FileWriter writer = new FileWriter(file);
            writer.write(allUsers.toJSONString());
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void writeAuthors(ArrayList<Author> authors) {
        try {     
            JSONArray allAuthors = new JSONArray();
            for(Author author : authors) {
                JSONObject authorToAdd = new JSONObject();
                authorToAdd.put("id", author.getUserID().toString());
                authorToAdd.put("firstName", author.getFirstName());
                authorToAdd.put("lastName", author.getLastName());
                authorToAdd.put("email", author.getEmailAddress());
                authorToAdd.put("phone", author.getPhoneNumber());
                authorToAdd.put("dateOfBirth", dateFormat.format(author.getDateOfBirth()));
                authorToAdd.put("userName", author.getUserName());
                authorToAdd.put("password", author.getPassword());
                JSONArray courses = new JSONArray();
                for (CourseProgress course : author.getCourseProgress()) {
                    JSONObject courseToAdd = new JSONObject();
                    courseToAdd.put("moduleName", course.getCourse().getCourseID());
                    courseToAdd.put("grades", course.getGrades());
                }
                authorToAdd.put("courses", courses);

                allAuthors.add(authorToAdd);
            }
            File file = new File("json/authors.json");
            FileWriter writer = new FileWriter(file);
            writer.write(allAuthors.toJSONString());
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void writeCourses(ArrayList<Course> courses) {
        try {     
            JSONArray allCourses = new JSONArray();
            for(Course course : courses) {
                JSONObject courseToAdd = new JSONObject();
                courseToAdd.put("id", course.getCourseID().toString());
                courseToAdd.put("courseName", course.getCourseName());
                courseToAdd.put("authorID", course.getAuthor().getUserID().toString());

                JSONArray modules = new JSONArray();
                for (Module module : course.getModules()) {
                    JSONObject moduleToAdd = new JSONObject();
                    moduleToAdd.put("moduleName", module.getModuleName());
                    JSONArray lessons = new JSONArray();
                    for (Lesson lesson : module.getLessons()) {
                        JSONObject lessonToAdd = new JSONObject();
                        lessonToAdd.put("lessonName", lesson.getLessonTitle());
                        lessonToAdd.put("lessonContent", lesson.getLessonTitle());
                        JSONArray comments = new JSONArray();
                        for (Comment comment: lesson.getComments()) {
                            JSONObject commentToAdd = writeComment(comment);
                            comments.add(commentToAdd);
                        }
                        lessonToAdd.put("comments", comments);
                        lessons.add(lessonToAdd);
                    }
                    moduleToAdd.put("lessons", lessons);
                    JSONObject quiz = writeQuiz(module.getQuiz());
                    moduleToAdd.put("quiz", quiz);
                    modules.add(moduleToAdd);
                }
                courseToAdd.put("modules", modules);
                JSONArray comments = new JSONArray();
                for (Comment comment: course.getComments()) {
                    JSONObject commentToAdd = writeComment(comment);
                    comments.add(commentToAdd);
                }
                courseToAdd.put("comments", comments);
                allCourses.add(courseToAdd);
            }
            File file = new File("json/courses.json");
            FileWriter writer = new FileWriter(file);
            writer.write(allCourses.toJSONString());
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static JSONObject writeComment(Comment comm) {
        if(comm == null) {
            return null;
        }
        
        JSONObject comment =  new JSONObject();
    
        comment.put("user", comm.getAuthorName());
        comment.put("commentContent", comm.getCommentContent());
        JSONArray replies = new JSONArray();
        for (Comment c: comm.getReplies()) {
            JSONObject replyToAdd = writeComment(c);
            replies.add(replyToAdd);
        }
        comment.put("replies", replies);
        return comment;
    }
    private static JSONObject writeQuiz(Quiz quiz) {
        if(quiz == null) {
            return null;
        }
        
        JSONObject ret = new JSONObject();
    
        JSONArray questions = new JSONArray();
        for (Question q : quiz.getQuestions()) {
            JSONObject question = new JSONObject();
            question.put("questionTitle", q.getQuestionTitle());
            JSONArray answerChoices = new JSONArray();
            for (String a : q.getAnswerChoices()) {
                answerChoices.add(a);        
            }
            question.put("answerChoices", answerChoices);
            question.put("correctAnswer", String.valueOf(q.getCorrectAnswer()));
            questions.add(question);
        }
        ret.put("questions", questions);
        return ret;
    }
}