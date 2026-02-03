import java.util.Scanner;
import java.util.ArrayList;

public class ExpenseTracker {
    
    // Expense class to store each expense
    static class Expense {
        String description;
        double amount;
        String date;
        String category;
        
        Expense(String description, double amount, String date, String category) {
            this.description = description;
            this.amount = amount;
            this.date = date;
            this.category = category;
        }
    }
    
    static ArrayList<Expense> expenses = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    static double budget = 0;
    
    public static void main(String[] args) {
        System.out.println("💰 PERSONAL EXPENSE TRACKER");
        System.out.println("============================\n");
        
        System.out.print("Set your monthly budget: $");
        budget = scanner.nextDouble();
        
        boolean running = true;
        
        while (running) {
            System.out.println("\n╔════════════════════════════╗");
            System.out.println("║        MAIN MENU          ║");
            System.out.println("╚════════════════════════════╝");
            System.out.println("1. 💸 Add Expense");
            System.out.println("2. 📊 View All Expenses");
            System.out.println("3. 📈 Budget Summary");
            System.out.println("4. 🏷️  Expenses by Category");
            System.out.println("5. 🔝 Top 5 Expenses");
            System.out.println("6. 🗓️  Expenses by Date");
            System.out.println("7. 💡 Savings Suggestion");
            System.out.println("8. 🚪 Exit");
            System.out.print("\nChoice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1: addExpense(); break;
                case 2: viewAllExpenses(); break;
                case 3: budgetSummary(); break;
                case 4: expensesByCategory(); break;
                case 5: topExpenses(); break;
                case 6: expensesByDate(); break;
                case 7: savingsSuggestion(); break;
                case 8: 
                    System.out.println("\n💼 Thank you! Keep tracking your expenses!");
                    running = false;
                    break;
                default: System.out.println("❌ Invalid choice!");
            }
        }
        
        scanner.close();
    }
    
    static void addExpense() {
        System.out.println("\n💸 ADD NEW EXPENSE");
        System.out.println("-------------------");
        
        System.out.print("Description: ");
        String desc = scanner.nextLine();
        
        System.out.print("Amount: $");
        double amount = scanner.nextDouble();
        scanner.nextLine();
        
        System.out.print("Date (DD/MM/YYYY): ");
        String date = scanner.nextLine();
        
        System.out.println("\nCategory:");
        System.out.println("1. 🍔 Food");
        System.out.println("2. 🚗 Transport");
        System.out.println("3. 🏠 Bills");
        System.out.println("4. 🎬 Entertainment");
        System.out.println("5. 🛒 Shopping");
        System.out.println("6. 🏥 Healthcare");
        System.out.println("7. 📚 Education");
        System.out.println("8. 💼 Other");
        System.out.print("Choice: ");
        int cat = scanner.nextInt();
        scanner.nextLine();
        
        String[] categories = {"", "Food", "Transport", "Bills", "Entertainment", 
                              "Shopping", "Healthcare", "Education", "Other"};
        String category = (cat >= 1 && cat <= 8) ? categories[cat] : "Other";
        
        Expense exp = new Expense(desc, amount, date, category);
        expenses.add(exp);
        
        System.out.println("\n✅ Expense added successfully!");
        
        double totalSpent = getTotalExpenses();
        double remaining = budget - totalSpent;
        
        if (remaining < 0) {
            System.out.println("⚠️  WARNING: You've exceeded your budget by $" + 
                             String.format("%.2f", Math.abs(remaining)));
        } else if (remaining < budget * 0.2) {
            System.out.println("⚠️  ALERT: Only $" + String.format("%.2f", remaining) + 
                             " left in budget!");
        }
    }
    
    static void viewAllExpenses() {
        if (expenses.isEmpty()) {
            System.out.println("\n📭 No expenses recorded!");
            return;
        }
        
        System.out.println("\n📊 ALL EXPENSES");
        System.out.println("════════════════════════════════════════════════");
        System.out.printf("%-5s %-15s %-12s %-10s %-12s\n", 
                         "No.", "Description", "Amount", "Date", "Category");
        System.out.println("════════════════════════════════════════════════");
        
        for (int i = 0; i < expenses.size(); i++) {
            Expense e = expenses.get(i);
            System.out.printf("%-5d %-15s $%-11.2f %-10s %-12s\n", 
                            (i+1), e.description, e.amount, e.date, e.category);
        }
        System.out.println("════════════════════════════════════════════════");
        System.out.printf("TOTAL: $%.2f\n", getTotalExpenses());
    }
    
