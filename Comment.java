/**
 * This class is going to allow for commenting and assign users to comments
 * @author word.exe
 */
package budgetLMS;
import java.util.ArrayList;

public class Comment {
    private String authorName;
    private String commentContent;
    private ArrayList<Comment> replies;

    /**
     * This is going to assign comments by author name and the comment content
     * @param authorName The name of the author of the comment
     * @param commentContent The comment content
     */
    public Comment(String authorName, String commentContent) {
        this.authorName = authorName;
        this.commentContent = commentContent;
    }

    /**
     * This is going to allow authors to reply to comments
     * @param replyComment The comment content that is used for the reply
     */
    public void reply(Comment replyComment) {
        
    }

    /**
     * This is going to allow the author to view replies to comments
     */
    public void viewReplies() {

    }

    /**
     * This is going to pull the name of the author 
     * @return the author's name
     */
    public String getName() {
        return this.authorName;
    }

    /**
     * This is going to get the content of the comment
     * @return the content of the comment
     */
    public String getContent() {
        return this.commentContent;
    }

    /**
     * This is going to create a string to return the comment
     * @reutrn the name and the comment content
     */
    public String toString() {
        return this.getName() + "\n"  
        + this.getContent() + "\n";
    }
    
}
