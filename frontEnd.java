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

        new frontEnd().MainMenu();
    }

    public void MainMenu(){
        System.out.println("\n********** Main Menu **********\n" +
            "1. Login\n" +
            "2. Sign up\n" +
            "3. Quit program");

            int option = 0;
        boolean validChoice = true;

        while(validChoice){
            option = keyboard.nextInt();
            keyboard.nextLine();
            switch(option){
                case 1:
                    validChoice = false;
                    this.LoginMenu();
                    
                    break;
                case 2:
                    validChoice = false;
                    this.SignUpOptions();
                    break;
                case 3:
                    validChoice = false;
                    System.out.println("ur mom lol");
                    break;

            }
        }
    }
    
    public void LoginMenu(){
        String username;
        String password;

        System.out.println("\n********** Login Menu **********\n" +
            "Username: ");
        username = keyboard.nextLine();;

        System.out.println("Password: ");
        password = keyboard.nextLine();

        if(lmsApplication.login(username, password)){
            System.out.println("Login Successful.");
            UserMenu();
        } else {
            System.out.println("Invalid credentials, try again");
            LoginMenu();
        }
    }

    public void SignUpOptions(){
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
                    this.UserSignUpMenu();
                    break;
                case 2:
                    validChoice = false;
                    this.AuthorSignupMenu();
                    break;
                case 3:
                    validChoice = false;
                    this.LoginMenu();
                    break;
            }
        }
    }
     
    public void UserSignUpMenu(){
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
        lmsApplication.saveAll();
        
        System.out.println("Logged in to " + lmsApplication.getCurrentUser().getUserName());

        this.UserMenu();
    }

    public void AuthorSignupMenu(){
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

    public void UserMenu(){
        System.out.println("\n********** User Menu **********");
        System.out.println("1. View My Courses\n" +
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
                    this.GeneralSettings();
                    break;
                case 4:
                    validChoice = false;
                    lmsApplication.logout();
                    System.out.println("Logout successful.");
                    MainMenu();
            }
        }
    }

    public void GeneralSettings(){
        System.out.println("\n********** General Settings **********");
        System.out.println("1. Change Password\n" +
        "2. Change Email\n" +
        "3. Change Phone Number\n" +
        "4. Go Back");

        int option = 0;
        boolean validChoice = true;

        while(validChoice){
            option = keyboard.nextInt();
            keyboard.nextLine();
            switch(option){
                case 1:
                    validChoice = false;
                    this.ChangePassword();
                    break;
                case 2:
                    validChoice = false;
                    this.ChangeEmail();
                    break;
                case 3:
                    validChoice = false;
                    this.ChangePhoneNumber();
                    break;
                case 4:
                    validChoice = false;
                    this.UserMenu();
                    break;
            }
        }
    }

    public void ChangeEmail(){
        System.out.println("********** Change Email **********\n"+
        "Current Email: " + lmsApplication.getCurrentUser().getEmailAddress() + "\n" +
        "New Email: ");

        lmsApplication.getCurrentUser().setEmailAddress(keyboard.nextLine());

        System.out.println("**************************************************\n"+
                           "*                New Email Set!                  *\n" +
                           "**************************************************\n");

        GeneralSettings();
    }

    public void ChangePassword(){
        System.out.println("********** Change Password **********\n"+
        "Current Password: " + lmsApplication.getCurrentUser().getPassword() + "\n" +
        "New Password: ");

        lmsApplication.getCurrentUser().setPassword(keyboard.nextLine());

        System.out.println("**************************************************\n"+
                           "*              New Password Set!                 *\n" +
                           "**************************************************\n");

        GeneralSettings();
    }

    public void ChangePhoneNumber(){
        System.out.println("********** Change Phone Number **********\n"+
        "Current Phone Number: " + lmsApplication.getCurrentUser().getPhoneNumber() + "\n" +
        "New Phone Number: ");

        lmsApplication.getCurrentUser().setPhoneNumber(keyboard.nextLine());

        System.out.println("**************************************************\n"+
                           "*            New Phone Number Set!               *\n" +
                           "**************************************************\n");

        GeneralSettings();
    }

    public void printAllCourses(){
        System.out.println("\n**********          Course Menu           **********\n" +
                           "********** Choose a course to get started **********");

        ArrayList<Course> courses = lmsApplication.getCourseList();

        int i = 0;
        for(; i < courses.size(); i++){
            System.out.println((i+1) + ". " + courses.get(i).getCourseName() + " by " + courses.get(i).getAuthor().getFirstName() + " " + courses.get(i).getAuthor().getLastName());
        }
        i++;
        System.out.println(i + ". Go back");


        int option = keyboard.nextInt();
        keyboard.nextLine();
        if(option == i){
            UserMenu();
        } else if(option > i){
            System.out.println("Invalid option, try again");
            printAllCourses();
        } else {
            lmsApplication.getCurrentUser().addCourse(lmsApplication.getCourseList().get(option - 1));
            printCourseContent(lmsApplication.getCourseList().get(option - 1));
        }

    }

    public void printCourseContent(Course course){
        System.out.println("\n******** " + course.getCourseName() + " ********\n" +
        "******** Choose a Module ********");

        int i = 0; 
        for(;i <  course.getModules().size(); i++){
            System.out.println((i+1) + ". " + course.getModules().get(i).getModuleName());
        }

        System.out.println((i+1) + ". Comments\n" +
        (i+2) + ". Go Back\n");

        int option = keyboard.nextInt();
        keyboard.nextLine();

        if(option > i){
            if(option == i+1){
                System.out.println("ATTEMPTED LOAD COMMENTS");
            } else if(option == i+2){
                printAllCourses();
            }
        } else {
            printModuleContent(course, course.getModules().get(option - 1));
        }
    }

    public void printModuleContent(Course course, Module module){
        System.out.println("\n******** Module 1: " + module.getModuleName() + " ********\n" +
        "******** Choose a Lesson ********");

        ArrayList<Lesson> lessons = module.getLessons();
        for(int i = 0;i < module.getLessons().size(); i++){
            System.out.println((i+1) + ". " + lessons.get(i).getLessonTitle());
        }

        System.out.println((lessons.size()+1) + ". Quiz");

        System.out.println((lessons.size()+2) + ". Comments\n" +
        (lessons.size()+3) + ". Go Back");

        int option = keyboard.nextInt();
        keyboard.nextLine();

        if(option > lessons.size()){
            if(option == lessons.size()+1){
                printQuiz(course, module);
            } else if(option == lessons.size()+2){
                System.out.println("ATTEMPTED LOAD COMMENTS");
            } else if(option == lessons.size()+3){
                printCourseContent(course);
            } 
        } else {
            System.out.println("DEBUG");
            printLesson(course, module, lessons.get(option - 1), option);
        }
    }

    public void printLesson(Course course, Module module, Lesson lesson, int lessonIndex){
        System.out.println("********* Lesson " + lessonIndex + ": " + lesson.getLessonTitle() + " *********");

        System.out.println(lesson.getLessonContent());

        System.out.println("\n1. Comments\n2. Go Back");
        int option = keyboard.nextInt();
        keyboard.nextLine();

        switch(option){
            case 1: 
                System.out.println("DEBUG");
                break;
            case 2:
                printModuleContent(course, module);
                break;
        }
    }

    public void printQuiz(Course course, Module module){
        Quiz quiz = module.getQuiz();
        ArrayList<Question> questions = quiz.getQuestions();

        System.out.println("********** Quiz **********");

        for(Question q: questions){
            System.out.println(q.getQuestionTitle());

            int count = 1;
            for(String s: q.getAnswerChoices()){
                System.out.println(count + ". " + s);
                count++;
            }

            int option = keyboard.nextInt();
            keyboard.nextLine();

            if(option == q.getCorrectAnswer()){
                System.out.println("You got it right!! woop woop");
            } else {
                System.out.println("wrong lol, dumbass");
            }
        }

        printModuleContent(course, module);
    }

    /* 
    public void CourseCommentsMenu(Course course, ArrayList<Comment> comments){
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
                    System.out.println("Add comment called");
                    break;
                case 2:
                    validChoice = false;
                    System.out.println("View Comments called")
                    break;
                case 3:
                    validChoice = false;
                    boolean logoutSuccessful = lmsApplication.logout();
                    if(logoutSuccessful){
                        System.out.println("Log out successful");
                    } else {
                        System.out.println("Logout failed");
                    }
                    this.MainMenu();
                    break;
            }
    }
    */

    public void CourseViewComment(){
        
    }

    public void LessonViewComment(){

    }

    public String printCreateComment(){
        System.out.println("********** Add a Comment **********\n" +
        "Add your comment here: ");

        String comment = keyboard.nextLine();

        System.out.println("\n1. Post comment\n" +
        "2. Go Back\n");

        return null;
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
