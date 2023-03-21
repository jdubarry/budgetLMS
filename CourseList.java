import java.util.ArrayList;
import java.util.UUID;

public class CourseList {
    private static CourseList courseList;
    private ArrayList<Course> courses;

    private CourseList() {}
    public CourseList getInstance() {
        if(courseList == null) {
            courseList = new CourseList();
        }
        return courseList;
    }
    public ArrayList<Course> SearchCoursesByName(String keyword) {
        ArrayList<Course> courseList = new ArrayList<Course>();
        for(Course course: courses) {
            if(course.getCourseName().contains(keyword)) {
                courseList.add(course);
            }
        }
        return courseList;
    }

    public Course getCourseByName(String keyword) {
        for(Course course: courses) {
            if(course.getCourseName().equals(keyword)) {
                return course;
            }
        }
        return null;
    }

    public Course getCourseByID(UUID courseID) {
        for(Course course: courses) {
            if(course.getCourseID().equals(courseID)) {
                return course;
            }
        }
        return null;
    }


    public void addCourse(Course course) {
        courses.add(course);
    }
    public void deleteCourse(Course course) {
        courses.remove(course);
    }

    public void readCoursesJSON() {
        this.courses = DataLoader.loadCourses();
    }

    public void save() {
        DataWriter.writeCourses(courses);
    }
}
