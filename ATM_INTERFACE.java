package SANJAY;

import java.util.Scanner;
class ATM{
    private BankAccount userAccount;
    public ATM(BankAccount userAccount){
        this.userAccount=userAccount;
    }
    void DisplayMenu(){
        System.out.println("WELCOME TO THE ATM!");
        System.out.println("1.Withdraw");
        System.out.println("2.Deposit");
        System.out.println("3.Check Balance");
        System.out.println("4.Exit from the menu");
    }
    public void Choice(Scanner obj){
        int Choice = obj.nextInt();
        switch (Choice){
            case 1:
                withdraw(obj);
                break;
            case 2:
                deposit(obj);
                break;
            case 3:
                check_balance();
                break;
            case 4:
                System.out.println("THANK YOU FOR USING ATM ! VISIT AGAIN");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice.Please try again");
        }
    }
    private void withdraw(Scanner obj){
        System.out.println("Enter the amount to be withdrawn:");
        double amount = obj.nextDouble();
        if(amount>userAccount.getBalance())
            System.out.println("Insufficient Balance....!");
        else{
            userAccount.withdraw(amount);
            System.out.println("You have withdrawn "+amount+".Your remaining balance is "+userAccount.getBalance());
        }
    }
    private void deposit(Scanner obj){
        System.out.println("Enter the amount to deposit :");
        double amount = obj.nextDouble();
        userAccount.deposit(amount);
        System.out.println("You have withdrawn "+amount+".Your remaining balance is "+userAccount.getBalance());
    }
    private void check_balance(){
        System.out.println("Your balance is "+userAccount.getBalance());
    }
}
class BankAccount{
    private double balance;

    public BankAccount(double initialBalance){
        this.balance=initialBalance;
    }
    public double getBalance(){
        return balance;
    }
    public void withdraw(double amount){
        balance-=amount;
    }
    public void deposit(double amount){
        balance+=amount;
    }
}
public class ATM_INTERFACE {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankAccount userAccount = new BankAccount(1000);
        ATM atm = new ATM(userAccount);
        while (true){
            atm.DisplayMenu();
            atm.Choice(scanner);
        }
    }
}
