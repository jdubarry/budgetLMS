/**
 * This class is going to set up a user and pull their information and assign to them so when 
 * they are working online they can be identified
 * @author word.exe
 */
package budgetLMS;
import java.util.ArrayList;

public class User {
    protected String firstName;
    protected String lastName;
    protected String userName;
    protected java.util.UUID userID;
    protected java.util.Date dateOfBirth;
    protected String phoneNumber;
    protected String emailAddress;
    protected ArrayList<CourseProgress> courseProgress;
    protected String password;

    /**
     * This class is going to set up the user with all of their information
     * @param firstName the first name of the user
     * @param lastName the last name of the user
     * @param userName the username for the user
     * @param password the password for the user
     * @param dateOfBirth the date of birth for the user
     * @param phoneNumber the phone number for the user
     * @param emailAddress the email address for the user
     */
    public User(String firstName, String lastName, String userName, String password, java.util.Date dateOfBirth, String phoneNumber, String emailAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * This class is going to set up the user with all of their information
     * @param firstName the first name of the user
     * @param lastName the last name of the user
     * @param userName the username for the user
     * @param password the password for the user
     * @param userID the UUID of the user
     * @param dateOfBirth the date of birth for the user
     * @param phoneNumber the phone number for the user
     * @param emailAddress the email address for the user
     */
    public User(String firstName, String lastName, String userName, String password, java.util.UUID userID, java.util.Date dateOfBirth, String phoneNumber, String emailAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.userID = userID;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * This is going to add courses 
     * @param course the course being made
     */
    public void addCourse(Course course) {
      
    }

    /**
     * This is going to allow the user to view the classes
     */
    public void viewCourses() {

    }

    /**
     * This is going to allow the user to select the course they want to complete
     * @param courseIndex this is the index of all of the courses
     */
    public void selectCourse(int courseIndex) {

    }

    /**
     * This is going to double check the user login to verify the information to connect to a user
     * @param userName the username of the user
     * @param password the password the user created
     * @return this is going to return true is the user login is valid and false if not valid
     */
    public boolean verifyLogin(String userName, String password) {
       
    }

    /**
     * This is going to create an age restriction to users if they are below 11
     */
    private void addAgeRestriction() {
        
    }

    /**
     * This is going to get the username of the user
     * @return This is going to return the username
     */
    public String getUsername() {
        return this.userName;
    }

    /**
     * This is going to pull the id of the user
     * @return the users ID
     */
    public java.util.UUID getId() {
        return userID;
    }
}
