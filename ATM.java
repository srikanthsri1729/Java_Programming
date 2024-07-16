
import java.util.Scanner;

public class ATM {
    private double balance;
    private int pin;

    public ATM(double balance, int pin) {
        this.balance = balance;
        this.pin = pin;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposit successful. New balance: " + balance);
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawal successful. New balance: " + balance);
        } else {
            System.out.println("Insufficient funds");
        }
    }

    public void checkBalance() {
        System.out.println("Current balance: " + balance);
    }

    public boolean authenticate(int enteredPin) {
        return enteredPin == pin;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ATM atm = new ATM(1000.0, 1234); // initial balance and PIN

        while(true)
        {
        System.out.println("Enter your PIN:");
        int enteredPin = scanner.nextInt();

        if (atm.authenticate(enteredPin)) {
            System.out.println("PIN authenticated. Choose an option:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter deposit amount:");
                    double depositAmount = scanner.nextDouble();
                    atm.deposit(depositAmount);
                    break;
                case 2:
                    System.out.println("Enter withdrawal amount:");
                    double withdrawalAmount = scanner.nextDouble();
                    atm.withdraw(withdrawalAmount);
                    break;
                case 3:
                    atm.checkBalance();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        } else {
            System.out.println("Invalid PIN. Try again.");
        }
    }
}
}


