public class BankAccount {
    private double balance;

    public BankAccount() {
        this.balance = 0.0;
    }

    public BankAccount(double startingBalance) {
        if (startingBalance < 0) {
            throw new IllegalArgumentException("Starting balance cannot be negative");
        }
        this.balance = startingBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive");
        }
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdraw amount must be positive");
        }
        if (amount > balance) {
            throw new IllegalStateException("Insufficient funds");
        }
        balance -= amount;
    }
}