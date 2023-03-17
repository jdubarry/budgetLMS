package budgetLMS;

public class frontEnd {

    public frontEnd(){
        Scanner keyboard = new Scanner(System.in);
    }

    public void printMainMenu(){
        System.out.println("********** Main Menu **********\n" +
            "1. Login\n" +
            "2. Sign up.");
    }
    /**
     * Currently doesn't return anything
     * Can be modified to return an array of Strings, the first being the username and the second being 
     */
    public void printLoginMenu(){
        String username;
        String password;

        System.out.println("********** Login Menu **********" +
            "Username: ");
        username = keyboard.nextln();

        System.out.println("Password: ");
        password = keyboard.nextln;

    }
}
