/**
 * This is going to set up quizzes
 * @author word.exe
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Quiz {
    Scanner input = new Scanner(System.in);
    private ArrayList<Question> questions;
    private int answersCorrect = 0;

    /**
     * This is going to create an array list of the questions
     */
    public Quiz() {
        this.questions = new ArrayList<Question>();
    }

    /**
     * This is going to set up the array list of questions in each quiz
     * @param listOfQuestions the list of questions made
     */
    public Quiz(ArrayList<Question> questions) {
        this.questions = questions;
    }

    /**
     * This is going to allow the user to take a quiz
     */
    public void takeQuiz() {
        int userAnswer;
        for(Question x: questions) {
            System.out.println(x.getQuestion());
            x.printChoices();
            Scanner scan = new Scanner(System.in);
            userAnswer = scan.nextInt();
            if(userAnswer == x.getCorrectAnswer()) {
                System.out.println("correct");
                answersCorrect++;
            } else {
                System.out.println("Incorrect");
            }
        }
    }
    
    /**
     * This is going to allow for a question to be added 
     * @param question the question being added in
     */
    public void addQuestion(Question question) {
        questions.add(question);
    }

    /**
     * This is going to add the question in to a position in the index
     * @param index the location of the question
     */
    public void addQuestion(Question question, int index) {
        questions.add(index, question);
    }

    /**
     * This is going to remove questions from the index
     * @param index the location of the question
     */
    public void removeQuestion(int index) {
        questions.remove(index);
    }

    /**
     * This is going to display if the user passed the quiz
     * @return the score higher or equal to .8 and will return true if passed and false if not passed
     */
    private boolean quizPassedCheck() {
        double score = answersCorrect/questions.size();
        return (score >= 0.8);   
    }

    /**
     * This is going to pull the questions 
     * @return the question is returned
     */
    public ArrayList<Question> getQuestions() {
        return this.questions;
    }

}
