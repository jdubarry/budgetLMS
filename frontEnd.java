import java.util.Scanner;

import javax.management.modelmbean.ModelMBean;

public class frontEnd {
    Scanner keyboard = new Scanner(System.in);

    public void printMainMenu(){
        System.out.println("********** Main Menu **********\n" +
            "1. Login\n" +
            "2. Sign up.");
    }
    /**
     * Returns an array of Strings, in order of username, password
     */
    public String[] printLoginMenu(){
        String username;
        String password;

        System.out.println("********** Login Menu **********" +
            "Username: ");
        username = keyboard.nextLine();;

        System.out.println("Password: ");
        password = keyboard.nextLine();

        String[] ret = {username, password};
        return ret;
    }

    public int printSignUpOptions(){
        System.out.println("********** Sign Up **********\n" +
        "1. User\n" +
        "2. Author\n" +
        "3. Go back\n");

        return keyboard.nextInt;
    }
    /**
     * Returns an array of in the order of firstName, lastName, username, email, phoneNumber, birthday, password.
     * @return
     */
    public String[] printSignupMenu(){
        String firstName, lastName, username, email, phoneNumber, birthday, password;

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
        birthday = keyboard.nextLine();

        System.out.println("password: ");
        password = keyboard.nextLine();

        String[] ret = {firstName, lastName, username, email, phoneNumber, birthday, password};
        return ret;


    }

    public String[] printAuthorSignupMenu(){
        String firstName, lastName, username, email, phoneNumber, birthday, password;

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
        birthday = keyboard.nextLine();

        System.out.println("password: ");
        password = keyboard.nextLine();


        System.out.println("**************************************************"+
                           "*             Submitted for review               *"+
                           "**************************************************");

        String[] ret = {firstName, lastName, username, email, phoneNumber, birthday, password};
        return ret;


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
}
