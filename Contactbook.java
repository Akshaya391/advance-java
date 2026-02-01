import java.util.Scanner;
import java.util.ArrayList;

public class ContactBook {
    
    // Contact class to store contact information
    static class Contact {
        String name;
        String phone;
        String email;
        String category;
        
        Contact(String name, String phone, String email, String category) {
            this.name = name;
            this.phone = phone;
            this.email = email;
            this.category = category;
        }
        
        void displayContact() {
            System.out.println("┌─────────────────────────────────");
            System.out.println("│ Name: " + name);
            System.out.println("│ Phone: " + phone);
            System.out.println("│ Email: " + email);
            System.out.println("│ Category: " + category);
            System.out.println("└─────────────────────────────────");
        }
    }
    
    static ArrayList<Contact> contacts = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.println("CONTACT BOOK MANAGER");
        System.out.println("========================\n");
        
        boolean running = true;
        
        while (running) {
            System.out.println("\n1.  Add New Contact");
            System.out.println("2.  View All Contacts");
            System.out.println("3.  Search Contact");
            System.out.println("4.   Delete Contact");
            System.out.println("5.  Show Contact Count");
            System.out.println("6.   View by Category");
            System.out.println("7.  Exit");
            System.out.print("\nChoice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear buffer
            
            switch (choice) {
                case 1:
                    addContact();
                    break;
                case 2:
                    viewAllContacts();
                    break;
                case 3:
                    searchContact();
                    break;
                case 4:
                    deleteContact();
                    break;
                case 5:
                    showCount();
                    break;
                case 6:
                    viewByCategory();
                    break;
                case 7:
                    System.out.println("\n Goodbye! Your contacts are safe!");
                    running = false;
                    break;
                default:
                    System.out.println(" Invalid choice!");
            }
        }
        
        scanner.close();
    }
    
    static void addContact() {
        System.out.println("\n ADD NEW CONTACT");
        System.out.println("-------------------");
        
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter Phone: ");
        String phone = scanner.nextLine();
        
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();
        
        System.out.println("\nSelect Category:");
        System.out.println("1. Family");
        System.out.println("2. Friends");
        System.out.println("3. Work");
        System.out.println("4. Other");
        System.out.print("Choice: ");
        int catChoice = scanner.nextInt();
        scanner.nextLine();
        
        String category = "";
        switch (catChoice) {
            case 1: category = "Family"; break;
            case 2: category = "Friends"; break;
            case 3: category = "Work"; break;
            case 4: category = "Other"; break;
            default: category = "Other";
        }
        
        Contact newContact = new Contact(name, phone, email, category);
        contacts.add(newContact);
        
        System.out.println("\n Contact saved successfully!");
    }
    
    static void viewAllContacts() {
        if (contacts.isEmpty()) {
            System.out.println("\n No contacts found!");
            return;
        }
        
        System.out.println("\n ALL CONTACTS (" + contacts.size() + ")");
        System.out.println("═════════════════════════════════");
        
        for (int i = 0; i < contacts.size(); i++) {
            System.out.println("\n[" + (i + 1) + "]");
            contacts.get(i).displayContact();
        }
    }
    
    static void searchContact() {
        if (contacts.isEmpty()) {
            System.out.println("\n No contacts to search!");
            return;
        }
        
        System.out.print("\n Enter name to search: ");
        String searchName = scanner.nextLine().toLowerCase();
        
        boolean found = false;
        System.out.println("\n SEARCH RESULTS");
        System.out.println("═════════════════════════════════");
        
        for (Contact contact : contacts) {
            if (contact.name.toLowerCase().contains(searchName)) {
                contact.displayContact();
                found = true;
            }
        }
        
        if (!found) {
            System.out.println(" No contact found with name: " + searchName);
        }
    }
    
    static void deleteContact() {
        if (contacts.isEmpty()) {
            System.out.println("\n No contacts to delete!");
            return;
        }
        
        viewAllContacts();
        System.out.print("\nEnter contact number to delete: ");
        int index = scanner.nextInt();
        scanner.nextLine();
        
        if (index > 0 && index <= contacts.size()) {
            Contact deleted = contacts.remove(index - 1);
            System.out.println("\n Deleted: " + deleted.name);
        } else {
            System.out.println(" Invalid contact number!");
        }
    }
    
    static void showCount() {
        int family = 0, friends = 0, work = 0, other = 0;
        
        for (Contact contact : contacts) {
            switch (contact.category) {
                case "Family": family++; break;
                case "Friends": friends++; break;
                case "Work": work++; break;
                case "Other": other++; break;
            }
        }
        
        System.out.println("\n CONTACT STATISTICS");
        System.out.println("═════════════════════════════════");
        System.out.println("Total Contacts: " + contacts.size());
        System.out.println(" Family: " + family);
        System.out.println(" Friends: " + friends);
        System.out.println(" Work: " + work);
        System.out.println(" Other: " + other);
    }
    
    static void viewByCategory() {
        if (contacts.isEmpty()) {
            System.out.println("\n No contacts found!");
            return;
        }
        
        System.out.println("\nSelect Category:");
        System.out.println("1. Family");
        System.out.println("2. Friends");
        System.out.println("3. Work");
        System.out.println("4. Other");
        System.out.print("Choice: ");
        int catChoice = scanner.nextInt();
        scanner.nextLine();
        
        String category = "";
        switch (catChoice) {
            case 1: category = "Family"; break;
            case 2: category = "Friends"; break;
            case 3: category = "Work"; break;
            case 4: category = "Other"; break;
            default: 
                System.out.println(" Invalid category!");
                return;
        }
        
        boolean found = false;
        System.out.println("\n📋 " + category.toUpperCase() + " CONTACTS");
        System.out.println("═════════════════════════════════");
        
        for (Contact contact : contacts) {
            if (contact.category.equals(category)) {
                contact.displayContact();
                found = true;
            }
        }
        
        if (!found) {
            System.out.println(" No contacts in " + category + " category!");
        }
    }
}