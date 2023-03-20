/**
 * This is going to push quizzes and allow changes to quizzes
 * @author word.exe
 */
package budgetLMS;
import java.util.ArrayList;

public class Quiz {
    private ArrayList<Question> questions;

    /**
     * This is going to display the information for the class quiz
     */
    public Quiz() {

    }

    public Quiz(ArrayList<Question> questions) {
        this.questions = questions;
    }

    /**
     * This is going to allow the user to take a quiz
     */
    public void takeQuiz() {
        
    }

    /**
     * This is going to add a question to a quiz
     */
    public void addQuestion(Question question) {
        this.questions.add(question);
    }

    /**
     * This is going to add a question to the index and set a position for them
     * @param index this is the locations in an index of all of the questions
     */
    public void addQuestion(Question question, int index) {

    }

    /**
     * This is going to remove a question from the index
     * @param index this is the locations in an index of all of the questions
     */
    public void removeQuestion(int index) {

    }

    /**
     * This is going to check if the user passed the quiz based on the score inputted
     * @return This will return true if they passed if they got over a certain score on the quiz, and
     * it will return false if they do not get a high enough score
     */
    private boolean quizPassedCheck() {
        
    }

    public ArrayList<Question> getQuestions() {
        return this.questions;
    }

}
