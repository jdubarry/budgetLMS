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
     * This is going to add a lesson to a module
     * @param title the title of the lesson
     */
    public void addLesson(String title) {
        lessons.add(new Lesson(title));
    }

    /**
     * This will add in lessons to the modules for the user to user
     * @param lesson Lesson to be added
     */
    public void addLesson(Lesson lesson) {
        lessons.add(lesson);        

    }

    /**
     * This is going to allow a user to view the lesson in a module
     */
    public void viewLessons() {
        for(Lesson x: lessons) {
            x.getLessonTitle();
        }
    }

    /**
     * This is going to allow the user to select the lesson they want to view
     * @param lessonIndex this is going to put the lesson in an index to be pulled from later
     */
    public void selectLesson(int lessonIndex) {
        lessons.get(lessonIndex);
    }

    /**
     * This is going to set up quizzes in modules
     * @param quiz the quiz the user can take
     */
    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    /**
     * This is going to pull the module name
     * @return the module name
     */
    public String getModuleName() {
        return moduleName;
    }
}
