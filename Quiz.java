package budgetLMS;
import java.util.ArrayList;
import java.util.Scanner;

public class Quiz {
    Scanner input = new Scanner(System.in);
    private ArrayList<Question> questions;
    private int answersCorrect = 0;

    public Quiz(ArrayList<Question> listOfQuestions) {
        questions = listofQuestions;
    }
    public void takeQuiz() {
        int userAnswer;
        for(Question x: listofQuestions) {
            System.out.println(x.getQuestion());
            x.printChoices();
            userAnswer = scanner.nextInt();
            if(userAnswer == x.getCorrectAnswer()) {
                System.out.println("correct");
                answersCorrect++;
            } else {
                System.out.println("Incorrect");
            }
        }
    }
    public void addQuestion(Question question) {
        questions.add(question);
    }
    public void addQuestion(int index) {
        questions.add(index, questions);
    }
    public void removeQuestion(int index) {
        questions.remove(index);
    }
    private boolean quizPassedCheck() {
        double score = answersCorrect/questions.size();
        return (score >= 0.8); 
            
    }
}
