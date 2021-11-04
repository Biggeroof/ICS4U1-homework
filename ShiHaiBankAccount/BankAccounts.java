//import java.text.DecimalFormat;
import java.util.Scanner;

public class BankAccounts {

    public static void main(String[] args) {
        //the interest is in percent, not decimal form
        Scanner input = new Scanner(System.in);

        //creates three BankAccount object instances
        BankAccount accountOne = new BankAccount("Dave", 10506.14, "000001", 2.34);
        BankAccount accountTwo = new BankAccount("Sammy", 10120.57, "000002", 2.57);
        BankAccount accountThree = new BankAccount("Hai", 10120.57, "000003", 2.57);

        //array of references to accounts
        BankAccount[] array = new BankAccount[3];
        array[0] = accountOne;
        array[1] = accountTwo;
        array[2] = accountThree;

        int access = 0;
        int option;
        double amount;
        String name;
        boolean done = false;
        String choice;
        int account;
        int months;
        int period;
        double interestTotal;

        //prints out all of the account details
        System.out.println("Account number 1: ");
        System.out.println(accountOne);

        System.out.println("Account number 2: ");
        System.out.println(accountTwo);

        System.out.println("Account number 3: ");
        System.out.println(accountThree);

        //calls .equals from the BankAccount class to check if the 2 accounts have the same balance and interest
        System.out.println("Do account one and two have the same balance and interest rate?: " + accountOne.equals(accountTwo));
        System.out.println("Do account two and three have the same balance and interest rate?: " + accountTwo.equals(accountThree));

        System.out.println("The current interest rate on account 1 is " + accountOne.getInterest() + ". This will be changed to 2.72%");
        accountOne.setInterest(2.72);
        System.out.println("The interest rate on account 1 is now " + accountOne.getInterest() + "\n");

        //while loop to keep repeating the account access question until its entered correctly
        while(!done)
        {
            System.out.print("Choose which account you would like to access: ");
            //gets the account the user wants to access
            access = Integer.parseInt(input.nextLine());
            //if the account doesent exist, prompt the user to try again
            if(!(access == 1 || access == 2 || access == 3))
            {
                System.out.println("Invalid account number, please enter again. \n");
            }
            else
            {
                done = true;
            }
        }

        System.out.println("Now accessing account " + access + "\n");

        //loops the user interface until user chooses to exit
        while(true)
        {
            System.out.println("Please enter what you would like to do: ");
            System.out.println("1. Check current account details");
            System.out.println("2. Change name on account");
            System.out.println("2. Check current balance");
            System.out.println("4. Withdraw money");
            System.out.println("5. Deposit money");
            System.out.println("6. Transfer money to another account");
            System.out.println("7. Calculate balance after compounded interest for a certain period of time");
            System.out.println("8. Change accounts");
            System.out.println("9. Exit");

            option = Integer.parseInt(input.nextLine());

            //if statements for all of the options
            if(option == 1)
            {
                //print out the account details
                System.out.println(array[access - 1]);
            }

            else if(option == 2)
            {  
                //confirm that the user wants to change the name 
                System.out.println("The current name on account is " + array[access - 1].getName() + ". Are you sure you want to change this?");
                choice = input.nextLine();
                while(true)
                {
                    if((choice.equals("y") || choice.equals("yes") || choice.equals("Yes") || choice == "Y") || (choice.equals("n") || choice.equals("no") || choice.equals("No") || choice.equals("N")))
                    {
                        break;
                    }
                    else
                    {
                        System.out.println("Invalid choice. Please enter again.");
                        choice = input.nextLine();
                    }

                }

                if(choice.equals("y") || choice.equals("yes") || choice.equals("Yes") || choice == "Y")
                {
                    //get input from user for the new name
                    System.out.println("Please enter the new name you want on the account: ");
                    name = input.nextLine();
                    //change the name to the inputted name
                    array[access - 1].setName(name);
                    System.out.println("The name on account has been changed to " + name + ". \n");
                }

            }

            else if(option == 3)
            {
                //print out a message with the account balance
                array[access - 1].checkBalance();
            }

            else if(option == 4)
            {
                //ask the user for a amount of money to be withdrawn
                System.out.print("Please enter the amount to be withdrawn: ");
                amount = Double.parseDouble(input.nextLine());
                //withdraw the money from the account
                array[access - 1].withdraw(amount);
                System.out.printf("%.2f dollars has been withdrawn. The new balance is %.2f dollars. \n\n", amount, array[access - 1].getBalance());
            }

            else if(option == 5)
            {
                //ask the user for a amount of money to be deposited
                System.out.print("Please enter the amount to be deposited: ");
                amount = Double.parseDouble(input.nextLine());
                //deposit the money into the account
                array[access - 1].deposit(amount);
                System.out.printf("%.2f dollars has been deposited. The new balance is %.2f dollars. \n\n", amount, array[access - 1].getBalance());
            }

            else if(option == 6)
            {
                //ask the user for the account they would like to transfer the money to
                System.out.print("Please enter the account you would like to transfer to: ");
                account = Integer.parseInt(input.nextLine());
                while(account == access || account > 3 || account < 1)
                {
                    System.out.println("Invalid account, Please try again.");
                    System.out.print("Please enter the account you would like to transfer to: ");
                    account = Integer.parseInt(input.nextLine());
                }

                //ask user for amount they want to send
                System.out.print("Please enter the amount you would like to transfer: ");
                amount = Double.parseDouble(input.nextLine());
                //transfer the money to the other account
                array[access - 1].transfer(amount, array[account - 1]);
                System.out.printf("%.2f dollars has been transfered to account %d. The new balance on your account is %.2f dollars. \n\n", amount, account, array[access - 1].getBalance());
            }

            else if(option == 7)
            {
                //ask the user for the amount of time they want to calculate the interest for
                System.out.print("Please enter the amount of time you want to use (in months): ");
                months = Integer.parseInt(input.nextLine());
                //ask user for the amount of times they want the interest to be compounded 
                System.out.print("Please enter the compound interval (amount of times compounded per year): ");
                period = Integer.parseInt(input.nextLine());
                //calcuate the interest, print a statement returning the amount of interest made, and deposit that value into the account
                interestTotal = array[access - 1].calculateInterest(months, period);
                System.out.printf("The amount of interest you have made in the time of %d months compounded %d times per year is %.2f dollars. This will now be deposited.\n\n", months, period, interestTotal);
                array[access - 1].checkBalance();
            }

            else if(option == 8)
            {
                //ask user for which account they would like to access
                done = false;
                while(!done)
                {
                    System.out.print("Choose which account you would like to access: ");
                    access = Integer.parseInt(input.nextLine());
                    if(!(access == 1 || access == 2 || access == 3))
                    {
                        System.out.println("Invalid account number, please enter again.");
                    }
                    else
                    {
                        done = true;
                    }
                }
                System.out.println();
            }

            else if(option == 9)
            {
                //exit the program
                System.out.println("Thank you for using the bank account program!\n");
                break;
            }

            else
            {
                System.out.println("Invalid option, please enter again.");
            }
        }


    //test without any user input
    //    DecimalFormat df = new DecimalFormat("0.00");
    //    BankAccount test = new BankAccount("Dave", 10506.14, "000001", 2.34);
    //    BankAccount test2 = new BankAccount("Sammy", 10120.57, "000002", 2.57);

    //    System.out.println(test);
    //    System.out.println(test2);
    //    System.out.println("Are the account balances and interest rate equal?; " + test.equals(test2));
    //    System.out.println("Current name on account 1: " + test.getName());
    //    System.out.println("Current balance on account 1: " + test.getBalance());
    //    System.out.println("Current interest on account 1: " + test.getInterest());
    //    System.out.println("Setting name on account 1 to Lucas");
    //    test.setName("Lucas");
    //    System.out.println("Current name on account 1: " + test.getName());
    //    System.out.println("Setting interest on account 1 to 5%");
    //    test.setInterest(5);
    //    test.checkBalance();
    //    System.out.println("Withdrawing 10.07 from account 1");
    //    test.withdraw(10.07);
    //    System.out.println("Current balance on account 1: " + df.format(test.getBalance()));
    //    System.out.println("Depositing 10.07 into account 1");
    //    test.deposit(10.07);
    //    System.out.println("Current balance on account 1: " + df.format(test.getBalance()));
    //    System.out.println("Transferring 10.07 from account 1 to account 2");
    //    test.transfer(10.07, test2);
    //    System.out.println("Current balance on account 1: " + df.format(test.getBalance()));
    //    System.out.println("Current balance on account 2: " + df.format(test2.getBalance()));
    //    System.out.println("Total money gained from interest on account 1 in 1 year compounded once a year: " + df.format(test.calculateInterest(12, 1)));
    }
}
