public class BankAccount
{
    private String name;
    private double balance;
    private String accountNumber;
    private double interest;

    /**
     * Initializes a BankAccount object instance and fills in all the class fields with the input
     *
     * @param name Name of the holder of account
     * @param balance Initial balance of account
     * @param accountNumber The account number
     * @param interest The current interest rate of the account
     */
    public BankAccount(String name, double balance, String accountNumber, double interest)
    {
        this.name = name;
        this.balance = balance;
        this.accountNumber = accountNumber;
        this.interest = interest;
    }

    /**
     * Returns the name of the holder of account
     *
     * @return The name
     */
    public String getName()
    {
        return name;
    }

    /**
     * Returns the current balance of the account
     *
     * @return The balance
     */
    public double getBalance()
    {
        return balance;
    }

    /**
     * Returns the current interest rate on the acocunt
     *
     * @return The interest rate
     */
    public double getInterest()
    {
        return interest;
    }

    /**
     * Changes the name on the account to user inputted value
     *
     * @param name The name inputted by the user
     * @return none
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Changes the interest rate on the account to user inputted value
     *
     * @param interest The rate inputted by the user
     * @return none
     */
    public void setInterest(double interest)
    {
        this.interest = interest;
    }

    /**
     * Prints a message about the account's current balance
     *
     * @return none
     */
    public void checkBalance()
    {
        System.out.printf("Your balance is: %.2f \n\n", balance);
    }
    
    /**
     * Withdraws a certain amount of money from the account
     *
     * @param amount The amount to be withdrawn
     * @return none
     */
    public void withdraw(double amount)
    {
        balance -= amount;
    }

    /**
     * Deposits a certain amount of money from the account
     *
     * @param amount The amount to be deposited
     * @return none
     */
    public void deposit(double amount)
    {
        balance += amount;
    }

    /**
     * Transfers a certain amount of money from 1 account to another
     *
     * @param amount The amount to be transferred
     * @param other The account the money will be transferred to
     * @return none
     */
    public void transfer(double amount, BankAccount other)
    {
        this.balance -= amount;
        other.balance += amount;
    }

    /**
     * Calculates and adds the interest for a x amount of years compounded x times a year
     *
     * @param months The amount of months
     * @param period How many times the interest is compounded yearly
     * @return The amount of interest gained in the time period
     */
    public double calculateInterest(int months, int period)
    {
        //compound interest
        double balanceInterest = balance * Math.pow((1 + ((interest / 100) / period)), period * months / 12);
        double interestGain = balanceInterest - balance;
        deposit(balanceInterest - balance);
        return interestGain;
    }

    /**
     * Compares the balance and interest of 2 accounts and returns if they are equal or not
     *
     * @param other The account to be compared to
     * @return If the accounts are equal or not
     */
    public boolean equals(BankAccount other)
    {
        if((balance == other.balance) && (interest == other.interest))
        {
            return true;
        }
        return false;
    }

    @Override
    public String toString()
    {
        return String.format("Account holder name: %s \nAccount number: %s \nCurrent balance: %.2f \nCurrent interest rate: %.2f \n", name, accountNumber, balance, interest);
    }
}
