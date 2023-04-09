import static org.junit.jupiter.api.Assertions.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.UUID;
import java.util.ArrayList;

public class DataWriterTest {
	private UserList userList = UserList.getInstance();
    private CourseList courseList = CourseList.getInstance();
	private ArrayList<User> users = userList.getUsers();
    private ArrayList<Author> authors = userList.getAuthors();
    private ArrayList<Course> courses = courseList.getCourses();
    private ArrayList<User> testUsers = userList.getUsers(); // Constant used for comparison
    private ArrayList<Author> testAuthors = userList.getAuthors(); // Constant used for comparison
    private ArrayList<Course> testCourses = courseList.getCourses(); // Constant used for comparison
	
	@BeforeEach
	public void setup() {
		userList.getUsers().clear();
		DataWriter.writeUsers(userList.getUsers());
        userList.getAuthors().clear();
		DataWriter.writeAuthors(userList.getAuthors());
        courseList.getCourses().clear();
		DataWriter.writeCourses(courseList.getCourses());
	}
	
	@AfterEach
	public void tearDown() {
		userList.getUsers().clear();
		DataWriter.writeUsers(userList.getUsers());
        userList.getAuthors().clear();
		DataWriter.writeAuthors(userList.getAuthors());
        courseList.getCourses().clear();
		DataWriter.writeCourses(courseList.getCourses());
	}
	
	
	@Test
	void testWritingZeroUsers() {
		users = DataLoader.loadUsers();
		assertEquals(0, users.size());
	}

