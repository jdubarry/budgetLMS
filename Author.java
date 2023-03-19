package budgetLMS;

public class Author extends User {
    private CourseList courseList;

    public Author(String firstName, String lastName, String userName, String password, String dateOfBirth, String phoneNumber, String emailAddress) {
        super(firstName, lastName, userName, password, dateOfBirth, phoneNumber, emailAddress);
    }
    public void createCourse(String CourseName,  String authorID) {
        Course temp =  new Course(CourseName, authorid);
        courseList.addCourse(temp);

    }
}
