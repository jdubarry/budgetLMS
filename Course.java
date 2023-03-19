package budgetLMS;
import java.util.ArrayList;
import java.util.UUID;

public class Course {
    private String courseName;
    private java.util.UUID courseID;
    private Author author;
    private ArrayList<Module> modules;
    private ArrayList<Comment> comments;
    private Boolean isPrivate = true;

    public Course(String courseName, Author author, UUID courseID) {
        this.courseName = courseName;
        this.author = author;
        this.courseID = courseID;
    }

    public void addModule(Module module) {
        modules.add(module);
    }

    public void addModule(Module module, int moduleIndex) {
        modules.add(moduleIndex, module);
    }

    public void viewModules() {
        for(Module x: modules) {
            System.out.println(x.getModuleName() + "\n");
        }
    }

    public void selectModule(int moduleIndex) {
        modules.get(moduleIndex);
    }

    public String printCertificate() {
        return "return statement";
    }

    public void publish() {
        isPrivate = false;        
    }

    /**
     * This is going to allow users to add comments on the bottom of lessons
     * @param authorName This is going to show the name of the commenter
     * @param commentContent This is going to show the content in the comment
     */
    public void addComment(Comment comment) {
        comments.add(comment);
    }

    //add in students taking actual course
}
