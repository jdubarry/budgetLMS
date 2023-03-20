package budgetLMS;
import java.util.ArrayList;

public class Comment {
    private String authorName;
    private String commentContent;
    private ArrayList<Comment> replies;

    public Comment(String authorName, String commentContent) {
        this.authorName = authorName;
        this.commentContent = commentContent;
    }
    public void reply(Comment replyComment) {
        
    }
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
}
