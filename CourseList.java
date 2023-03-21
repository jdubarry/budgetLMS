package budgetLMS;
import java.util.ArrayList;

public class CourseList {
    private ArrayList<Course> courses;

    private CourseList() {}
    public ArrayList<Course> getInstance() {
        userList = new CourseList();
    }
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

    public Course getCourseByName(String keyword) {
        Course temp = new Course();
        for(Course course: courses) {
            if(course.getCourseName().equals(keyword)) {
                temp = course;
            }
        }
        return temp;
    }

    public Course getCourseByID(UUID courseID) {
        Course temp  = new Course();
        for(Course course: courses) {
            if(course.getCourseID().equals(courseID)) {
                temp = courseID;
            }
        }
        return temp;
    }


    public void addCourse(Course course) {
        courses.add(course);
    }
    public void deleteCourse(Course course) {
        courses.remove(course);
    }

    public void readCoursesJSON() {
        DataWriter.readCourses(courses);
    }

    public void save() {
        DataWriter.writeCourses(courses);
    }
}
