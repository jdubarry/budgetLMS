import static org.junit.jupiter.api.Assertions.*;

import java.util.UUID;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayNameGenerator.Simple;
import java.util.Date;
import java.util.Date;
import javax.xml.crypto.Data;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class CourseListTester {

    private CourseList courses = CourseList.getInstance();
    private ArrayList<Course> courseArrayList = courses.getCourses();

    @BeforeClass
    public static void oneTimeSetup() {
    Course course = new Course("mikes course", new Author("mike", "cluver", "flowerlover9", "newpassword",
        new java.util.Date(11 / 11 / 11), "8654756543", "mickeymousefan12"));

    }

    @BeforeEach
    public static void setup() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        String dateOfBirth = "11/01/2011";
        Date dob = new Date();
        try {
            dob = dateFormat.parse(dateOfBirth);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Course course = new Course("mikes course", new Author("mike", "cluver", "flowerlover9", "newpassword",
                dob, "8654756543", "mickeymousefan12"));
        courseArrayList.add(course);
                

        DataWriter.writeCourses(courseArrayList);
    }

    @AfterEach
    public static void tearDown() {

    }

    @Test
    public void testAddCourse() {

        assertEquals("mikes course", CourseList.getInstance().getCourseByName("mikes course"));
    }

    public void testGetCourseByName() {
        assertEquals("mikes course", CourseList.getInstance().getCourseByName("mikes course").getCourseName());
    }


    public void testSearchCoursesByName() {
        assertEquals("mikes course", CourseList.getInstance().SearchCoursesByName("mikes").get(0).getCourseName());
    }

    public void testSave() {
        assertEquals("mikes course", CourseList.getInstance().getCourseByName("mikes course"));
    }
    
}
