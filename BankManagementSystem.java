import java.util.Scanner;

public class BankManagementSystem {
    private static Bank bank;
    private static Scanner scanner;
    
    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        bank = new Bank("Simple Bank");
        
        System.out.println("Welcome to Simple Bank Management System!");
        System.out.println("========================================");
        
        boolean running = true;
        while (running) {
            displayMenu();
            int choice = getChoice();
            
            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    depositMoney();
                    break;
                case 3:
                    withdrawMoney();
                    break;
                case 4:
                    checkBalance();
                    break;
                case 5:
                    transferMoney();
                    break;
                case 6:
                    displayAllAccounts();
                    break;
                case 7:
                    displayAccountInfo();
                    break;
                case 8:
                    removeAccount();
                    break;
                case 9:
                    System.out.println("Thank you for using Simple Bank Management System!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
            
            if (running) {
                System.out.println("\nPress Enter to continue...");
                scanner.nextLine();
            }
        }
        
        scanner.close();
    }
    
    private static void displayMenu() {
        System.out.println("\n=== BANK MANAGEMENT SYSTEM ===");
        System.out.println("1. Create New Account");
        System.out.println("2. Deposit Money");
        System.out.println("3. Withdraw Money");
        System.out.println("4. Check Balance");
        System.out.println("5. Transfer Money");
        System.out.println("6. Display All Accounts");
        System.out.println("7. Display Account Information");
        System.out.println("8. Remove Account");
        System.out.println("9. Exit");
        System.out.print("Enter your choice (1-9): ");
    }
    
    private static int getChoice() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
    
    private static void createAccount() {
        System.out.println("\n=== CREATE NEW ACCOUNT ===");
        System.out.print("Enter Account Number: ");
        String accountNumber = scanner.nextLine();
        
        if (bank.accountExists(accountNumber)) {
            System.out.println("Account with this number already exists!");
            return;
        }
        
        System.out.print("Enter Account Holder Name: ");
        String accountHolderName = scanner.nextLine();
        
        System.out.print("Enter Account Type (Savings/Current): ");
        String accountType = scanner.nextLine();
        
        BankAccount newAccount = new BankAccount(accountNumber, accountHolderName, accountType);
        
        if (bank.addAccount(newAccount)) {
            System.out.println("Account created successfully!");
            newAccount.displayAccountInfo();
        } else {
            System.out.println("Failed to create account!");
        }
    }
    
    private static void depositMoney() {
        System.out.println("\n=== DEPOSIT MONEY ===");
        System.out.print("Enter Account Number: ");
        String accountNumber = scanner.nextLine();
        
        BankAccount account = bank.findAccount(accountNumber);
        if (account == null) {
            System.out.println("Account not found!");
            return;
        }
        
        System.out.print("Enter Amount to Deposit: $");
        try {
            double amount = Double.parseDouble(scanner.nextLine());
            if (account.deposit(amount)) {
                System.out.println("Deposit successful!");
                System.out.println("New Balance: $" + String.format("%.2f", account.getBalance()));
            } else {
                System.out.println("Invalid amount! Please enter a positive number.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input! Please enter a valid number.");
        }
    }
    
    private static void withdrawMoney() {
        System.out.println("\n=== WITHDRAW MONEY ===");
        System.out.print("Enter Account Number: ");
        String accountNumber = scanner.nextLine();
        
        BankAccount account = bank.findAccount(accountNumber);
        if (account == null) {
            System.out.println("Account not found!");
            return;
        }
        
        System.out.print("Enter Amount to Withdraw: $");
        try {
            double amount = Double.parseDouble(scanner.nextLine());
            if (account.withdraw(amount)) {
                System.out.println("Withdrawal successful!");
                System.out.println("New Balance: $" + String.format("%.2f", account.getBalance()));
            } else {
                System.out.println("Insufficient funds or invalid amount!");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input! Please enter a valid number.");
        }
    }
    
    private static void checkBalance() {
        System.out.println("\n=== CHECK BALANCE ===");
        System.out.print("Enter Account Number: ");
        String accountNumber = scanner.nextLine();
        
        BankAccount account = bank.findAccount(accountNumber);
        if (account == null) {
            System.out.println("Account not found!");
            return;
        }
        
        System.out.println("Current Balance: $" + String.format("%.2f", account.getBalance()));
    }
    
    private static void transferMoney() {
        System.out.println("\n=== TRANSFER MONEY ===");
        System.out.print("Enter Source Account Number: ");
        String sourceAccountNumber = scanner.nextLine();
        
        BankAccount sourceAccount = bank.findAccount(sourceAccountNumber);
        if (sourceAccount == null) {
            System.out.println("Source account not found!");
            return;
        }
        
        System.out.print("Enter Destination Account Number: ");
        String destAccountNumber = scanner.nextLine();
        
        BankAccount destAccount = bank.findAccount(destAccountNumber);
        if (destAccount == null) {
            System.out.println("Destination account not found!");
            return;
        }
        
        if (sourceAccountNumber.equals(destAccountNumber)) {
            System.out.println("Cannot transfer to the same account!");
            return;
        }
        
        System.out.print("Enter Amount to Transfer: $");
        try {
            double amount = Double.parseDouble(scanner.nextLine());
            if (sourceAccount.transfer(destAccount, amount)) {
                System.out.println("Transfer successful!");
                System.out.println("Source Account Balance: $" + String.format("%.2f", sourceAccount.getBalance()));
                System.out.println("Destination Account Balance: $" + String.format("%.2f", destAccount.getBalance()));
            } else {
                System.out.println("Transfer failed! Insufficient funds or invalid amount.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input! Please enter a valid number.");
        }
    }
    
    private static void displayAllAccounts() {
        System.out.println("\n=== ALL ACCOUNTS ===");
        bank.displayAllAccounts();
    }
    
    private static void displayAccountInfo() {
        System.out.println("\n=== ACCOUNT INFORMATION ===");
        System.out.print("Enter Account Number: ");
        String accountNumber = scanner.nextLine();
        
        BankAccount account = bank.findAccount(accountNumber);
        if (account == null) {
            System.out.println("Account not found!");
            return;
        }
        
        account.displayAccountInfo();
    }
    
    private static void removeAccount() {
        System.out.println("\n=== REMOVE ACCOUNT ===");
        System.out.print("Enter Account Number: ");
        String accountNumber = scanner.nextLine();
        
        BankAccount account = bank.findAccount(accountNumber);
        if (account == null) {
            System.out.println("Account not found!");
            return;
        }
        
        System.out.println("Account to be removed:");
        account.displayAccountInfo();
        System.out.print("Are you sure you want to remove this account? (yes/no): ");
        String confirmation = scanner.nextLine().toLowerCase();
        
        if (confirmation.equals("yes") || confirmation.equals("y")) {
            if (bank.removeAccount(accountNumber)) {
                System.out.println("Account removed successfully!");
            } else {
                System.out.println("Failed to remove account!");
            }
        } else {
            System.out.println("Account removal cancelled.");
        }
    }
}
