import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public class frontEnd {
    Scanner keyboard = new Scanner(System.in);
    SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
    static LMSApplication lmsApplication;

    public static void main(String args[]) {
        lmsApplication = LMSApplication.getInstance();

        lmsApplication.loadJSONS();
        lmsApplication.printData();

        new frontEnd().printMainMenu();
    }

    public void printMainMenu(){
        System.out.println("********** Main Menu **********\n" +
            "1. Login\n" +
            "2. Sign up.\n" +
            "3. Terminate program\n");

            int option = 0;
        boolean validChoice = true;

        while(validChoice){
            option = keyboard.nextInt();
            keyboard.nextLine();
            switch(option){
                case 1:
                    validChoice = false;
                    this.printLoginMenu();
                    
                    break;
                case 2:
                    validChoice = false;
                    this.printSignUpOptions();
                    break;
                case 3:
                    validChoice = false;
                    System.out.println("ur mom lol");
                    break;

            }
        }
    }
    
    public void printLoginMenu(){
        String username;
        String password;

        System.out.println("********** Login Menu **********\n" +
            "Username: ");
        username = keyboard.nextLine();;

        System.out.println("Password: ");
        password = keyboard.nextLine();

        if(lmsApplication.login(username, password)){
            System.out.println("Login Successful.");
            printUserMenu();
        } else {
            System.out.println("Invalid credentials, try again");
            printLoginMenu();
        }
    }

    public void printSignUpOptions(){
        System.out.println("********** Sign Up **********\n" +
        "1. User\n" +
        "2. Author\n" +
        "3. Go back\n");

        int option = 0;
        boolean validChoice = true;

        while(validChoice){
            option = keyboard.nextInt();
            keyboard.nextLine();
            switch(option){
                case 1:
                    validChoice = false;
                    this.printUserSignupMenu();
                    break;
                case 2:
                    validChoice = false;
                    this.printAuthorSignupMenu();
                    break;
                case 3:
                    validChoice = false;
                    this.printLoginMenu();
                    break;
            }
        }
    }
     
    public void printUserSignupMenu(){
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
        Date dob = new Date();
        try{
            dob = dateFormat.parse(dateOfBirth);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("password: ");
        password = keyboard.nextLine();

        User newUser = new User(firstName, lastName, username, password, dob, phoneNumber, email);
        lmsApplication.setCurrentUser(newUser);
        
        System.out.println("Logged in to" + lmsApplication.getCurrentUser().getUserName());

        this.printUserMenu();
    }

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
        Date dob = new Date();
        try{
            dob = dateFormat.parse(dateOfBirth);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("password: ");
        password = keyboard.nextLine();

        Author newAuthor = new Author(firstName, lastName, username, password, null, dob, phoneNumber, email);

        lmsApplication.setCurrentUser(newAuthor);


        System.out.println("**************************************************\n"+
                           "*             Submitted for review               *\n"+
                           "**************************************************\n");
    }

    public void printUserMenu(){
        System.out.println("1\n1. View My Courses\n" +
        "2. Browse Courses\n" +
        "3. General Settings\n" +
        "4. Logout");

        int option = 0;
        boolean validChoice = true;

        while(validChoice){
            option = keyboard.nextInt();
            keyboard.nextLine();
            switch(option){
                case 1:
                    validChoice = false;
                    this.printAllCourses();
                    break;
                case 2:
                    validChoice = false;
                    this.printAllCourses();
                    break;
                case 3:
                    validChoice= false;
                    this.printGeneralSettings();
                    break;
                case 4:
                    validChoice = false;
                    lmsApplication.logout();
                    System.out.println("Logout successful.");
                    printMainMenu();
            }
        }
    }

    public void printGeneralSettings(){
        System.out.println("1. Change password\n" +
        "2. Change Email\n" +
        "3. Change phone number\n");

        int option = 0;
        boolean validChoice = true;

        while(validChoice){
            option = keyboard.nextInt();
            keyboard.nextLine();
            switch(option){
                case 1:
                    validChoice = false;
                    this.printChangePassword();
                    break;
                case 2:
                    validChoice = false;
                    this.printChangeEmail();
                    break;
                case 3:
                    validChoice = false;
                    this.printChangePhoneNumber();
                    break;
            }
        }
    }

    public void printChangeEmail(){
        System.out.println("DEBUG: CHANGEEMAIL");
        System.out.println("********** Change Email **********\n"+
        "Current Email: " + lmsApplication.getCurrentUser().getEmailAddress() + "\n" +
        "New Email: ");

        lmsApplication.getCurrentUser().setEmailAddress(keyboard.nextLine());

        System.out.println("**************************************************\n"+
                           "*                New Email Set!                  *\n" +
                           "**************************************************\n");

        printGeneralSettings();
    }

    public void printChangePassword(){
        System.out.println("DEBUG: CHANGEPASSWORD");
        System.out.println("********** Change Password **********\n"+
        "Current Password: " + lmsApplication.getCurrentUser().getPassword() + "\n" +
        "New Password: ");

        lmsApplication.getCurrentUser().setPassword(keyboard.nextLine());

        System.out.println("**************************************************\n"+
                           "*              New Password Set!                 *\n" +
                           "**************************************************\n");

        printGeneralSettings();
    }

    public void printChangePhoneNumber(){
        System.out.println("********** Change Password **********\n"+
        "Current Phone Number: " + lmsApplication.getCurrentUser().getPhoneNumber() + "\n" +
        "New Phone Number: ");

        lmsApplication.getCurrentUser().setPhoneNumber(keyboard.nextLine());

        System.out.println("**************************************************\n"+
                           "*            New Phone Number Set!               *\n" +
                           "**************************************************\n");

        printGeneralSettings();
    }

    public void printAllCourses(){
        System.out.println("DEBUG: PRINTCOURSES");
        System.out.println("**********          Course Menu           **********\n" +
                           "********** Choose a course to get started **********");

        ArrayList<Course> courses = lmsApplication.getCourseList();

        int i = 0;
        for(; i < courses.size(); i++){
            System.out.println((i+1) + ". " + courses.get(i).getCourseName() + " by " + courses.get(i).getAuthor().getFirstName() + " " + courses.get(i).getAuthor().getLastName());
        }
        i++;
        System.out.println(i + ". Go back");
    }

    public void printCourseContent(){
        System.out.println("DEBUG: COURSECONTENT");
        System.out.println("******** " + "courseName" + "********\n" +
        "******** Choose a Module ********");

        int i = 0; 

        System.out.println((i+1) + ". Comments\n" +
        (i+2) + ". Go Back\n");

        
    }

    public int printModuleContent(){
        System.out.println("DEBUG");
        System.out.println("******** Module 1: " + "moduleName" + "********\n" +
        "******** Choose a Lesson ********");

        int i = 0;

        System.out.println((i+1) + ". Comments\n" +
        (i+2) + ". Go Back\n");

        return keyboard.nextInt();
    }

    public void printLesson(){
        System.out.println("DEBUG");
    }

    public void printQuiz(){
        System.out.println("DEBUG");

    }

    public void printCommentsMenu(){
        System.out.println("1. Add a Comment\n" +
        "2. View Comments\n" +
        "3. View replies\n" +
        "4. Go Back\n");

        boolean validChoice = true;
        int option = 0;;

        while(validChoice)
            option = keyboard.nextInt();
            keyboard.nextLine();
            switch(option){
                case 1:
                    validChoice = false;
                    this.printAllCourses();
                    break;
                case 2:
                    validChoice = false;
                    this.printGeneralSettings();
                    break;
                case 3:
                    validChoice = false;
                    boolean logoutSuccessful = lmsApplication.logout();
                    if(logoutSuccessful){
                        System.out.println("Log out successful");
                    } else {
                        System.out.println("Logout failed");
                    }
                    System.out.println("DEBUG: LOGOUT");
                    this.printMainMenu();
                    break;
            }
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
