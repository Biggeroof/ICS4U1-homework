package payroll;

public class FullTimeEmployee extends Employee
{
    private final double YEARLY_SICK_DAYS = 20.0;
    private final int MONTHS = 12;
    private double yearlySalary;
    private double sickDaysLeft;

    public FullTimeEmployee (String employeeNumber, String lastName, String firstName, String jobTitle, double yearlySalary, double sickDaysLeft)
    {
        super(employeeNumber, lastName, firstName, jobTitle);
        this.yearlySalary = yearlySalary;
        this.sickDaysLeft = sickDaysLeft;
    }

    public double getYearlySalary() {
        return yearlySalary;
    }

    public double pay()
    {
        return yearlySalary / MONTHS;
    }

    public void useSickDay(double amount)
    {
        sickDaysLeft -= amount;
    }

    public double getSickDays()
    {
        return sickDaysLeft;
    }

    public void resetSickDays()
    {
        sickDaysLeft = YEARLY_SICK_DAYS;
    }

    public void printPayStub()
    {
        System.out.println("\n--------------- PAY STUB ---------------");
        System.out.println(this);
        System.out.printf("Yearly Salary: $%.2f\n", yearlySalary);
        System.out.printf("Current Month pay: $%.2f\n", pay());
        System.out.println("Sick days left: " + sickDaysLeft);
        System.out.println("----------------------------------------\n");
    }

    @Override
    public String toString()
    {
        return super.toString() + ", full-time";
    }
}
