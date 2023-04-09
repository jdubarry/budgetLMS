import static org.junit.jupiter.api.Assertions.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Date;

public class CourseListTester {

    private CourseList courses = CourseList.getInstance();
    private ArrayList<Course> courseList = courses.getCourses();

    @BeforeEach
    public void setup() {
        courseList.clear();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        String dateOfBirth = "11/01/2011";
        Date dob = new Date();
        try {
            dob = dateFormat.parse(dateOfBirth);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Course tempCourse = new Course("mikes course", new Author("mike", "cluver", "flowerlover9", "newpassword",
                dob, "8654756543", "mickeymousefan12"));
        courseList.add(tempCourse);
                
        DataWriter.writeCourses(courseList);
    }

    @AfterEach
    public void tearDown() {
        CourseList.getInstance().getCourses().clear();
        DataWriter.writeCourses(courseList);
    }

    @Test
    public void testAddCourse() {

        assertEquals("mikes course", CourseList.getInstance().getCourseByName("mikes course"));
    }

    @Test
    public void testGetCourseByName() {
        assertEquals("mikes course", CourseList.getInstance().getCourseByName("mikes course").getCourseName());
    }

    @Test
    public void testSearchCoursesByName() {
        assertEquals("mikes course", CourseList.getInstance().SearchCoursesByName("mikes").get(0).getCourseName());
    }

    @Test
    public void testSave() {
        assertEquals("mikes course", CourseList.getInstance().getCourseByName("mikes course"));
    }
    
}
