import java.util.Scanner;

import javax.management.modelmbean.ModelMBean;

public class frontEnd {
    Scanner keyboard = new Scanner(System.in);

    public void printMainMenu(){
        System.out.println("********** Main Menu **********\n" +
            "1. Login\n" +
            "2. Sign up.\n");

            int option;
            boolean validChoice = true;

            while(validChoice){
                option = keyboard.nextInt();
                switch (option) {
                    case 1:
                        validChoice = true;
                        this.printLoginMenu();
                        break;
                    case 2:
                        validChoice = true;
                        this.printSignupMenu();
                        break;
                    default:
                        System.out.println("Invalid choice. Try again.");
                        break;
                }
            }
    }
    
    public void printLoginMenu(){
        String username;
        String password;

        System.out.println("********** Login Menu **********" +
            "Username: ");
        username = keyboard.nextLine();;

        System.out.println("Password: ");
        password = keyboard.nextLine();

        
    }

    public void printSignUpOptions(){
        System.out.println("********** Sign Up **********\n" +
        "1. User\n" +
        "2. Author\n" +
        "3. Go back\n");

        int option;
        boolean validChoice = true;

        while(validChoice)
            switch(option){
                case 1:
                    validChoice = false;
                    this.printUserSignUpOptions();
                    break;
                case 2:
                    validChoice = false;
                    this.printAuthorSignupMenu();
                    break;

            }
    }
    /**
     * Returns an array of in the order of firstName, lastName, username, email, phoneNumber, birthday, password.
     * @return
     */
    public String[] printUserSignupMenu(){
        String firstName, lastName, username, email, phoneNumber, dateOfBirth, password;

        System.out.println("First name: ");
        firstName = keyboard.nextLine();

        System.out.println("Last name: ");
        lastName = keyboard.nextLine();

        System.out.println("Username: ");
        username = keyboard.nextLine();

        System.out.println("Email: ");
        email = keyboard.nextLine();

        System.out.println("Phone number: ");
        phoneNumber = keyboard.nextLine();

        System.out.println("Birthday: ");
        dateOfBirth = keyboard.nextLine();

        System.out.println("password: ");
        password = keyboard.nextLine();

        User newUser = new User(firstName, lastName, username, password, dateOfBirth, phoneNumber, email);
    }

    /**
     * Current has blank UUID issues 
     * Are users supposed to make their own UUID?
     */
    public void printAuthorSignupMenu(){
        String firstName, lastName, username, email, phoneNumber, dateOfBirth, password;

        System.out.println("First name: ");
        firstName = keyboard.nextLine();

        System.out.println("Last name: ");
        lastName = keyboard.nextLine();

        System.out.println("Username: ");
        username = keyboard.nextLine();

        System.out.println("Email: ");
        email = keyboard.nextLine();

        System.out.println("Phone number: ");
        phoneNumber = keyboard.nextLine();

        System.out.println("Birthday: ");
        dateOfBirth = keyboard.nextLine();

        System.out.println("password: ");
        password = keyboard.nextLine();

        Author newAuthor = new Author(firstName, lastName, username, password, null, dateOfBirth, phoneNumber, email);


        System.out.println("**************************************************"+
                           "*             Submitted for review               *"+
                           "**************************************************");
    }

    public int printUserMenu(){
        System.out.println("1. View My Courses\n" +
        "2. Browse Courses\n" +
        "3. General Settings\n" +
        "4. Logout");

        return keyboard.nextInt;
    }

    public int printGeneralSettings(){
        System.out.println("1. Change password\n" +
        "2. Change Email\n" +
        "3. Change phone number\n");

        return keyboard.nextInt();
    }

    public String printChangeEmail(String currentEmail){
        System.out.println("********** Change Email **********\n"+
        "Current Email: " + currentEmail + "\n" +
        "New Email: ");

        String ret = keyboard.nextLine();

        System.out.println("**************************************************"+
                           "*                New Email Set!                  *" +
                           "**************************************************");

        return ret;
    }

    public String printChangePassword(String currentPassword){
        System.out.println("********** Change Password **********\n"+
        "Current Password: " + currentPassword + "\n" +
        "New Password: ");

        String ret = keyboard.nextLine();

        System.out.println("**************************************************"+
                           "*              New Password Set!                 *" +
                           "**************************************************");

        return ret;
    }

    public String printChangePhoneNumber(String currentPhoneNumber){
        System.out.println("********** Change Password **********\n"+
        "Current Phone Number: " + currentPhoneNumber + "\n" +
        "New Phone Number: ");

        String ret = keyboard.nextLine();

        System.out.println("**************************************************"+
                           "*            New Phone Number Set!               *" +
                           "**************************************************");

        return ret;
    }

    public int printAllCourses(String[] courseNames){
        System.out.println("**********          Course Menu           **********\n" +
                           "********** Choose a course to get started **********");

        for(int i = 0; i < courseNames.length; i++){
            System.out.println((i+1) + courseNames[i]);
        }

        return keyboard.nextInt();
    }

    public int printCourseContent(String courseName, String[] modules){
        System.out.println("******** " + courseName + "********\n" +
        "******** Choose a Module ********");

        int i;
        for(i = 0; i < modules.length; i++){
            System.out.print((i+1) + modules[i]);
        }

        System.out.println((i+1) + ". Comments\n" +
        (i+2) + ". Go Back\n");

        return keyboard.nextInt();
    }

    public int printModuleContent(String mdouleName, String[] lessons){
        System.out.println("******** Module 1: " + moduleName + "********\n" +
        "******** Choose a Lesson ********");

        int i;
        for(i = 0; i < lessons.length; i++){
            System.out.print((i+1) + lessons[i]);
        }

        System.out.println((i+1) + ". Comments\n" +
        (i+2) + ". Go Back\n");

        return keyboard.nextInt();
    }

    public int printLesson(String lessonContent){
        return 0;
    }

    public int printQuiz(){
        return 0;
    }

    public int printCommentsMenu(){
        System.out.println("1. Add a Comment\n" +
        "2. View Comments\n" +
        "3. View replies\n" +
        "4. Go Back\n");

        return keyboard.nextInt();
    }

    /**
     * Code needs to be added to actually send the comment somewhere
     * @return
     */
    public String printCreateComment(){
        System.out.println("********** Add a Comment **********\n" +
        "Add your comment here: ");

        String comment = keyboard.nextLine();

        System.out.println("\n1. Post comment\n" +
        "2. Go Back\n");

        return null;
    }

    public int printViewComment(){
        return 0;
    }

    public String printReplyComment(){
        return null;
    }

    public int printViewReplies(){
        return 0;
    }

    public int AuthorMenu(){
        return 0;
    }

    public Module printCreateModule(){
        return null;
    }

    public Lesson printCreateLesson(){
        return null;
    }

    public Quiz printCreateQuiz(){
        return null;
    }

    public int printViewCreatedCourses(){
        return 0;
    }

    public int printEditCourse(){
        return 0;
    }

    public int printEditCourseTitle(){
        return 0;
    }

    public int printEditCourseModule(){
        return 0;
    }

    public int printEditCourseLesson(){
        return 0;
    }

    public int printEditCourseQuiz(){
        return 0;
    }

    public int printViewCourseGrades(){
        return 0;
    }
}
