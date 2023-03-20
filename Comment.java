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
    
    public String getAuthorName() {
        return this.authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getCommentContent() {
        return this.commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public ArrayList<Comment> getReplies() {
        return this.replies;
    }

    /**
     * This is going to create a string to return the comment
     * @reutrn the name and the comment content
     */
    public String toString() {
        return this.getAuthorName() + "\n"  
        + this.getCommentContent() + "\n";
    }
    
}
