
import java.util.Scanner;

public class ATM {
    private int balance;
    private int pin;
    private String accountHolderName;
    private String accountNumber;

    public ATM(int balance, int pin, String accountHolderName, String accountNumber) {
        this.balance = balance;
        this.pin = pin;
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
    }

    public void start() {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Welcome to ATM !!");
            System.out.print("Enter your Pin: ");
            int currPin = sc.nextInt();
            if (currPin == pin) {
                System.out.println("Successfully Logged In :)");
                while (true) {
                    System.out.println("\n1. Check Balance");
                    System.out.println("2. Withdraw");
                    System.out.println("3. Deposit");
                    System.out.println("4. Change PIN");
                    System.out.println("5. Check Account Details");
                    System.out.println("6. Transfer Money");
                    System.out.println("7. Pay Bills");
                    System.out.println("8. Exit");
                    System.out.print("Choose an option: ");
                    int op = sc.nextInt();
                    switch (op) {
                        case 1:
                            System.out.println("Your Balance is: " + balance);
                            break;
                        case 2:
                            System.out.print("Enter Amount to Withdraw: ");
                            int withdrawAmount = sc.nextInt();
                            if (withdrawAmount <= balance) {
                                balance -= withdrawAmount;
                                System.out.println("Withdrawal Successful :)");
                            } else {
                                System.out.println("Insufficient Balance :(");
                            }
                            break;
                        case 3:
                            System.out.print("Enter Amount to Deposit: ");
                            int depositAmount = sc.nextInt();
                            balance += depositAmount;
                            System.out.println("Deposit Successful :)");
                            break;
                        case 4:
                            System.out.print("Enter new PIN: ");
                            pin = sc.nextInt();
                            System.out.println("PIN changed successfully :)");
                            break;
                        case 5:
                            System.out.println("Account Holder Name: " + accountHolderName);
                            System.out.println("Account Number: " + accountNumber);
                            break;
                        case 6:
                            System.out.print("Enter Account Number to transfer: ");
                            String transferAccountNumber = sc.next();
                            System.out.print("Enter Amount to transfer: ");
                            int transferAmount = sc.nextInt();
                            if (transferAmount <= balance) {
                                balance -= transferAmount;
                                System.out.println("Transfer Successful :)");
                            } else {
                                System.out.println("Insufficient Balance :(");
                            }
                            break;
                        case 7:
                            System.out.print("Enter Bill's Name: ");
                            String billType = sc.next();
                            System.out.print("Enter Amount to Pay: ");
                            int billAmount = sc.nextInt();
                            if (billAmount <= balance) {
                                balance -= billAmount;
                                System.out.println("Payment Successful :)");
                            } else {
                                System.out.println("Insufficient Balance :(");
                            }
                            break;
                        case 8:
                            System.out.println("Exiting...");
                            return;
                        default:
                            System.out.println("Invalid option, please try again.");
                            break;
                    }
                }
            } else {
                System.out.println("Invalid Pin :(");
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    public static void main(String args[]) {
        ATM atm = new ATM(1000, 1234, "Srikanth", "123456789");//Initial Balance,PIN,Account Holder Name and Account Number
        atm.start();
    }
}
