import java.util.Scanner;

// BankAccount class to represent the user's bank account
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: Rs." + amount);
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: Rs." + amount);
            return true;
        } else {
            System.out.println("Insufficient funds");
            return false;
        }
    }
}

// ATM class with user interface and methods
class ATM {
    private BankAccount account;
    private Scanner scanner;

    public ATM(double initialBalance) {
        account = new BankAccount(initialBalance);
        scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("ATM Menu:");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }

    public void run() {
        int choice;
        do {
            displayMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    System.out.println("Exiting ATM. Have a nice day!");
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        } while (choice != 4);
    }

    public void checkBalance() {
        System.out.println("Current Balance: Rs." + account.getBalance());
    }

    public void deposit() {
        System.out.print("Enter the amount to deposit: Rs.");
        double amount = scanner.nextDouble();
        if (amount > 0) {
            account.deposit(amount);
        } else {
            System.out.println("Invalid amount. Please enter a positive value.");
        }
    }

    public void withdraw() {
        System.out.print("Enter the amount to withdraw: Rs.");
        double amount = scanner.nextDouble();
        if (amount > 0) {
            boolean success = account.withdraw(amount);
            if (!success) {
                System.out.println("Withdrawal unsuccessful. Insufficient funds.");
            }
        } else {
            System.out.println("Invalid amount. Please enter a positive value.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        double initialBalance = 1000.0; // Initial balance for the bank account
        ATM atm = new ATM(initialBalance);
        atm.run();
    }
}
