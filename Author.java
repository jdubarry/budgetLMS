package budgetLMS;

<<<<<<< HEAD
public class Author extends User {
    private CourseList courseList;

    public Author(String firstName, String lastName, String userName, String password, String dateOfBirth, String phoneNumber, String emailAddress) {
        super(firstName, lastName, userName, password, dateOfBirth, phoneNumber, emailAddress);
=======
public class Author extends User{
    /**
     * This class is going to set up the author with all of their information
     * @param firstName the first name of the user
     * @param lastName the last name of the user
     * @param userName the username for the user
     * @param password the password for the user
     * @param dateOfBirth the date of birth for the user
     * @param phoneNumber the phone number for the user
     * @param emailAddress the email address for the user
     */
    public Author(String firstName, String lastName, String userName, String password, java.util.Date dateOfBirth, String phoneNumber, String emailAddress) {
        super(firstName, lastName, userName, password, dateOfBirth, phoneNumber, emailAddress);
    }

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
>>>>>>> c018d0b9a8adbd3b06c8d50dc164fdb37075fed7
    }
    public void createCourse(String CourseName,  String authorID) {
        Course temp =  new Course(CourseName, authorid);
        courseList.addCourse(temp);

    }
}
