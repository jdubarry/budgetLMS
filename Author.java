/**
 * This is going to be the author class to show what a user can do
 * @author word.exe
 */
public class Author extends User{

    /**
     * This class is going to set up the author with all of their information
     * @param firstName the first name of the user
     * @param lastName the last name of the user
     * @param userName the username for the user
     * @param password the password for the user
     * @param userID the UUID of the user
     * @param dateOfBirth the date of birth for the user
     * @param phoneNumber the phone number for the user
     * @param emailAddress the email address for the user
     */
    public Author(String firstName, String lastName, String userName, String password, java.util.UUID userID, java.util.Date dateOfBirth, String phoneNumber, String emailAddress) {
        super(firstName, lastName, userName, password, userID, dateOfBirth, phoneNumber, emailAddress);
    }
    
    /**
     * This is going to add in the course
     */
    public void addCourse(Course course) {
        
    }  
    
    /**
     * This is going to create a course
     * @param CourseName this will be the name of the course
     * @param authorID this will be the author ID
     */
    public void createCourse(String CourseName,  String authorID) {
        Course temp =  new Course(CourseName, authorID);
        courseList.addCourse(temp);
    }

    
}
