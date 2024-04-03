import java.util.Scanner;
class ATM 
{
    private BankAccount bankAccount;

    public ATM(BankAccount bankAccount) 
    {
        this.bankAccount = bankAccount;
    }

    public void displayMenu() 
    {
        System.out.println("Welcome to the ATM!");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    public void withdraw(double amount) 
    {
        if (amount > 0 && amount <= bankAccount.getBalance()) 
        {
            bankAccount.setBalance(bankAccount.getBalance() - amount);
            System.out.println("Withdrawal successful. Remaining balance: " + bankAccount.getBalance());
        } 
        else if(amount <= 0)
        {
            System.out.println("Invalid withdrawal amount!");
        }
        else 
        {
            System.out.println("Insufficient balance!");
        }
    }

    public void deposit(double amount) 
    {
        if (amount > 0) 
        {
            bankAccount.setBalance(bankAccount.getBalance() + amount);
            System.out.println("Deposit successful. New balance: " + bankAccount.getBalance());
        } 
        else 
        {
            System.out.println("Invalid deposit amount!");
        }
    }

    public void checkBalance() 
    {
        System.out.println("Current balance: " + bankAccount.getBalance());
    }
}

class BankAccount 
{
    private double balance;

    public BankAccount(double balance) 
    {
        this.balance = balance;
    }

    public double getBalance() 
    {
        return balance;
    }

    public void setBalance(double balance) 
    {
        this.balance = balance;
    }
}

public class ATMApp
{
    public static void main(String[] args) 
    {
        BankAccount bankAccount = new BankAccount(1000.0);
        ATM atm = new ATM(bankAccount);
        Scanner scanner = new Scanner(System.in);

        int choice;
        do 
        {
            atm.displayMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) 
            {
                case 1:
                    System.out.print("Enter the amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    atm.withdraw(withdrawAmount);
                    break;
                case 2:
                    System.out.print("Enter the amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    atm.deposit(depositAmount);
                    break;
                case 3:
                    atm.checkBalance();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
                    break;
            }
            System.out.println("Do you want to continue? (1. Yes, 2. No)");
            choice = scanner.nextInt();
            if(choice == 2)
            {
                System.out.println("Goodbye!");
                break;
            }
        } while (choice != 4);
        scanner.close();
    }
}
