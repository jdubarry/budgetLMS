package budgetLMS;
import java.util.ArrayList;

public class Course {
    private String courseName;
    private java.util.UUID CourseID;
    private Author author;
    private ArrayList<Module> modules;
    private ArrayList<Comment> comments;
    private Boolean isPrivate;

    public Course(String courseName, Author author) {
        this.courseName = courseName;
        this.author = author;
    }
    public void addModule(int moduleIndex) {

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
    //add in students taking actual course
}
