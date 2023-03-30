/**
 * This is going to set up the lessons used in the modules
 * @author word.exe
 */
import java.io.*;
import java.util.ArrayList;

public class Lesson {
    private String lessonTitle;
    private String lessonContent;
    private ArrayList<Comment> comments;

    /**
     * This is going to set up a lesson for the modules to use
     * @param title this is going to show the title of the lesson
     */
    public Lesson(String title) {
        lessonTitle = title;
        comments = new ArrayList<Comment>();
    }

    /**
     * This is going to add commment with specific name and content
     * @param authorName the name of the author of the comment
     * @param commentContent the content in the comment
     */
    public void addComment(String authorName, String commentContent) {
        comments.add(new Comment(authorName, commentContent ));
    }

    /**
     * This is going to allow users to add comments on the bottom of lessons
     * @param authorName This is going to show the name of the commenter
     * @param commentContent This is going to show the content in the comment
     */
    public void addComment(Comment comment) {
        comments.add(comment);
    }

    /**
     * This is going to allow the user to view other comments
     */
    public void viewComments() {
        for(Comment x: comments) { 
            x.toString();
        }
    }

    /**
     * This is going to show the comment replies
     * @param commentIndex This is the position at which the comment is in the index
     */
    public void viewCommentReplies(int commentIndex) {

    }

    public void writeToFile() {
        try {
            File file = new File(lessonTitle);
            FileWriter writer = new FileWriter(file);
            writer.write(lessonContent);
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This is going to get the lesson title
     * @return the lesson title
     */
    public String getLessonTitle() {
        return this.lessonTitle;
    }

    /**
     * This is going to set the lesson title
     * @param lessonTitle the lesson title in the lesson
     */
    public void setLessonTitle(String lessonTitle) {
        this.lessonTitle = lessonTitle;
    }

    /**
     * This is going to get the lesson content
     * @return this will return the lesson content
     */
    public String getLessonContent() {
        return this.lessonContent;
    }

    /**
     * This is going to set the lesson content
     * @param lessonContent this is the lesson content 
     */
    public void setLessonContent(String lessonContent) {
        this.lessonContent = lessonContent;
    }

    /**
     * This is going to get the comments
     * @return this will return the comments in the lesson 
     */
    public ArrayList<Comment> getComments() {
        return this.comments;
    }
}
