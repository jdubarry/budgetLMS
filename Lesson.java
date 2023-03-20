/**
 * This is going to set up the lessons used in the modules
 * @author word.exe
 */
package budgetLMS;
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
    }

    public String getLessonTitle() {
        return lessonTitle + "\n";
    }
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
        for(Comment x: comments){ 
            x.toString();
        }
    }

    /**
     * This is going to show the comment replies
     * @param commentIndex This is the position at which the comment is in the index
     */
    public void viewCommentReplies(int commentIndex) {
        
    }


    public String getLessonTitle() {
        return this.lessonTitle;
    }

    public void setLessonTitle(String lessonTitle) {
        this.lessonTitle = lessonTitle;
    }

    public String getLessonContent() {
        return this.lessonContent;
    }

    public void setLessonContent(String lessonContent) {
        this.lessonContent = lessonContent;
    }

    public ArrayList<Comment> getComments() {
        return this.comments;
    }
}
