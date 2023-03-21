/**
 * This is going to set up the list of courses
 * @author word.exe
 */
import java.util.ArrayList;

public class CourseList {
    private ArrayList<Course> courses;

    private CourseList() {}

    /**
     * This is going to get the instance when the course is used
     * @return the course list
     */
    public ArrayList<Course> getInstance() {
        userList = new CourseList();
    }

    /**
     * This is going to allow for search when looking for courses by name
     * @param keyword the keyword of the word looking up for the course name
     * @return the name of the course
     */
    public ArrayList<Course> SearchCoursesByName(String keyword) {
        Course temp = new Course();
        ArrayList<Course> courseList = new ArrayList<Course>();
        for(Course course: courses) {
            if(course.getCourseName().contains(keyword)) {
                courseList.add(course);
            }
        }
        return temp;
    }

    /**
     * This is going to get the course by name
     * @param keyword the keyword is the word looking up for the course name
     * @return the name of the course
     */
    public Course getCourseByName(String keyword) {
        Course temp = new Course();
        for(Course course: courses) {
            if(course.getCourseName().equals(keyword)) {
                temp = course;
            }
        }
        return temp;
    }

    /**
     * Gets the course by the ID
     * @param courseID the course ID 
     * @return the course based on the ID
     */
    public Course getCourseByID(UUID courseID) {
        Course temp  = new Course();
        for(Course course: courses) {
            if(course.getCourseID().equals(courseID)) {
                temp = courseID;
            }
        }
        return temp;
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
        DataWriter.readCourses(courses);
    }

    /**
     * This is going to save the courses
     */
    public void save() {
        DataWriter.writeCourses(courses);
    }
}
