/**
 * This is going to show the user their course progress
 * @author word.exe
 */
import java.util.ArrayList;
import java.util.UUID;

public class CourseProgress {
    private Course course;
    private ArrayList<Double> grades;

    /**
     * This is going to get the course progress and set it
     * @param course the courses being taken
     */
    public CourseProgress(Course course) {
        this.course = course;
        this.grades = new ArrayList<Double>();
    }

    /**
     * This is going to get the course progress and set up the courses and grades
     * @param course this is the course information
     * @param grades this is the grade list
     */
    public CourseProgress(Course course, ArrayList<Double> grades) {
        this.course = course;
        this.grades = grades;
    }

    /**
     * This is going to update the course progress for the user based on their completetion
     */
    public void updateCourseProgress(Double grade) {
        grades.add(grade);
    }

    public Course getCourse() {
        return this.course;
    }

    public ArrayList<Double> getGrades() {
        return this.grades;
    }

}
