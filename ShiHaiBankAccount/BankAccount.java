public class BankAccount
{
    private String name;
    private double balance;
    private String accountNumber;
    private double interest;

    /**
     * 
     * @param name
     * @param balance
     * @param accountNumber
     * @param interest
     */
    public BankAccount(String name, double balance, String accountNumber, double interest)
    {
        this.name = name;
        this.balance = balance;
        this.accountNumber = accountNumber;
        this.interest = interest;
    }

    public String getName()
    {
        return name;
    }

    public double getBalance()
    {
        return balance;
    }

    public double getInterest()
    {
        return interest;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setInterest(double interest)
    {
        this.interest = interest;
    }

    public void checkBalance()
    {
        System.out.printf("Your balance is: %.2f \n\n", balance);
    }

    public void withdraw(double amount)
    {
        balance -= amount;
    }

    public void deposit(double amount)
    {
        balance += amount;
    }

    public void transfer(double amount, BankAccount other)
    {
        this.balance -= amount;
        other.balance += amount;
    }

    public double calculateInterest(int months, int period)
    {
        //compound interest
        double balanceInterest = balance * Math.pow((1 + ((interest / 100) / period)), period * months / 12);
        double interestGain = balanceInterest - balance;
        deposit(balanceInterest - balance);
        return interestGain;

        //add that interest to the account

    }

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
