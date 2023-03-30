import java.util.ArrayList;

/**
 * This is going to be the main page for the program of the LMS application
 * @author word.exe
 */

public class LMSApplication {
    private User currentUser;
    private Author authorPermissions;
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
    public boolean login(String username, String password) {
        User tempUser = userList.getUserByName(username);

        if(tempUser == null){
            Author tempAuthor = userList.geAuthorByName(username);
            if(tempAuthor == null){
                return false;
            } else{
                if(tempAuthor.verifyLogin(username, password)){
                    currentUser = tempAuthor;
                    authorPermissions = tempAuthor;
                    return true;
                }
            }
        } else if(tempUser.verifyLogin(username, password)){
            currentUser = tempUser;
            return true;
        }
        
        return false;

        
    }

    public User getCurrentUser(){
        return this.currentUser;
    }

    public Author getAuthorPermissions(){
        return this.authorPermissions;
    }

    public void setCurrentUser(User user){
        this.currentUser = user;
    }

    public ArrayList<Course> getCourseList(){
        return this.courseList.getCourses();
    }

    /**
     * This is going to log out the users
     * @param user the user information, password, username
     */
    public boolean logout() {
        if(currentUser == null){
            return false;
        } else {
            currentUser = null;
            return true;
        }
        
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
        return this.currentCourse();
    }

    public void saveGrades(Course course, Double grade) {
        ArrayList<CourseProgress> progress = currentUser.getCourseProgress();

        for(CourseProgress x: progress){
            if(x.getCourse().equals(course)){
                x.updateCourseProgress(grade);
                return;
            }
        } 
        CourseProgress newCP = new CourseProgress(course);
        newCP.updateCourseProgress(grade);
        progress.add(newCP);
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

    private void saveUsers() {
        userList.saveUsers();
        userList.saveAuthors();
    }

    private void saveCourses() {
        courseList.save();
    }

    public void saveAll() {
        saveUsers();
        saveCourses();
    }
}
