import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuizApp  {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        List<Question> questions= new ArrayList<>();

        questions.add(new Question("What is the capital of India?",
                new String[]{"1. Mumbai", "2. New Delhi", "3. Chennai", "4. Kolkata"},2));

        questions.add(new Question("Which language is used for Android development?",
                new String[]{"1. Python", "2. Swift", "3. Java", "4. C++"}, 3));

        questions.add(new Question("Which company developed Java?",
                new String[]{"1. Microsoft", "2. Sun Microsystems", "3. Apple", "4. IBM"}, 2));


        int score=0;
        System.out.println("\n==== Welcome to the Online Quiz App ====\n");

        for(int i =0; i<questions.size();i++){
            Question q = questions.get(i);
            System.out.println("Q " + (i+1) + ": " + q.questions);
            for (String opt: q.options){
                System.out.println(opt);
            }

            System.out.println("Enter your answer (1-4): ");
            int ans = sc.nextInt();

            if (q.isCorrect(ans)){
                System.out.println("Correct! \n");
                score++;
            } else {
                System.out.println("Oops! Wrong! Correct answer: Option " + q.correctAnswer + "\n");
            }
        }
        System.out.println("===== Quiz Finished =====");
        System.out.println("Your Score: " + score + " / " + questions.size());

        if (score == questions.size()) {
            System.out.println("Excellent! You got all answers right!");
        } else if (score >= questions.size() / 2) {
            System.out.println("Good job!");
        } else {
            System.out.println("Keep practicing!");
        }

        sc.close();
    }




}
class Question{

     String questions;
     String[] options;
     int correctAnswer;

    public Question(String questions, String[] options, int correctAnswer){
        this.questions = questions;
        this.options = options;
        this.correctAnswer = correctAnswer;

    }

    Boolean isCorrect(int ans){
        return ans == correctAnswer;
    }
}
