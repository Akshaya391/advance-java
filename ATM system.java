import java.util.Scanner;

public class ATMProject {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int pin = 1234, balance = 10000, choice;
        boolean exit = false;

        System.out.print("Enter ATM PIN: ");
        if (sc.nextInt() != pin) {
            System.out.println("❌ Wrong PIN!");
            return;
        }

        System.out.println("✅ Login Successful");

        while (!exit) {
            System.out.println("\n1.Check Balance\n2.Deposit\n3.Withdraw\n4.Exit");
            System.out.print("Choose option: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("💰 Balance: ₹" + balance);
                    break;
                case 2:
                    System.out.print("Enter amount: ");
                    balance += sc.nextInt();
                    System.out.println("✅ Deposited");
                    break;
                case 3:
                    System.out.print("Enter amount: ");
                    int amt = sc.nextInt();
                    if (amt <= balance) {
                        balance -= amt;
                        System.out.println("✅Withdrawn");
                    } else
                        System.out.println("❌ Insufficient Balance");
                    break;
                case 4:
                    exit = true;
                    System.out.println("👋 Thank you!");
                    break;
                default:
                    System.out.println("❌ Invalid choice");
            }
        }
        sc.close();
    }
}
