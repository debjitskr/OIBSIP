import java.util.Scanner;
import java.util.Random;
class guess_num_game{
    public void Game(){
        Scanner sc=new Scanner(System.in);
        Random random=new Random();

        int lowerBound = 1;
        int upperBound = 100;
        int targetNum = random.nextInt(upperBound - lowerBound + 1) + lowerBound;

        int maxAttempts = 10;
        int currentRound = 1;
        int totalScore = 0;

        System.out.println("\n\n------------Welcome to Guess The Number Game------------");
        System.out.println("\nTry to guess the number between "+lowerBound+" and "+upperBound+" .\n");
        System.out.println("Maximum number of attempts is "+maxAttempts+"\nAll the best.\n");
        while(currentRound <= maxAttempts){
            System.out.println("Round "+currentRound+" ---> Enter your guess: ");
            int userGuess = sc.nextInt();

            if(userGuess == targetNum) {
                int score = maxAttempts - currentRound + 1;
                System.out.println("Congratulations !!! You the guessed number in " + currentRound + " attempts.");
                System.out.println("You Scored --> " + score);
                totalScore += score;
                break;
            } else if (userGuess < targetNum) {
                System.out.println("\n"+userGuess+" is lower than the correct number. Try a higher number");
            }else {
                System.out.println("\n"+userGuess+" is greater than the correct number. Try a lower number");
            }
            currentRound++;
            if(currentRound > maxAttempts){
                System.out.println("Oops! You've used all your attempts.");
                System.out.println("The correct number was: "+targetNum);
            }
            System.out.println("Total score: "+totalScore+"\n");
        }
    }
}
public class Task_2 {
    public static void main(String[] args){
        guess_num_game ob=new guess_num_game();
        ob.Game();
        System.out.println("Thanks for playing.");
    }
}
