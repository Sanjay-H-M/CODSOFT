package SANJAY;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
public class QUIZ_APPLICATION {
    static String[] questions = {
            "1. What is the capital of France?",
            "2. Which planet is known as the Red Planet?",
            "3. Who wrote 'Romeo and Juliet'?",
            "4. What is the largest ocean on Earth?"
    };

    static String[][] options = {
            {"a) London", "b) Paris", "c) Rome", "d) Madrid"},
            {"a) Earth", "b) Mars", "c) Jupiter", "d) Venus"},
            {"a) William Wordsworth", "b) William Shakespeare", "c) Charles Dickens", "d) Mark Twain"},
            {"a) Atlantic", "b) Indian", "c) Pacific", "d) Arctic"}
    };

    static char[] correctAnswers = {'b', 'b', 'b', 'c'};

    static int score = 0;
    static int currentQuestion = 0;
    static boolean timeUp = false;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the Quiz!");
        for (int i = 0; i < questions.length; i++) {
            currentQuestion = i;
            timeUp = false;
            askQuestion(sc);
        }

        displayResult();
        sc.close();
    }

    public static void askQuestion(Scanner sc) {
        System.out.println(questions[currentQuestion]);
        for (String option : options[currentQuestion]) {
            System.out.println(option);
        }

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            public void run() {
                timeUp = true;
                System.out.println("\nTime's up!");
            }
            }, 10000);

        char answer = sc.next().charAt(0);
        if (!timeUp) {
            checkAnswer(answer);
        }
        timer.cancel();
    }
    public static void checkAnswer(char answer) {
        if (answer == correctAnswers[currentQuestion]) {
            System.out.println("Correct!");
            score++;
        } else {
            System.out.println("Incorrect. The correct answer was: " + correctAnswers[currentQuestion]);
        }
    }

    public static void displayResult() {
        System.out.println("\nQuiz Over!");
        System.out.println("Your final score is: " + score + "/" + questions.length);
        System.out.println("Thanks for playing!");
    }
}

