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

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public java.util.UUID getUserID() {
        return this.userID;
    }

    public void setUserID(java.util.UUID userID) {
        this.userID = userID;
    }

    public java.util.Date getDateOfBirth() {
        return this.dateOfBirth;
    }

    public void setDateOfBirth(java.util.Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return this.emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public ArrayList<CourseProgress> getCourseProgress() {
        return this.courseProgress;
    }

    public void setCourseProgress(ArrayList<CourseProgress> courseProgress) {
        this.courseProgress = courseProgress;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
