/**
 * This is going to be the main page for the program of the LMS application
 * @author word.exe
 */

public class LMSApplication {
    private User currentUser;
    private UserList userList;
    private CourseList courseList;
    private static LMSApplication lmsApplication;

    /**
     * This is going to get the instances when user list and course list are being used
     */
    private LMSApplication() {
        this.currentUser = null;
        this.userList = UserList.getInstance();
        this.courseList = CourseList.getInstance();
    }

    /**
     * This is going to get the new instance of when LMSApplication is used
     * @return the instance of lms application is returned
     */
    public static LMSApplication getInstance() {
        if(lmsApplication == null) {
            lmsApplication = new LMSApplication();
        }
        return lmsApplication;
    }
    /**
     * This is the login the user is going to input
     * @param user the user information, password, username
     */
    public void login(User user) {
        
    }

    /**
     * This is going to log out the users
     * @param user the user information, password, username
     */
    public void logout(User user) {

    }

    /**
     * This is going to start a specific course for a user to access
     * @param user This is the user information, password, username
     * @param course This is the course information 
     */
    public void startCourse(User user, Course course) {

    }

    /**
     * This is the current course the user is in
     * @return will return the course the user is currently in 
     */
    public Course currentCourse() {
        return null;
    }

    /**
     * This is going to allow an author to make a course
     */
    public void makeCourse() {

    }

    /**
     * This is going to allow a user to take a quiz
     */
    public void takeQuiz() {

    }

    /**
     * This is going to load in the json files
     */
    public void loadJSONS() {
        userList.readUsersJSON();
        userList.readAuthorsJson();
        courseList.readCoursesJSON();
        userList.readUsersCoursesJSON();
        userList.readAuthorsCoursesJSON();
    }

    /*
     * JORDAN'S VERY IMPORTANT DEBUGGING METHOD DO NOT TOUCH
     */
    public void printData() {
        System.out.println("ALL OF THE USERS");
        System.out.println(userList.usersToString());
        System.out.println();
        System.out.println("ALL OF THE AUTHORS");
        System.out.println(userList.authorsToString());
        System.out.println();
        System.out.println("ALL OF THE COURSES");
        System.out.println(courseList.toString());
    }
}