    static void budgetSummary() {
        double totalSpent = getTotalExpenses();
        double remaining = budget - totalSpent;
        double percentage = (totalSpent / budget) * 100;
        
        System.out.println("\n📈 BUDGET SUMMARY");
        System.out.println("═══════════════════════════════");
        System.out.printf("Monthly Budget:    $%.2f\n", budget);
        System.out.printf("Total Spent:       $%.2f\n", totalSpent);
        System.out.printf("Remaining:         $%.2f\n", remaining);
        System.out.printf("Budget Used:       %.1f%%\n", percentage);
        System.out.println("═══════════════════════════════");
        
        // Visual progress bar
        int bars = (int)(percentage / 5);
        System.out.print("Progress: [");
        for (int i = 0; i < 20; i++) {
            if (i < bars) System.out.print("█");
            else System.out.print("░");
        }
        System.out.println("]");
        
        if (remaining < 0) {
            System.out.println("\n🚨 OVER BUDGET! Reduce spending!");
        } else if (percentage > 80) {
            System.out.println("\n⚠️  WARNING: You've used 80% of your budget!");
        } else if (percentage > 50) {
            System.out.println("\n💡 TIP: You're halfway through your budget!");
        } else {
            System.out.println("\n✅ Great! You're within budget!");
        }
    }
    
    static void expensesByCategory() {
        if (expenses.isEmpty()) {
            System.out.println("\n📭 No expenses to categorize!");
            return;
        }
        
        String[] categories = {"Food", "Transport", "Bills", "Entertainment", 
                              "Shopping", "Healthcare", "Education", "Other"};
        
        System.out.println("\n🏷️  EXPENSES BY CATEGORY");
        System.out.println("═══════════════════════════════");
        
        for (String cat : categories) {
            double catTotal = 0;
            int count = 0;
            
            for (Expense e : expenses) {
                if (e.category.equals(cat)) {
                    catTotal += e.amount;
                    count++;
                }
            }
            
            if (count > 0) {
                System.out.printf("%-15s: $%-8.2f (%d items)\n", cat, catTotal, count);
            }
        }
        System.out.println("═══════════════════════════════");
    }
    
    static void topExpenses() {
        if (expenses.isEmpty()) {
            System.out.println("\n📭 No expenses recorded!");
            return;
        }
        
        // Sort expenses by amount (bubble sort)
        ArrayList<Expense> sorted = new ArrayList<>(expenses);
        for (int i = 0; i < sorted.size() - 1; i++) {
            for (int j = 0; j < sorted.size() - i - 1; j++) {
                if (sorted.get(j).amount < sorted.get(j + 1).amount) {
                    Expense temp = sorted.get(j);
                    sorted.set(j, sorted.get(j + 1));
                    sorted.set(j + 1, temp);
                }
            }
        }
        
        System.out.println("\n🔝 TOP 5 HIGHEST EXPENSES");
        System.out.println("═══════════════════════════════════════");
        
        int limit = Math.min(5, sorted.size());
        for (int i = 0; i < limit; i++) {
            Expense e = sorted.get(i);
            System.out.printf("%d. %-15s $%.2f (%s)\n", 
                            (i+1), e.description, e.amount, e.category);
        }
        System.out.println("═══════════════════════════════════════");
    }
    
    static void expensesByDate() {
        if (expenses.isEmpty()) {
            System.out.println("\n📭 No expenses recorded!");
            return;
        }
        
        System.out.print("\n🗓️  Enter date (DD/MM/YYYY): ");
        String searchDate = scanner.nextLine();
        
        boolean found = false;
        double dayTotal = 0;
        
        System.out.println("\n📅 EXPENSES ON " + searchDate);
        System.out.println("═══════════════════════════════════════");
        
        for (Expense e : expenses) {
            if (e.date.equals(searchDate)) {
                System.out.printf("%-15s $%-8.2f [%s]\n", 
                                e.description, e.amount, e.category);
                dayTotal += e.amount;
                found = true;
            }
        }
        
        if (found) {
            System.out.println("═══════════════════════════════════════");
            System.out.printf("Total for this day: $%.2f\n", dayTotal);
        } else {
            System.out.println("❌ No expenses on this date!");
        }
    }
    
    static void savingsSuggestion() {
        if (expenses.isEmpty()) {
            System.out.println("\n📭 Record some expenses first!");
            return;
        }
        
        double totalSpent = getTotalExpenses();
        double remaining = budget - totalSpent;
        
        System.out.println("\n💡 SAVINGS SUGGESTIONS");
        System.out.println("═══════════════════════════════════════");
        
        if (remaining > 0) {
            System.out.printf("Great! You have $%.2f left.\n", remaining);
            System.out.println("\n📌 Suggestions:");
            System.out.printf("• Save 50%% ($%.2f) for emergencies\n", remaining * 0.5);
            System.out.printf("• Invest 30%% ($%.2f) for future\n", remaining * 0.3);
            System.out.printf("• Enjoy 20%% ($%.2f) guilt-free!\n", remaining * 0.2);
        } else {
            System.out.printf("You're over budget by $%.2f\n", Math.abs(remaining));
            System.out.println("\n📌 Tips to save:");
            System.out.println("• Cut unnecessary shopping");
            System.out.println("• Cook at home more often");
            System.out.println("• Use public transport");
            System.out.println("• Cancel unused subscriptions");
        }
        
        System.out.println("═══════════════════════════════════════");
    }
    
    static double getTotalExpenses() {
        double total = 0;
        for (Expense e : expenses) {
            total += e.amount;
        }
        return total;
    }
}