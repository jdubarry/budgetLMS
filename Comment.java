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
    public void reply(String authorName, String commentContent) {
        this.authorName = authorName;
        this.commentContent = commentContent;
        //check
    }
    public void viewReplies() {

    }
    public String getName() {
        return this.authorName;
    }
    public String getContent() {
        return this.commentContent;
    }
}
