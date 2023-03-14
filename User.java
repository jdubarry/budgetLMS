package budgetLMS;
import java.util.ArrayList;

public class User {
    protected String firstName;
    protected String lastName;
    protected String userName;
    protected java.util.UUID UserID;
    protected java.util.Date dateOfBirth;
    protected String phoneNumber;
    protected String emailAddress;
    protected ArrayList<CourseProgress> courseProgress;
    protected String password;

    public User(String firstName, String lastName, String userName, String password, String dateOfBirth, String phoneNumber, String emailAddress) {

    }
    public void addCourse(Course course) {

    }
    public void viewCourses() {

    }
    public void selectCourse(int courseIndex) {

    }
    public boolean verifyLogin(String userName, String password) {

    }
    private void addAgeRestriction() {
        
    }
}
