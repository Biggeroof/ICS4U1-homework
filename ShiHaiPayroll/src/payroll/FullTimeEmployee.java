package payroll;

public class FullTimeEmployee extends Employee
{
    private final double YEARLY_SICK_DAYS = 20.0;
    private final int MONTHS = 12;
    private double yearlySalary;
    private double sickDaysLeft;

    /**
     * Initializes a FullTimeEmployee object instance and fills in all the fields with the parameters
     *
     * @param employeeNumber The employee's id
     * @param lastName The employee's last name
     * @param firstName The employee's first name
     * @param jobTitle The employee's job
     * @param yearlySalary The amount the employee is paid every year
     * @param sickDaysLeft The amount of sick days the employee has left
     */
    public FullTimeEmployee (String employeeNumber, String lastName, String firstName, String jobTitle, double yearlySalary, double sickDaysLeft)
    {
        super(employeeNumber, lastName, firstName, jobTitle);
        this.yearlySalary = yearlySalary;
        this.sickDaysLeft = sickDaysLeft;
    }

    /**
     * Returns the amount the employee is paid every year
     *
     * @return The yearly salary of the employee
     */
    public double getYearlySalary() {
        return yearlySalary;
    }

    /**
     * Returns the amount the employee is paid every month
     *
     * @return The monthly salary of the employee
     */
    public double pay()
    {
        return yearlySalary / MONTHS;
    }

    /**
     * Uses a certain amount of sick days for the employee
     *
     * @param amount The amount of sick days to be used
     */
    public void useSickDay(double amount)
    {
        sickDaysLeft -= amount;
    }

    /**
     * Returns the amount of sick days the employee has left
     *
     * @return The amount of sick days left
     */
    public double getSickDays()
    {
        return sickDaysLeft;
    }

    /**
     * Resets the amount of sick days the employee has left to the amount allotted for a year (20)
     */
    public void resetSickDays()
    {
        sickDaysLeft = YEARLY_SICK_DAYS;
    }

    /**
     * Prints out a pay stub for the employee containing their employee information, salary, monthly pay, and sick days left
     */
    public void printPayStub()
    {
        System.out.println("\n--------------- PAY STUB ---------------");
        System.out.println(this);
        System.out.printf("Yearly Salary: $%.2f\n", yearlySalary);
        System.out.printf("Current Month pay: $%.2f\n", pay());
        System.out.println("Sick days left: " + sickDaysLeft);
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
        return super.toString() + ", full-time";
    }
}
