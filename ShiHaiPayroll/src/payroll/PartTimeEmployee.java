package payroll;

public class PartTimeEmployee extends Employee
{
    private final int HOURS_PER_DAY = 7;
    private double numHoursAssigned;
    private double hourlyWage;
    private double sickDaysTaken;

    public PartTimeEmployee (String employeeNumber, String lastName, String firstName, String jobTitle, double numHoursAssigned, double hourlyWage, double sickDaysTaken)
    {
        super(employeeNumber, lastName, firstName, jobTitle);
        this.numHoursAssigned = numHoursAssigned;
        this.hourlyWage = hourlyWage;
        this.sickDaysTaken = sickDaysTaken;
    }

    public double getNumHoursAssigned()
    {
        return numHoursAssigned;
    }

    public double getHourlyWage()
    {
        return hourlyWage;
    }

    public double pay()
    {
        return hourlyWage * (numHoursAssigned - (sickDaysTaken * HOURS_PER_DAY));
    }

    public void useSickDay(double amount)
    {
        sickDaysTaken += amount;
    }

    public void resetSickDays()
    {
        sickDaysTaken = 0;
    }

    public double getSickDays()
    {
        return sickDaysTaken;
    }

    public void printPayStub()
    {
        System.out.println("\n--------------- PAY STUB ---------------");
        System.out.println(this);
        System.out.printf("Hourly Wage: $%.2f\n", hourlyWage);
        System.out.println("Number of hours assigned: " + numHoursAssigned);
        System.out.println("Sick days taken: " + sickDaysTaken);
        System.out.printf("Current Month pay: $%.2f\n", pay());
        System.out.println("----------------------------------------\n");
    }

    @Override
    public String toString()
    {
        return super.toString() + ", part-time";
    }
}
