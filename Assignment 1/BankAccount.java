/*
 * BankAccount.java
 * This class represents a bank account with an account number and balance.
 * It has methods to deposit and withdraw money from the account.
 * It also has a method to get the current balance.
 */
public class BankAccount {
    private String accountNumber;
    private double balance;

    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        balance -= amount;
        if (balance < 0) {
            balance = 0;
        }
    }

    public double getBalance() {
        return balance;
    }
}
