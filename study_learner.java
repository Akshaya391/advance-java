import java.util.Scanner;

public class StudyPlanner {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("📚 Smart Study Planner 📚");
        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        System.out.print("Enter subject name: ");
        String subject = sc.nextLine();

        System.out.print("Enter number of hours studied today: ");
        int hours = sc.nextInt();

        System.out.println("\n📊 Performance Report for " + name);

        if (hours >= 6) {
            System.out.println("🔥 Excellent dedication in " + subject + "!");
            System.out.println("Keep this consistency for top results!");
        }
        else if (hours >= 3) {
            System.out.println("👍 Good effort in " + subject + ".");
            System.out.println("Try to increase 1-2 more hours tomorrow.");
        }
        else if (hours > 0) {
            System.out.println("⚠️ You need to focus more on " + subject + ".");
            System.out.println("Make a proper timetable.");
        }
        else {
            System.out.println("❌ No study today!");
            System.out.println("Start small, even 1 hour makes difference.");
        }

        System.out.println("\n✨ Success is built daily, " + name + "! ✨");

        sc.close();
    }
}