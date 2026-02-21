import java.util.Scanner;
import java.util.Random;

public class TreasureHuntGame {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        System.out.println("🏴‍☠️ Welcome to Treasure Hunt Adventure 🏴‍☠️");
        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        System.out.println("\nHello " + name + "! Find the hidden treasure.");
        System.out.println("Choose a direction:");
        System.out.println("1. Left");
        System.out.println("2. Right");
        System.out.println("3. Straight");

        int choice = sc.nextInt();

        int treasureLocation = rand.nextInt(3) + 1;  // Random number between 1-3

        System.out.println("\nSearching... 🔍");

        if (choice == treasureLocation) {
            System.out.println("🎉 Congratulations! You found the treasure!");
        } else {
            System.out.println("💀 Oops! No treasure here.");
            System.out.println("The treasure was in option " + treasureLocation);
        }

        System.out.println("\n✨ Game Over ✨");
        sc.close();
    }
}