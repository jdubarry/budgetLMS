import java.util.Scanner;
import java.lang.reflect.Array;
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
        //lmsApplication.printData();

        new frontEnd().MainMenu();
    }

    /**
     * prints main menu options
     */
    public void MainMenu(){
        System.out.println("\n********** Main Menu **********\n" +
            "1. Login\n" +
            "2. Sign up\n" +
            "3. Quit program");

        int option = getChoice(3);

        switch(option){
            case 1:
                this.LoginMenu();
                break;
            case 2:
                this.SignUpOptions();
                break;
            case 3:
                System.out.print("Saving data...");
                lmsApplication.saveAll();
                System.out.println("Saved. Quitting program now.");
                break;
        }
    }
    
    /**
     * prints a menu that returns login options
     */
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
            if(lmsApplication.getCurrentUser() instanceof Author){
                AuthorMenu();
            } else {
                UserMenu();
            }
        } else {
            System.out.println("Invalid credentials, try again");
            MainMenu();
        }
    }

   /**
    * prints a menu that returns sign up options  
    */ 
    public void SignUpOptions(){
        System.out.println("\n********** Sign Up **********\n" +
        "1. User\n" +
        "2. Author\n" +
        "3. Go back");

        int option = getChoice(3);
        switch(option){
            case 1:
                this.UserSignUpMenu();
                break;
            case 2:
                this.AuthorSignupMenu();
                break;
            case 3:
                this.LoginMenu();
                break;
            }
    }
     
    /**
     * prints a menu that returns a user sign up menu
     */
    public void UserSignUpMenu(){
        System.out.println("\n********** User Signup **********");
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
        UserList.getInstance().addUser(newUser);
        lmsApplication.saveAll();
        
        System.out.println("Logged in to " + lmsApplication.getCurrentUser().getUserName());

        this.UserMenu();
    }

    /**
     * prints a menu that returns an author sign up menu
     */
    public void AuthorSignupMenu(){
        System.out.println("\n********** Author Signup **********");
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

        Author newAuthor = new Author(firstName, lastName, username, password, dob, phoneNumber, email);

        lmsApplication.setCurrentUser(newAuthor);
        UserList.getInstance().addAuthor(newAuthor);
        lmsApplication.saveAll();
        System.out.println("**************************************************\n"+
                           "*             Submitted for review               *\n"+
                           "**************************************************\n");

        AuthorMenu();
    }

    /**
     * prints a menu with options for a user
     */
    public void UserMenu(){
        System.out.println("\n********** User Menu **********");
        System.out.println("1. View My Course Progress\n" +
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
                    this.printCourseProgess();
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

    /**
     * prints a menu with options for an author
     */
    public void AuthorMenu(){
        System.out.println("\n********** Author Menu **********");
        System.out.println("1. Create a course\n" + 
            "2. View my created courses\n" +
            "3. View my course progress\n" +
            "4. Browse courses\n" +
            "5. General settings\n" +
            "6. Log out\n");

        int option = getChoice(6);

        switch(option){
            case 1:
                System.out.print("Please enter a name for your course: ");
                String courseName = keyboard.nextLine();
                Course newCourse = new Course(courseName, lmsApplication.getAuthorPermissions());
                createCourse(newCourse);
                break;
            case 2:
                ViewCreatedCourses();
                break;
            case 3:
                printCourseProgess();
                break;
            case 4:
                printAllCourses();
                break;
            case 5:
                GeneralSettings();
                break;
            case 6:
                lmsApplication.logout();
                System.out.println("Logout successful.");
                MainMenu();
                break;
        }
    }

    /**
     * prints the course progress of a user to the console
     */
    public void printCourseProgess(){
        System.out.println("********** Course Progress **********");
        ArrayList<CourseProgress> progress = lmsApplication.getCurrentUser().getCourseProgress();

        for(CourseProgress x: progress){
            System.out.print("Course Name: " + x.getCourse().getCourseName());
            int count = 0;
            for(Double y: x.getGrades()){
                System.out.print(" Module " + (count + 1) + ": " + y);
                count++;
            }
            System.out.println();
        }

        System.out.println("\n1. Go back\n2. Print certificate for a course");

        int option = getChoice(2);
        if(option == 1){
            if(lmsApplication.getCurrentUser() instanceof Author){
                AuthorMenu();
            } else {
                UserMenu();
            }
        }
        if(option == 2){
            System.out.println("Enter which number course you would like to print");
            int count = 1;
            for(CourseProgress x: progress) {
                System.out.println(count+". "+"Course Name: " + x.getCourse().getCourseName());
                count++;
            }
            option = getChoice(10000); //Arbitrary large number for choices
            count = 1;
            for(CourseProgress x: progress) {
                if(count==option) {
                    lmsApplication.printCourseCertificate(x.getCourse());
                }
                count++;
            }
            printCourseProgess();
        }
    }
    /**
     * prints a menu with settings options
     */
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
                    if(lmsApplication.getCurrentUser() instanceof Author){
                        AuthorMenu();
                    } else {
                        UserMenu();
                    }
                    break;
            }
        }
    }

    /**
     * prints a menu that an email has been changed
     */
    public void ChangeEmail(){
        System.out.println("********** Change Email **********\n"+
        "Current Email: " + lmsApplication.getCurrentUser().getEmailAddress() + "\n" +
        "New Email: ");

        lmsApplication.getCurrentUser().setEmailAddress(keyboard.nextLine());
        lmsApplication.saveAll();

        System.out.println("**************************************************\n"+
                           "*                New Email Set!                  *\n" +
                           "**************************************************\n");

        GeneralSettings();
    }
    /**
     * prints a menu that a password has been changed
     */
    public void ChangePassword(){
        System.out.println("********** Change Password **********\n"+
        "Current Password: " + lmsApplication.getCurrentUser().getPassword() + "\n" +
        "New Password: ");

        lmsApplication.getCurrentUser().setPassword(keyboard.nextLine());
        lmsApplication.saveAll();

        System.out.println("**************************************************\n"+
                           "*              New Password Set!                 *\n" +
                           "**************************************************\n");

        GeneralSettings();
    }

    /**
     * prints a menu that a password has been changed
     */
    public void ChangePhoneNumber(){
        System.out.println("********** Change Phone Number **********\n"+
        "Current Phone Number: " + lmsApplication.getCurrentUser().getPhoneNumber() + "\n" +
        "New Phone Number: ");

        lmsApplication.getCurrentUser().setPhoneNumber(keyboard.nextLine());
        lmsApplication.saveAll();

        System.out.println("**************************************************\n"+
                           "*            New Phone Number Set!               *\n" +
                           "**************************************************\n");

        GeneralSettings();
    }

    /**
     * prints a list of all the courses in the LMS
     */
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
            if(lmsApplication.getCurrentUser() instanceof Author){
                AuthorMenu();
            } else {
                UserMenu();
            }
        } else if(option > i){
            System.out.println("Invalid option, try again");
            printAllCourses();
        } else {
            lmsApplication.getCurrentUser().addCourse(lmsApplication.getCourseList().get(option - 1));
            printCourseContent(lmsApplication.getCourseList().get(option - 1));
        }

    }

    /**
     * prints a menu with options for a user selected course
     * @param course
     */
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
                CourseViewComment(course);
            } else if(option == i+2){
                printAllCourses();
            }
        } else {
            printModuleContent(course, course.getModules().get(option - 1));
        }
    }

    /**
     * prints a menu with options for a user selected module
     * @param course
     * @param module
     */
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

    /**
     * prints a menu with options for a user selected lesson
     * @param course
     * @param module
     * @param lesson
     * @param lessonIndex
     */
    public void printLesson(Course course, Module module, Lesson lesson, int lessonIndex){
        System.out.println("********* Lesson " + lessonIndex + ": " + lesson.getLessonTitle() + " *********");

        System.out.println(lesson.getLessonContent());

        System.out.println("\n1. Comments\n2. Write lesson to a file\n3. Go Back");
        int option = keyboard.nextInt();
        keyboard.nextLine();

        switch(option){
            case 1: 
                LessonViewComment(course, module, lesson, lessonIndex);
                break;
            case 2:
                writeLessonToFile(lesson);
                printLesson(course, module, lesson, lessonIndex);
                break;
            case 3:
                printModuleContent(course, module);
                break;
        }
    }

    // Writes lesson to a file
    private static void writeLessonToFile(Lesson lesson){
        lesson.writeToFile();
    }

    /**
     * prints a user selected quiz
     * @param course
     * @param module
     */
    public void printQuiz(Course course, Module module){
        Quiz quiz = module.getQuiz();
        ArrayList<Question> questions = quiz.getQuestions();

        System.out.println("********** Quiz **********");

        double correct = 0.0;
        double totalQuestions = (double) module.getQuiz().getQuestions().size();

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
                System.out.println("You got it right!!\n");
                correct = correct + 1.0;
            } else {
                System.out.println("Incorrect answer\n");
            }
        }

        System.out.println("Quiz over. You scored " + (int) correct + " out of " + (int) totalQuestions);

        double finalScore = 100.0*(correct/totalQuestions);
        lmsApplication.saveGrades(course, finalScore);
        lmsApplication.saveAll();

        printModuleContent(course, module);
    }

    /**
     * prints a list of comments for the course 
     * @param course
     */
    public void CourseViewComment(Course course){
        System.out.println("\n********* " + course.getCourseName() + ": comments **********");
        System.out.println("***** Select a comment to navigate or add a new comment *****");
        ArrayList<Comment> comments = course.getComments();

        int count = 1;
        for(Comment c: comments){
            System.out.println(count + ". " + c.getAuthorName() + " commented: " + c.getCommentContent());
            count++;
        }

        System.out.println(count + ". Add a comment");
        count ++;
        System.out.println(count + ". Go back");

        int option = getChoice(comments.size() + 2);

        if(option == comments.size() + 1){
            Comment newComment = new Comment(lmsApplication.getCurrentUser().getFirstName(), CreateReply());
            course.addComment(newComment);
            lmsApplication.saveAll();
            CourseViewComment(course);
        } else if(option == comments.size() + 2){
            printCourseContent(course);
        } else {
            CourseViewComment(course, comments.get(option - 1));
        }

    }

    /**
     * prints a list of comments for the course
     * @param course
     * @param currentComment
     */
    public void CourseViewComment(Course course, Comment currentComment){
        System.out.println("\n********* " + course.getCourseName() + ": comments **********");
        System.out.println("***** Select a reply to navigate or add a new reply to the parent comment *****\n");
        System.out.println("Parent comment: " + currentComment.getAuthorName() + " commented " + currentComment.getCommentContent() + "\n");
        ArrayList<Comment> replies =  currentComment.getReplies();

        int count = 1;
        for(Comment c: replies){
            System.out.println(count + ". " + c.getAuthorName() + " replied: " + c.getCommentContent());
            count++;
        }

        System.out.println(count + ". Add a reply to the parent comment");
        count ++;
        System.out.println(count + ". Go back to all comments");

        int option = getChoice(replies.size() + 2);

        if(option == replies.size() + 1){
            Comment reply = new Comment(lmsApplication.getCurrentUser().getFirstName(), CreateReply());
            currentComment.reply(reply);
            lmsApplication.saveAll();
            CourseViewComment(course, currentComment);
        } else if(option == replies.size() + 2){
            printCourseContent(course);
        } else {
            CourseViewComment(course, replies.get(option - 1));
        }
    }

    /**
     * prints a list of comments for lessons
     * @param course
     * @param module
     * @param lesson
     * @param index
     */
    public void LessonViewComment(Course course, Module module, Lesson lesson, int index){
        System.out.println("\n********* " + lesson.getLessonTitle() + ": comments **********");
        System.out.println("***** Select a comment to navigate or add a new comment *****");
        ArrayList<Comment> comments = lesson.getComments();

        int count = 1;
        for(Comment c: comments){
            System.out.println(count + ". " + c.getAuthorName() + " commented: " + c.getCommentContent());
            count++;
        }

        System.out.println(count + ". Add a comment");
        count ++;
        System.out.println(count + ". Go back");

        int option = getChoice(comments.size() + 2);

        if(option == comments.size() + 1){
            Comment newComment = new Comment(lmsApplication.getCurrentUser().getFirstName(), CreateReply());
            lesson.addComment(newComment);
            lmsApplication.saveAll();
            LessonViewComment(course, module, lesson, index);
        } else if(option == comments.size() + 2){
            printLesson(course, module, lesson, index);
        } else {
            LessonViewComment(course, module, lesson, index, comments.get(option - 1));
        }
    }

    /**
     * prints a list of comments for lessons
     * @param course
     * @param module
     * @param lesson
     * @param index
     * @param currentComment
     */
    public void LessonViewComment(Course course, Module module, Lesson lesson, int index, Comment currentComment){
        System.out.println("\n********* " + lesson.getLessonTitle() + ": comments **********");
        System.out.println("***** Select a reply to navigate or add a new reply to the parent comment *****\n");
        System.out.println("Parent comment: " + currentComment.getAuthorName() + " commented " + currentComment.getCommentContent() + "\n");
        ArrayList<Comment> replies =  currentComment.getReplies();

        int count = 1;
        for(Comment c: replies){
            System.out.println(count + ". " + c.getAuthorName() + " replied: " + c.getCommentContent());
            count++;
        }

        System.out.println(count + ". Add a reply to the parent comment");
        count ++;
        System.out.println(count + ". Go back to all comments");

        int option = getChoice(replies.size() + 2);

        if(option == replies.size() + 1){
            Comment reply = new Comment(lmsApplication.getCurrentUser().getFirstName(), CreateReply());
            currentComment.reply(reply);
            lmsApplication.saveAll();
            LessonViewComment(course, module, lesson, index, currentComment);
        } else if(option == replies.size() + 2){
            LessonViewComment(course, module, lesson, index);
        } else {
            LessonViewComment(course, module, lesson, index, replies.get(option - 1));
        }
    }

    /**
     * a method that returns a comment
     * @return a string representation of a comment
     */
    public String CreateComment(){
        System.out.println("******** Add a Comment ********\n" +
        "Add your comment here: ");

        String comment = keyboard.nextLine();

        System.out.println("Comment added!");
        return comment;
    }

    /**
     * a method that returns a reply
     * @return a string representation of a reply
     */
    public String CreateReply(){
        System.out.println("******** Add a Reply ********\n" +
        "Add your comment here: ");

        String comment = keyboard.nextLine();

        System.out.println("Reply added!");
        return comment;
    }

    /**
     * a method that creates a course
     */
    public void createCourse(Course course){
        System.out.println("\n********* " + course.getCourseName() + " *********");
        System.out.println("********** First time set up **********");

        createModule(course);

        System.out.println("********** First time set up complete **********");

        editCourse(course);
    }

    /**
     * a method that creates a module
     * @param course
     */
    public void createModule(Course course){
        System.out.println("***** New module set up *****");
        System.out.print("Please enter a name for your module: ");

        Module module = new Module(keyboard.nextLine());
        System.out.println();
        course.addModule(module);

        createLesson(course, module);

        createQuiz(course, module);
    }

    /**
     * a method that creates a lesson
     * @param course
     * @param module
     */
    public void createLesson(Course course, Module module){
        System.out.println("***** New lesson set up *****");
        System.out.print("Please enter a name for your lesson: ");
        String lessonName = keyboard.nextLine();
        System.out.println();

        System.out.print("Please enter the lesson content: ");
        String lessonContent = keyboard.nextLine();
        System.out.println();

        Lesson newLesson = new Lesson(lessonName);
        newLesson.setLessonContent(lessonContent);

        module.addLesson(newLesson);
    }

    /**
     * a method that creates a quiz
     * @param course
     * @param module
     */
    public void createQuiz(Course course, Module module){
        System.out.println("***** New quiz set up *****");
        createQuestion(course, module, module.getQuiz());
    }

    /**
     * a method that creates a question
     * @param course
     * @param module
     * @param quiz
     */
    public void createQuestion(Course course, Module module, Quiz quiz){
        System.out.println("Each quiz needs at least 1 question, and each question needs at least 3 answer choices");
        
        System.out.print("Please enter a question: ");
        Question questionOne = new Question(keyboard.nextLine());
        System.out.print("\nPlease enter answer choice 1: ");
        questionOne.addAnswer(keyboard.nextLine());
        System.out.print("\nPlease enter choice 2: ");
        questionOne.addAnswer(keyboard.nextLine());
        System.out.print("\nPlease enter choice 3: ");
        questionOne.addAnswer(keyboard.nextLine());

        System.out.print("Whats the correct answer? (Enter an integer) ");
        int correctAnswer = getChoice(3);
        System.out.println();
        questionOne.setCorrectAnswer(correctAnswer);

        quiz.addQuestion(questionOne);
    }

    /**
     * a method that allows authors to edit courses
     */
    public void editCourse(Course course){
        System.out.println("\n***** Editing Course: " + course.getCourseName() + " *****");
        System.out.println("Please choose an option to edit");

        System.out.println("1. Course name: " + course.getCourseName());
        int count = 2;
        for(Module x: course.getModules()){
            System.out.println(count + ". Module: " + x.getModuleName());
            count++;
        }

        System.out.println(count +". Add module");
        count++;
        System.out.println(count + ". Publish course");

        int option = getChoice(course.getModules().size() + 4);

        if(option == 1){
            System.out.print("Please enter a new course title: ");
            course.setCourseName(keyboard.nextLine());
            System.out.println();
            editCourse(course);
        } else if(option == course.getModules().size() + 2){
            createModule(course);
            editCourse(course);
        } else if(option == course.getModules().size() + 3){
            System.out.print("Publishing course...");
            publishCourse(course);
            lmsApplication.saveAll();
            System.out.println("published. Returning to main menu");
            AuthorMenu();
        } else {
            editModule(course, course.getModules().get(option - 2));
        }
    }

    private void publishCourse(Course course){
        ArrayList<Course> allCourses = CourseList.getInstance().getCourses();

        int pos = 0;
        for(Course x: allCourses){
            if(x.getCourseID().equals(course.getCourseID())){
                CourseList.getInstance().getCourses().set(pos, course);
                return;
            }
            pos++;
        }

        CourseList.getInstance().getCourses().add(course);
    }

    /**
     * a method that allows authors to edit modules
     * @param course
     * @param module
     */
    public void editModule(Course course, Module module){
        System.out.println("\n********** Edit Module:" + module.getModuleName() + " *********");
        System.out.println("***** Choose a lesson to edit or other options *****");

        
        int count = 1;
        for(Lesson x: module.getLessons()){
            System.out.println(count + ". " + x.getLessonTitle());
            count++;
        }

        System.out.println(count + ". Edit Quiz");
        count++;
        System.out.println(count + ". Add lesson.");
        count++;
        System.out.println(count + ". Edit Module name");
        count++;
        System.out.println(count + ". Return to edit course");

        int option = getChoice(module.getLessons().size() + 4);

        if(option == module.getLessons().size() + 1){
            editQuiz(course, module, module.getQuiz());
        } else if(option == module.getLessons().size() + 2){
            createLesson(course, module);
            editModule(course, module);
        } else if(option == module.getLessons().size() + 3){
            System.out.print("Please enter a new name for this module");
            module.setModuleName(keyboard.nextLine());
            System.out.println("Name changed!");
            editModule(course, module);
        } else if(option == module.getLessons().size() + 4){
            editCourse(course);
        } else {
            editLesson(course, module,module.getLessons().get(option - 1));
        }
    }

    /**
     * a method that allows authors to edit a lesson
     * @param course
     * @param module
     * @param lesson
     */
    public void editLesson(Course course, Module module, Lesson lesson){
        System.out.println("***** Edit Lesson" + lesson.getLessonTitle() + " *****");
        System.out.println("1. Edit lesson name\n" +
            "2. Edit lesson content\n" +
            "3. Go back\n");

        int option = getChoice(3);
        switch(option){
            case 1:
                System.out.println("Please enter a new course name:");
                lesson.setLessonTitle(keyboard.nextLine());
                break;
            case 2:
                System.out.println("Please enter new course content");
                lesson.setLessonContent(keyboard.nextLine());
                break;
            case 3:
                editModule(course, module);
        }
    }

    /**
     * a method that allows users to edit a quiz
     */
    public void editQuiz(Course course, Module module, Quiz quiz){
        System.out.println("***** Editing Quiz in: " + module.getModuleName() + " *****");

        int count = 1;
        for(Question x: quiz.getQuestions()){
            System.out.println(count + ". " + x.getQuestionTitle());
            count++;
        }

        System.out.println(count + ". Add question");
        count++;
        System.out.println(count + ". Go back to module");

        int option = getChoice(quiz.getQuestions().size() + 2);

        if(option == quiz.getQuestions().size() + 1){
            createQuestion(course, module, quiz);
            editQuiz(course, module, quiz);
        } else if(option == quiz.getQuestions().size() + 2){
            editModule(course, module);
        } else {
            editQuestion(course, module, quiz, quiz.getQuestions().get(option - 1));
        }
    }

    /**
     * a method that allows users to edit questions
     * @param course
     * @param module
     * @param quiz
     * @param question
     */
    public void editQuestion(Course course, Module module, Quiz quiz, Question question){
        System.out.println("***** Edit Question *****");
        System.out.println("Please select and item to edit");

        System.out.println("1. Question title: " + question.getQuestionTitle());
        int count = 2;
        for(String x: question.getAnswerChoices()){
            System.out.println(count + ". Answer choice: " + x);
            count++;
        }
        System.out.println(count + ". Correct answer: " + question.getCorrectAnswer());
        count++;
        System.out.println(count + ". Add a new answer choice");

        int option = getChoice(question.getAnswerChoices().size() + 2);

        if(option == 1){
            System.out.print("Please enter a new title:");
            question.setQuestionTitle(keyboard.nextLine());
            System.out.println();
            editQuestion(course, module, quiz, question);
        } else if(option == question.getAnswerChoices().size() + 1){
            System.out.print("Please enter a new answer index less than" + question.getAnswerChoices().size());
            int newAnswerIndex = getChoice(question.getAnswerChoices().size());
            question.setCorrectAnswer(newAnswerIndex);
            editQuestion(course, module, quiz, question);
        } else if(option == question.getAnswerChoices().size() + 2){
            System.out.print("Please enter a new answer choice: ");
            question.addAnswer(keyboard.nextLine());
            System.out.println();
            editQuestion(course, module, quiz, question);
        } else {
            System.out.print("Please enter a new answer choice: ");
            String newChoice = keyboard.nextLine();
            question.getAnswerChoices().set(option - 2, newChoice);
            editQuestion(course, module, quiz, question);
        }
    }

    /**
     * prints a list of author created courses
     */
    public void ViewCreatedCourses(){
        System.out.println("\n***** Courses made by me *****");
        System.out.println("***** Select a course to edit or go back *****");

        ArrayList<Course> myCourses = new ArrayList<>();

        int count = 1;
        for(Course x: CourseList.getInstance().getCourses()){
            if(x.getAuthor().getUserID().equals(lmsApplication.getCurrentUser().getUserID())){
                myCourses.add(x);
                System.out.println(count + ". " + x.getCourseName());
                count++;
            }
        }
        if(myCourses.size() == 0){
            System.out.println("You have not created any courses");
        } 

        System.out.println(count + ". Go back");
        count++;
        System.out.println(count + ". Delete a course");

       int option = getChoice(count);
       if(option == myCourses.size() + 1){
            AuthorMenu();
       } else if(option == myCourses.size() + 2){
            System.out.print("Which course would you like to delete? (Enter an integer)");
            int getDeleteCourse = getChoice(myCourses.size());

            int pos = 0;
            
            for(Course x: CourseList.getInstance().getCourses()){
                if(x.getCourseID().equals(myCourses.get(getDeleteCourse - 1).getCourseID())){
                    System.out.println("DEBUG");
                    CourseList.getInstance().getCourses().remove(pos);
                    System.out.println("Course deleted");
                    break;
                }
                pos++;
            }
            ViewCreatedCourses();
       } else {
        editCourse(myCourses.get(option - 1));
       }
    }

    /**
     * a method that gets choices for user interface
     * @param maxIndex
     * @return an integer that represents the user choice
     */
    private int getChoice(int maxIndex){
        if(maxIndex < 1){
            System.out.println("INVALID MAXINDEX");
            return (-1);
        }

        int option = 0;
        boolean validChoice = true;
        while(validChoice){
            try {
                String input = keyboard.nextLine();
                option = Integer.parseInt(input);
            } catch (Exception e){
                System.out.println("Please enter a valid integer.");
                continue;
            }

            if(option > 0 && option <= maxIndex){
                return option;
            } else {
                System.out.println("Please enter a value not greater than " + maxIndex);
            }
        }
        return(-1);
    }

}
