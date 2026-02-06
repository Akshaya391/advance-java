import java.io.*;
import java.util.Scanner;

public class StudentFileProject {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        FileWriter fw = new FileWriter("students.txt", true);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter pw = new PrintWriter(bw);

        System.out.println("📘 Student Record System");
        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Course: ");
        String course = sc.nextLine();

        pw.println(id + "," + name + "," + course);
        pw.close();

        System.out.println("✅ Student record saved to file!");

        System.out.println("\n📂 Stored Records:");
        BufferedReader br = new BufferedReader(new FileReader("students.txt"));
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
        br.close();
        sc.close();
    }
}
