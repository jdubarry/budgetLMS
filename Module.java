package budgetLMS;
import java.util.ArrayList;

public class Module {
    private String moduleName;
    private ArrayList<Lesson> lessons;
    private Quiz quiz;

    public Module(String moduleName) {
        this.moduleName = moduleName;
    }
    public void addLesson(String title) {
    lessons.add(title);
    }
    public void viewLessons() {
        for(Lesson x: lessons) {
            x.getLessonTitle();
        }
    }
    public void selectLesson(int lessonIndex) {
        lessons.get(lessonIndex);
    }
}
