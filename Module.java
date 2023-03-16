/**
 * This is going to set up modules to be accessed by the user
 * @author word.exe
 */
package budgetLMS;
import java.util.ArrayList;

public class Module {
    private String moduleName;
    private ArrayList<Lesson> lessons;
    private Quiz quiz;

    /**
     * This is going to set up modules for the user to use
     * @param moduleName this is the name of the module created
     */
    public Module(String moduleName) {
        this.moduleName = moduleName;
    }

    /**
     * This will add in lessons to the modules for the user to user
     * @param title this is going to be the title of the lesson 
     */
    public void addLesson(String title) {
        
    }

    /**
     * This is going to allow a user to view the lesson in a module
     */
    public void viewLessons() {

    }

    /**
     * This is going to allow the user to select the lesson they want to view
     * @param lessonIndex this is going to put the lesson in an index to be pulled from later
     */
    public void selectLesson(int lessonIndex) {
        
    }
}
