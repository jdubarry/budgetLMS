/**
 * This is going to set up the list of courses
 * @author word.exe
 */
import java.util.ArrayList;
import java.util.UUID;

public class CourseList {
    private static CourseList courseList;
    private ArrayList<Course> courses;

    /**
     * This is going to get the arraylist for course and set it to courses
     */
    private CourseList() {
        this.courses = new ArrayList<Course>();
    }

    /**
     * This is going to get the instance of when the course list is used
     * @return the course list is returned
     */
    public static CourseList getInstance() {
        if(courseList == null) {
            courseList = new CourseList();
        }
        return courseList;
    }

    /**
     * This is going to allow for search when looking for courses by name
     * @param keyword the keyword of the word looking up for the course name
     * @return the name of the course
     */
    public ArrayList<Course> SearchCoursesByName(String keyword) {
        ArrayList<Course> courseList = new ArrayList<Course>();
        for(Course course: courses) {
            if(course.getCourseName().contains(keyword)) {
                courseList.add(course);
            }
        }
        return courseList;
    }

    /**
     * This is going to get the course by name
     * @param keyword the keyword is the word looking up for the course name
     * @return the name of the course
     */
    public Course getCourseByName(String keyword) {
        for(Course course: courses) {
            if(course.getCourseName().equals(keyword)) {
                return course;
            }
        }
        return null;
    }

    /**
     * Gets the course by the ID
     * @param courseID the course ID 
     * @return the course based on the ID
     */
    public Course getCourseByID(UUID courseID) {
        for(Course course: courses) {
            if(course.getCourseID().equals(courseID)) {
                return course;
            }
        }
        return null;
    }

    /**
     * This is going to add in the courses
     * @param course the course being used
     */
    public void addCourse(Course course) {
        courses.add(course);
    }

    /**
     * This is going to delete the course
     * @param course the course being used
     */
    public void deleteCourse(Course course) {
        courses.remove(course);
    }
    
    /**
     * This is going to read the courses from the JSON file
     */
    public void readCoursesJSON() {
        this.courses = DataLoader.loadCourses();
    }

    /**
     * This is going to save the courses
     */
    public void save() {
        DataWriter.writeCourses(courses);
    }

    /**
     * This is going to get the courses based on the list of courses
     * @return the course
     */
    public ArrayList<Course> getCourses() {
        return this.courses;
    }

    public String toString() {
        if(this.courses.isEmpty()) {
            return "NO COURSES";
        }
        String ret = "";
        for(Course course : courses) {
            ret += course.toString() + '\n';
        }
        return ret;
    }
}
