// Main.java
public class Main {
    public static void main(String[] args) {
        BankAccount acct = new BankAccount(100);

        acct.deposit(50);
        System.out.println(acct.getBalance()); // 150.0

        acct.withdraw(20);
        System.out.println(acct.getBalance()); // 130.0
    }
}