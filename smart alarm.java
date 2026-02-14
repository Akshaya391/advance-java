import java.util.Scanner;
import java.time.LocalTime;

public class SmartAlarmMotivation {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        LocalTime time = LocalTime.now();

        System.out.println("🌟 Smart Alarm & Motivation System 🌟");
        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        int hour = time.getHour();

        System.out.println("\nHello " + name + "!");
        
        if (hour >= 5 && hour < 12) {
            System.out.println("🌅 Good Morning!");
            System.out.println("Quote: Today is a new chance to be better.");
        } 
        else if (hour >= 12 && hour < 17) {
            System.out.println("☀️ Good Afternoon!");
            System.out.println("Quote: Stay focused and keep moving forward.");
        } 
        else if (hour >= 17 && hour < 21) {
            System.out.println("🌇 Good Evening!");
            System.out.println("Quote: Small progress is still progress.");
        } 
        else {
            System.out.println("🌙 Good Night!");
            System.out.println("Quote: Rest well, tomorrow is powerful.");
        }

        System.out.println("\n✨ Have a great day, " + name + "! ✨");
        sc.close();
    }
}
