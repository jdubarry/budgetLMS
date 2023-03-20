package budgetLMS;
import java.util.ArrayList;
import java.util.UUID;

public class Course {
    private String courseName;
    private java.util.UUID courseID;
    private Author author;
    private ArrayList<Module> modules;
    private ArrayList<Comment> comments;
    private Boolean isPrivate;

    public Course(String courseName, Author author) {
        this.courseName = courseName;
        this.author = author;
    }

    public Course(String courseName, Author author, UUID courseID) {
        this.courseName = courseName;
        this.author = author;
        this.courseID = courseID;
    }

    public void addModule(Module module) {
        this.modules.add(module);
    }

    public void addModule(Module module, int moduleIndex) {

    }

    public void viewModules() {

    }

    public void selectModule(int moduleIndex) {

    }

    public String printCertificate() {
        return "return statement";
    }

    public void publish() {
        
    }

    /**
     * This is going to allow users to add comments on the bottom of lessons
     * @param authorName This is going to show the name of the commenter
     * @param commentContent This is going to show the content in the comment
     */
    public void addComment(Comment comment) {
        
    }

    //add in students taking actual course


    public String getCourseName() {
        return this.courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public java.util.UUID getCourseID() {
        return this.courseID;
    }

    public Author getAuthor() {
        return this.author;
    }

    public ArrayList<Module> getModules() {
        return this.modules;
    }

    public ArrayList<Comment> getComments() {
        return this.comments;
    }

    public Boolean getIsPrivate() {
        return this.isPrivate;
    }

    public void setIsPrivate(Boolean isPrivate) {
        this.isPrivate = isPrivate;
    }
}