	@Test
	void testWritingOneUser() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        String dateOfBirth = "3/13/2003";
        Date dob = new Date();
        try {
            dob = dateFormat.parse(dateOfBirth);
        } catch (Exception e) {
            e.printStackTrace();
        }
		users.add(new User("Daniel", "Chavez","dchavez", "leafblower98",  dob, "874-000-3440", "dchavez@outlook.com"));
		DataWriter.writeUsers(users);
		assertEquals("dchavez", DataLoader.loadUsers().get(0).getUserName());
	}
	
	@Test
	void testWritingFiveUsers() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        String dateOfBirth = "3/13/2003";
        Date dob = new Date();
        try {
            dob = dateFormat.parse(dateOfBirth);
        } catch (Exception e) {
            e.printStackTrace();
        }
		users.add(new User("Daniel", "Chavez","1chavez", "leafblower98",  dob, "874-000-3440", "dchavez@outlook.com"));
        users.add(new User("Daniel", "Chavez","2chavez", "leafblower98",  dob, "874-000-3440", "dchavez@outlook.com"));
        users.add(new User("Daniel", "Chavez","3chavez", "leafblower98",  dob, "874-000-3440", "dchavez@outlook.com"));
        users.add(new User("Daniel", "Chavez","4chavez", "leafblower98",  dob, "874-000-3440", "dchavez@outlook.com"));
        users.add(new User("Daniel", "Chavez","5chavez", "leafblower98",  dob, "874-000-3440", "dchavez@outlook.com"));
		DataWriter.writeUsers(users);
		assertEquals("5chavez", DataLoader.loadUsers().get(4).getUserName());
	}

    @Test
	void testWritingZeroAuthors() {
		authors = DataLoader.loadAuthors();
		assertEquals(0, authors.size());
	}

	@Test
	void testWritingOneAuthor() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        String dateOfBirth = "3/13/2003";
        Date dob = new Date();
        try {
            dob = dateFormat.parse(dateOfBirth);
        } catch (Exception e) {
            e.printStackTrace();
        }
		authors.add(new Author("Brian", "McCaster","bmccaster", "89rewolbfael",  dob, "980-234-2234", "bmccaster@gmail.com"));
		DataWriter.writeAuthors(authors);
		assertEquals("bmccaster", DataLoader.loadAuthors().get(0).getUserName());
	}
	
	@Test
	void testWritingFiveAuthors() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        String dateOfBirth = "3/13/2003";
        Date dob = new Date();
        try {
            dob = dateFormat.parse(dateOfBirth);
        } catch (Exception e) {
            e.printStackTrace();
        }
		authors.add(new Author("Brian", "McCaster","bmccaster1", "89rewolbfael",  dob, "980-234-2234", "bmccaster@gmail.com"));
        authors.add(new Author("Brian", "McCaster","bmccaster2", "89rewolbfael",  dob, "980-234-2234", "bmccaster@gmail.com"));
        authors.add(new Author("Brian", "McCaster","bmccaster3", "89rewolbfael",  dob, "980-234-2234", "bmccaster@gmail.com"));
        authors.add(new Author("Brian", "McCaster","bmccaster4", "89rewolbfael",  dob, "980-234-2234", "bmccaster@gmail.com"));
        authors.add(new Author("Brian", "McCaster","bmccaster5", "89rewolbfael",  dob, "980-234-2234", "bmccaster@gmail.com"));
		DataWriter.writeAuthors(authors);
		assertEquals("bmccaster5", DataLoader.loadAuthors().get(4).getUserName());
	}
	
    @Test
	void testWritingZeroCourses() {
		courses = DataLoader.loadCourses();
		assertEquals(0, courses.size());
	}

    @Test
	void testWritingOneCourse() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        String dateOfBirth = "3/13/2003";
        Date dob = new Date();
        try {
            dob = dateFormat.parse(dateOfBirth);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Author tempAuthor = new Author("Brian", "McCaster","bmccaster", "89rewolbfael",  dob, "980-234-2234", "bmccaster@gmail.com");

        Course tempCourse = new Course("Course", tempAuthor);
            Module tempModule = new Module("Module");
                Lesson tempLesson = new Lesson("Lesson");
                    tempLesson.setLessonContent("Content");
                    Comment tempComment = new Comment("dchavez", "comment");
                        tempComment.reply(new Comment("bmccaster", "reply"));
                    tempLesson.addComment(tempComment);
                tempModule.addLesson(tempLesson);
                Quiz tempQuiz = new Quiz();
                    Question tempQuestion = new Question("Question?");
                        tempQuestion.addAnswer("Answer1");
                        tempQuestion.addAnswer("Answer2");
                        tempQuestion.addAnswer("Answer3");
                        tempQuestion.setCorrectAnswer(2);
                    tempQuiz.addQuestion(tempQuestion);
                tempModule.setQuiz(tempQuiz);
            tempCourse.addModule(tempModule);

        courses.add(tempCourse);
        DataWriter.writeCourses(courses);
		assertEquals("Course", DataLoader.loadCourses().get(0).getCourseName());
    }

    @Test
	void testWritingFiveCourses() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        String dateOfBirth = "3/13/2003";
        Date dob = new Date();
        try {
            dob = dateFormat.parse(dateOfBirth);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Author tempAuthor = new Author("Brian", "McCaster","bmccaster", "89rewolbfael",  dob, "980-234-2234", "bmccaster@gmail.com");

        for(int i = 1; i<6; i++) {
            Course tempCourse = new Course("Course"+i, tempAuthor);
                Module tempModule = new Module("Module");
                    Lesson tempLesson = new Lesson("Lesson");
                        tempLesson.setLessonContent("Content");
                        Comment tempComment = new Comment("dchavez", "comment");
                            tempComment.reply(new Comment("bmccaster", "reply"));
                        tempLesson.addComment(tempComment);
                    tempModule.addLesson(tempLesson);
                    Quiz tempQuiz = new Quiz();
                        Question tempQuestion = new Question("Question?");
                            tempQuestion.addAnswer("Answer1");
                            tempQuestion.addAnswer("Answer2");
                            tempQuestion.addAnswer("Answer3");
                            tempQuestion.setCorrectAnswer(2);
                        tempQuiz.addQuestion(tempQuestion);
                    tempModule.setQuiz(tempQuiz);
                tempCourse.addModule(tempModule);

            courses.add(tempCourse);
        }
        DataWriter.writeCourses(courses);
		assertEquals("Course5", DataLoader.loadCourses().get(4).getCourseName());
    }
}