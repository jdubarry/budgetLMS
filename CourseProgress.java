/**
 * This is going to show the user their course progress
 * @author word.exe
 */
import java.util.ArrayList;
import java.util.UUID;

public class CourseProgress {
    private Course course;
    private ArrayList<Double> grades;

    public CourseProgress(Course course) {
        this.course = course;
        this.grades = new ArrayList<Double>();
    }

    public CourseProgress(Course course, ArrayList<Double> grades) {
        this.course = course;
        this.grades = grades;
    }

    /**
     * This is going to update the course progress for the user based on their completetion
     */
    public void updateCourseProgress() {

    }

    /**
     * This is going to set up grades per each module completetion
     * @return the grade of their modules
     */
    public double[] gradesPerModule() {
        return null;
    }


    public Course getCourse() {
        return this.course;
    }

    public ArrayList<Double> getGrades() {
        return this.grades;
    }

}
