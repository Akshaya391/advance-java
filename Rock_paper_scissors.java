import java.util.Scanner;
import java.util.Random;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int playerScore = 0;
        int computerScore = 0;
        int rounds = 0;
        boolean playAgain = true;
        
        System.out.println("✊✋✌️  Rock Paper Scissors Game");
        System.out.println("================================\n");
        
        while (playAgain) {
            rounds++;
            System.out.println("Round " + rounds);
            System.out.println("---------");
            System.out.println("1. ✊ Rock");
            System.out.println("2. ✋ Paper");
            System.out.println("3. ✌️  Scissors");
            System.out.print("\nYour choice (1-3): ");
            
            int playerChoice = scanner.nextInt();
            int computerChoice = random.nextInt(3) + 1;
            
            String[] choices = {"", "✊ Rock", "✋ Paper", "✌️  Scissors"};
            
            System.out.println("\nYou chose: " + choices[playerChoice]);
            System.out.println("Computer chose: " + choices[computerChoice]);
            
            if (playerChoice == computerChoice) {
                System.out.println("🤝 It's a TIE!\n");
            } else if ((playerChoice == 1 && computerChoice == 3) ||
                       (playerChoice == 2 && computerChoice == 1) ||
                       (playerChoice == 3 && computerChoice == 2)) {
                System.out.println(" You WIN this round!\n");
                playerScore++;
            } else {
                System.out.println("Computer WINS this round!\n");
                computerScore++;
            }
            
            System.out.println("Score: You " + playerScore + " - " + computerScore + " Computer");
            
            System.out.print("\nPlay another round? (1=Yes, 0=No): ");
            int continueChoice = scanner.nextInt();
            playAgain = (continueChoice == 1);
        }
        
        System.out.println("\n========== FINAL SCORE ==========");
        System.out.println("You: " + playerScore);
        System.out.println("Computer: " + computerScore);
        if (playerScore > computerScore) {
            System.out.println(" YOU WIN THE GAME!");
        } else if (computerScore > playerScore) {
            System.out.println(" COMPUTER WINS THE GAME!");
        } else {
            System.out.println(" IT'S A TIE GAME!");
        }
        System.out.println("=================================");
        
        scanner.close();
    }
}