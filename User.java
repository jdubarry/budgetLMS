/**
 * This class is going to set up a user and pull their information and assign to them so when 
 * they are working online they can be identified
 * @author word.exe
 */
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
        this.courseProgress = new ArrayList<CourseProgress>();
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
        this.courseProgress = new ArrayList<CourseProgress>();
    }

    /**
     * This is going to add courses 
     * @param course the course being made
     */
    public void addCourse(Course course) {
        this.courseProgress.add(new CourseProgress(course));
    }

    /**
     * This is going to add courses from the dataLoader
     * @param course the course being added
     */
    public void addCourse(Course course, ArrayList<Double> grades) {
        this.courseProgress.add(new CourseProgress(course, grades));
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
     * This is going to get the users first name
     * @return the users first name
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * This is going to set the first name to the user
     * @param firstName the users first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * This is going to get the user's last name
     * @return the last name of the user
     */
    public String getLastName() {
        return this.lastName;
    }

    /**
     * This is going to set the user's last name
     * @param lastName the last name of the user
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * This is going to get the user name
     * @return the user name
     */
    public String getUserName() {
        return this.userName;
    }

    /**
     * This is going to set the user name
     * @param userName the username of the user
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * This is going to get the ID of the user
     * @return the user ID is returned
     */
    public java.util.UUID getUserID() {
        return this.userID;
    }

    /**
     * This is going to set the user's ID
     * @param userID this is going to be the user's ID
     */
    public void setUserID(java.util.UUID userID) {
        this.userID = userID;
    }

    /**
     * This is going to get the date of birth of the user
     * @return the date of birth 
     */
    public java.util.Date getDateOfBirth() {
        return this.dateOfBirth;
    }

    /**
     * This is going to set the date of birth of the user
     * @param dateOfBirth this is the date of birth of the user
     */
    public void setDateOfBirth(java.util.Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * This is going to get the phone number of the user
     * @return the phone number of the user
     */
    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    /**
     * This is going to set the phone number of the user
     * @param phoneNumber
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * This is going to get the email of the user
     * @return this is going to return the email address
     */
    public String getEmailAddress() {
        return this.emailAddress;
    }

    /**
     * This is going to set the email address
     * @param emailAddress The email address of the user
     */
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    /**
     * This is going to get the course progress
     * @return The course progress of the user
     */
    public ArrayList<CourseProgress> getCourseProgress() {
        return this.courseProgress;
    }

    /**
     * This is going to set the course progress
     * @param courseProgress this is the course progress
     */
    public void setCourseProgress(ArrayList<CourseProgress> courseProgress) {
        this.courseProgress = courseProgress;
    }

    /**
     * This is going to get the password of the user
     * @return the password of the user
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * This is going to set the password of the user
     * @param password the password of the user
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
