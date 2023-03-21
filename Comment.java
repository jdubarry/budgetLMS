/**
 * This class is going to allow for commenting and assign users to comments
 * @author word.exe
 */
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
     * This is going to pull the authors name of the comment
     * @return the authors name is returned
     */
    public String getAuthorName() {
        return this.authorName;
    }

    /**
     * This is going to set the authors name 
     * @param authorName the name of the author as a string
     */
    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    /**
     * This is going to get the content of the comment
     * @return the comment content
     */
    public String getCommentContent() {
        return this.commentContent;
    }

    /**
     * This is going to set the comment content
     * @param commentContent the content of the comment
     */
    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    /**
     * This is going to get the replies to the comment as a list
     * @return the replies
     */
    public ArrayList<Comment> getReplies() {
        return this.replies;
    }

    /**
     * This is going to create a string to return the comment
     * @return the name and the comment content
     */
    public String toString() {
        return this.getAuthorName() + "\n"  
        + this.getCommentContent() + "\n";
    }
    
}
