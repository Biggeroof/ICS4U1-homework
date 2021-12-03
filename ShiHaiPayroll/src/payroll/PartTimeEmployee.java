package payroll;

public class PartTimeEmployee extends Employee
{
    private final int HOURS_PER_DAY = 7;
    private double numHoursAssigned;
    private double hourlyWage;
    private double sickDaysTaken;

    /**
     * Initializes a PartTimeEmployee object instance and fills in all the fields with the parameters
     *
     * @param employeeNumber The employee's id
     * @param lastName The employee's last name
     * @param firstName The employee's first name
     * @param jobTitle The employee's job
     * @param numHoursAssigned
     * @param hourlyWage
     * @param sickDaysTaken
     */
    public PartTimeEmployee (String employeeNumber, String lastName, String firstName, String jobTitle, double numHoursAssigned, double hourlyWage, double sickDaysTaken)
    {
        super(employeeNumber, lastName, firstName, jobTitle);
        this.numHoursAssigned = numHoursAssigned;
        this.hourlyWage = hourlyWage;
        this.sickDaysTaken = sickDaysTaken;
    }

    /**
     * Returns the amount of hours the employee works per month
     *
     * @return The number of hours the employee is assigned
     */
    public double getNumHoursAssigned()
    {
        return numHoursAssigned;
    }

    /**
     * Returns the hourly wage of the employee
     *
     * @return THe hourly wage
     */
    public double getHourlyWage()
    {
        return hourlyWage;
    }

    /**
     * Calculates the amount of money that the employee will make for the current month
     *
     * @return The amount of money made in that month
     */
    public double pay()
    {
        return hourlyWage * (numHoursAssigned - (sickDaysTaken * HOURS_PER_DAY));
    }

    /**
     * Uses a certain amount of sick days for the employee
     *
     * @param amount The amount of sick days to be used
     */
    public void useSickDay(double amount)
    {
        sickDaysTaken += amount;
    }

    /**
     * Resets the amount of sick days used by the employee to 0
     */
    public void resetSickDays()
    {
        sickDaysTaken = 0;
    }

    /**
     * Returns the amount of sick days the employee has used
     *
     * @return The amount of sick days used
     */
    public double getSickDays()
    {
        return sickDaysTaken;
    }

    /**
     * Prints out a pay stub for the employee containing their employee information, hourly wage, number of hours assigned, sick days taken,
     * and the current pay for the month
     */
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

    /**
     * Returns string representation of the object
     *
     * @return The employee's details
     */
    @Override
    public String toString()
    {
        return super.toString() + ", part-time";
    }
}
