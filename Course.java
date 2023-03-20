/**
 * This class is going to set up the courses
 * @author word.exe
 */
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

    /**
     * This is going to set up a specific course with the name author and id
     * @param courseName This is going to be the name of the course
     * @param author This is going to be the author of the course
     * @param courseID This is going to be the ID of the course
     */
    public Course(String courseName, Author author, UUID courseID) {
        this.courseName = courseName;
        this.author = author;
        this.courseID = courseID;
    }

    /**
     * This is going to add modules to each course
     * @param module the content inside the courses
     */
    public void addModule(Module module) {
        modules.add(module);
    }

    /**
     * This is going to add modules to the index
     * @param module The module is the content inside the courses
     * @param moduleIndex the position at which the module is inside the index
     */
    public void addModule(Module module, int moduleIndex) {
        modules.add(moduleIndex, module);
    }

    /**
     * This is going to allow a user to view the modules in the course
     */
    public void viewModules() {
        for(Module x: modules) {
            System.out.println(x.getModuleName() + "\n");
        }
    }

    /**
     * This is going to allow the user to select a module
     * @param moduleIndex this is the index position at which the module is located
     */
    public void selectModule(int moduleIndex) {
        modules.get(moduleIndex);
    }

    /**
     * This is going to print the certificate of completion
     * @return the return statement of congratulations
     */
    public String printCertificate() {
        return "return statement";
    }

    /**
     * This is going to publish the course for users to use
     */
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
