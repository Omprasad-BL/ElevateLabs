import java.util.ArrayList;
import java.util.List;

 class Account {
    private String accountHolder;
    private double balance;
    private List<String> transactionHistory;

    // Constructor
    public Account(String accountHolder, double initialBalance) {
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
        transactionHistory.add("Account created with balance: " + initialBalance);
    }

    // Deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactionHistory.add("Deposited: " + amount);
            System.out.println("Deposited " + amount);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    // Withdraw method
    public void withdraw(double amount) {
        if (amount > 0) {
            if (amount <= balance) {
                balance -= amount;
                transactionHistory.add("Withdrew: " + amount);
                System.out.println("Withdrew " + amount);
            } else {
                System.out.println("Insufficient funds.");
            }
        } else {
            System.out.println("Withdrawal amount must be positive.");
        }
    }

    // Get current balance
    public double getBalance() {
        return balance;
    }

    // Print transaction history
    public void printTransactionHistory() {
        System.out.println("Transaction History for " + accountHolder + ":");
        for (String entry : transactionHistory) {
            System.out.println(entry);
        }
    }
}


public class Main {
    public static void main(String[] args) {
        // Create account with initial balance
        Account account = new Account("Alice", 500.0);

        // Perform operations
        account.deposit(200.0);
        account.withdraw(100.0);
        account.withdraw(700.0); // Should show insufficient funds

        // Show balance
        System.out.println("Current Balance: " + account.getBalance());

        // Show transaction history
        account.printTransactionHistory();
    }
}
