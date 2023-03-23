/**
 * This is going to create the questions for the quiz
 * @author word.exe
 */
import java.util.ArrayList;

public class Question {
    private String questionTitle;
    private ArrayList<String> answerChoices;
    private int correctAnswer;

    /**
     * This is going to set up a question 
     * @param title this is going to be the name of the question 
     */
    public Question(String title) {
        questionTitle = title;
        this.answerChoices = new ArrayList<String>();
    }

    public String getQuestion() {
        return questionTitle + "\n";
    }

    /**
     * This is going to remove certain answers from the questions
     * @param index this is going to set up answers at a certain index
     */

    public void removeAnswer(int index) {
        answerChoices.remove(index);
    }

    /**
     * This is going to add an answer to a question
     * @param answer The answer that is added to the question as an option
     */
    public void addAnswer(String answer) {
        answerChoices.add(answer);
    }

    /**
     * This is going to assign the answer to a certain location
     * @param index this is going to be the location in the index where the answer is saved
     * @param answer the answer that is added to the question as an option
     */
    public void addAnswer(int index, String answer) {
        answerChoices.add(index, answer);
    }

    /**
     * This will print the answer choices to each quiz question
     */
    public void printChoices() {
        int number = 1;
        for(String x: answerChoices) {
            System.out.println(number + "." + x + "\n");
            number++;
        }
    }

    /**
     * This is going to print the correct answer based on the question
     */
    public void printCorrectAnswer() {
        answerChoices.get(correctAnswer);
    }

    /**
     * This is going to get the question title
     * @return the question title
     */
    public String getQuestionTitle() {
        return this.questionTitle;
    }

    /**
     * This is going to set the question title 
     * @param questionTitle the question title that was named
     */
    public void setQuestionTitle(String questionTitle) {
        this.questionTitle = questionTitle;
    }

    /**
     * This is going to get the answer choices for the questions
     * @return This is going to return the answer choices
     */
    public ArrayList<String> getAnswerChoices() {
        return this.answerChoices;
    }

    /**
     * This is going to get the correct answer for the question
     * @return the correct answer is returned
     */
    public int getCorrectAnswer() {
        return this.correctAnswer;
    }

    /**
     * This is going to set the correct answer
     * @param correctAnswer the correct answer for the quiz
     */
    public void setCorrectAnswer(int correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
    
}
