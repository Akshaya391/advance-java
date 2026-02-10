import java.util.Scanner;

public class MiniLifeAssistant {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println(" Welcome to Mini Life Assistant ");
        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        System.out.println("\nHi " + name + "! How are you feeling today?");
        System.out.println("1. Happy ");
        System.out.println("2. Sad ");
        System.out.println("3. Stressed ");
        System.out.print("Choose a number (1-3): ");

        int mood = sc.nextInt();

        System.out.println("\n Message for you:");

        switch (mood) {
            case 1:
                System.out.println("Keep smiling! Your happiness is contagious ");
                break;
            case 2:
                System.out.println("It's okay to feel sad. Better days are coming ");
                break;
            case 3:
                System.out.println("Take a deep breath. You are stronger than you think ");
                break;
            default:
                System.out.println("Invalid choice! But hey, you're still awesome ");
        }

        System.out.println("\n Have a wonderful day ahead, " + name + "! ");
        sc.close();
    }
}
