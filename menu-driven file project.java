import java.io.*;
import java.util.Scanner;

public class StudentMenuProject {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n📘 Student Record System");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    FileWriter fw = new FileWriter("students.txt", true);
                    PrintWriter pw = new PrintWriter(fw);

                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Course: ");
                    String course = sc.nextLine();

                    pw.println(id + "," + name + "," + course);
                    pw.close();
                    System.out.println("✅ Student Added");
                    break;

                case 2:
                    BufferedReader br = new BufferedReader(
                            new FileReader("students.txt"));
                    String line;

                    System.out.println("\n📂 Student Records:");
                    while ((line = br.readLine()) != null) {
                        System.out.println(line);
                    }
                    br.close();
                    break;

                case 3:
                    System.out.print("Enter name to search: ");
                    String search = sc.nextLine();

                    BufferedReader br2 = new BufferedReader(
                            new FileReader("students.txt"));
                    boolean found = false;

                    while ((line = br2.readLine()) != null) {
                        if (line.toLowerCase().contains(search.toLowerCase())) {
                            System.out.println("✅ Found: " + line);
                            found = true;
                        }
                    }
                    if (!found)
                        System.out.println("❌ Student not found");

                    br2.close();
                    break;

                case 4:
                    System.out.println("👋 Exiting Program");
                    break;

                default:
                    System.out.println("❌ Invalid Choice");
            }

        } while (choice != 4);

        sc.close();
    }
}
