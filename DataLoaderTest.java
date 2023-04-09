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

/**
 * Jordan's very cool DataLoader Tester
 */
public class DataLoaderTest {
	private UserList userList = UserList.getInstance();
    private CourseList courseList = CourseList.getInstance();
	private ArrayList<User> users = userList.getUsers();
    private ArrayList<Author> authors = userList.getAuthors();
    private ArrayList<Course> courses = courseList.getCourses();
	
	@BeforeEach
	public void setup() {
		users.clear();
        authors.clear();
        courses.clear();

        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        String dateOfBirth = "3/13/2003";
        Date dob = new Date();
        try {
            dob = dateFormat.parse(dateOfBirth);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        User tempUser = new User("Daniel", "Chavez","dchavez", "leafblower98",  dob, "874-000-3440", "dchavez@outlook.com");

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

        ArrayList<CourseProgress> tempCourseProgress = new ArrayList<CourseProgress>();
        tempCourseProgress.add(new CourseProgress(tempCourse));

        tempUser.setCourseProgress(tempCourseProgress);
        users.add(tempUser);

        tempAuthor.setCourseProgress(tempCourseProgress);
        authors.add(tempAuthor);

        DataWriter.writeCourses(courses);
        DataWriter.writeUsers(users);
        DataWriter.writeAuthors(authors);
	}
	
	@AfterEach
	public void tearDown() {
		users.clear();
        DataWriter.writeUsers(users);
        authors.clear();
        DataWriter.writeAuthors(authors);
        courses.clear();
        DataWriter.writeCourses(courses);
	}
	
	
	@Test
	void testGetUsersSize() {
		assertEquals(1, DataLoader.loadUsers().size());
	}

    @Test
	void testGetAuthorsSize() {
		assertEquals(1, DataLoader.loadAuthors().size());
	}

    @Test
	void testGetCoursesSize() {
		assertEquals(1, DataLoader.loadCourses().size());
	}

	@Test
	void testGetUsersSizeZero() {
		users.clear();
		DataWriter.writeUsers(users);
		assertEquals(0, DataLoader.loadUsers().size());
	}

    @Test
	void testGetAuthorsSizeZero() {
		authors.clear();
		DataWriter.writeAuthors(authors);
		assertEquals(0, DataLoader.loadAuthors().size());
	}

    @Test
	void testGetCoursesSizeZero() {
		courses.clear();
		DataWriter.writeCourses(courses);
		assertEquals(0, DataLoader.loadCourses().size());
	}
	
	@Test
	void testUserLoad() {
		assertEquals("dchavez", DataLoader.loadUsers().get(0).getUserName());
	}

    @Test
	void testAuthorLoad() {
        assertEquals("bmccaster", DataLoader.loadAuthors().get(0).getUserName());
	}

    @Test
	void testCourseLoad() {
		assertEquals("Course", DataLoader.loadCourses().get(0).getCourseName());
	}

    @Test
	void testUserCourseProgress() {
        userList.readUsersJSON();
		assertEquals("Course", DataLoader.loadUsersCourseProgress(userList).get(0).getCourseProgress().get(0).getCourse().getCourseName());
	}

    @Test
	void testAuthorLoadCourseProgress() {
        userList.readAuthorsJson();
		assertEquals("Course", DataLoader.loadAuthorsCourseProgress(userList).get(0).getCourseProgress().get(0).getCourse().getCourseName());
	}
}