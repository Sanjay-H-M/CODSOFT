package SANJAY;
import java.util.Scanner;
import java.util.Random;

public class NUMBER_GAME{
    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        Random random_num = new Random();
        int total_score = 0;
        int Rounds = 5;
        boolean playAgain = true;
        System.out.println("WELCOME TO GUESS A NUMBER GAME...!");
        while (playAgain && Rounds>0){
            int Generated_num = random_num.nextInt(100)+1;
            int attempts = 5;
            boolean correct_guess = false;

            System.out.println("Round "+ (6-Rounds)+":Guess a number between 1 to 100 within "+ attempts +" no.of attempts");
            while(attempts>0){
                System.out.println("Guess a number :");
                int Guess = obj.nextInt();

                if(Guess==Generated_num){
                    int attemptsTaken = 5-attempts+1;
                    System.out.println("Wow! you guessed the number correctly in "+ attemptsTaken+" attempts");
                    total_score+=attempts;
                    correct_guess = true;
                    break;
                }
                else if(Guess>Generated_num){
                    System.out.println("Your guess is Too high!,try again");
                }
                else{
                    System.out.println("Your guess is Too low!,try again");
                }
                attempts--;
                System.out.println("Attempts Remaining "+attempts);
            }
            if(!correct_guess){
                System.out.println("Sorry, you're out of attempts.The correct answer was "+Generated_num+".");
            }
            Rounds--;
        }
        if(Rounds>0){
            System.out.println("Do you wants to play another round (Yes/No)?");
            playAgain = obj.next().equalsIgnoreCase("Yes");
        }
        System.out.println("Game over...! Your Total score is "+total_score);
        obj.close();
    }
}