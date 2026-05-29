import java.util.*;
public class NumberGuessing {
    public static void main(String[] args) {
        Random random = new Random();
        int t = random.nextInt(100) + 1;
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        
        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("Try to guess the number between 1 and 100.");
        
        int userGuess = 0;
        while (userGuess != t) {
            System.out.print("Enter your guess: ");
            userGuess = scanner.nextInt();
            
            if (userGuess < t) {
                System.out.println("Too low!Try again.");
            } else if (userGuess > t) {
                System.out.println("Too high!Try again.");
            } else {
                System.out.println("Congratulations!You've guessed the number!");
            }
        }
        
    }
}
