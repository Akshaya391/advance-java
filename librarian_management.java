import java.util.Scanner;

public class LibrarySystem {

    static int[] ids = new int[10];
    static String[] titles = new String[10];
    static boolean[] issued = new boolean[10];
    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n📚 LIBRARY MANAGEMENT SYSTEM");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Book ID: ");
                    ids[count] = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Book Title: ");
                    titles[count] = sc.nextLine();
                    issued[count] = false;
                    count++;
                    System.out.println("✅ Book Added");
                    break;

                case 2:
                    System.out.println("\nBook List:");
                    for (int i = 0; i < count; i++) {
                        System.out.println(
                          ids[i] + " - " + titles[i] +
                          (issued[i] ? " (Issued)" : " (Available)")
                        );
                    }
                    break;

                case 3:
                    System.out.print("Enter Book ID to issue: ");
                    int issueId = sc.nextInt();
                    for (int i = 0; i < count; i++) {
                        if (ids[i] == issueId && !issued[i]) {
                            issued[i] = true;
                            System.out.println("📕 Book Issued");
                            break;
                        }
                    }
                    break;

                case 4:
                    System.out.print("Enter Book ID to return: ");
                    int returnId = sc.nextInt();
                    for (int i = 0; i < count; i++) {
                        if (ids[i] == returnId && issued[i]) {
                            issued[i] = false;
                            System.out.println("📗 Book Returned");
                            break;
                        }
                    }
                    break;

                case 5:
                    System.out.println("👋 Exiting System");
                    break;

                default:
                    System.out.println("❌ Invalid choice");
            }

        } while (choice != 5);

        sc.close();
    }
}
