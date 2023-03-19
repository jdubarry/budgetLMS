package budgetLMS;
import java.util.ArrayList;

public class Question {
    private String questionTitle;
    private ArrayList<String> answerChoices;
    private int correctAnswer;

    public Question(String title) {
        questionTitle = title;
        
    }

    public String getQuestion() {
        return questionTitle + "\n";
    }
    public void removeAnswer(int index) {
        answerChoices.remove(index);
        
    }
    public void addAnswer(String answer) {
        answerChoices.add(answer);
    }
    public void addAnswer(int index, String answer) {
        answerChoices.add(index, answer);
    }
    public void printChoices() {
        int number = 1;
        for(String x: answerChoices) {
            System.out.println(number + "." + x + "\n");
            number++;
        }
    }
    public void printCorrectAnswer() {
        answerChoices.get(correctAnswer);
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }
}
