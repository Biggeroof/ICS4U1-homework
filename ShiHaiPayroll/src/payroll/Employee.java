package payroll;

public abstract class Employee
{
    protected String employeeNumber;
    protected String lastName;
    protected String firstName;
    protected String jobTitle;

    /**
     * A constructor for the class that is for use in the subclasses
     *
     * @param employeeNumber The employee's id
     * @param lastName The employee's last name
     * @param firstName The employee's first name
     * @param jobTitle The employee's job
     */
    public Employee(String employeeNumber, String lastName, String firstName, String jobTitle)
    {
        this.employeeNumber = employeeNumber;
        this.lastName = lastName;
        this.firstName = firstName;
        this.jobTitle = jobTitle;
    }

    /**
     * Returns the id of the employee
     *
     * @return The id
     */
    public String getEmployeeNumber()
    {
        return employeeNumber;
    }

    /**
     * Returns the last name of the employee
     *
     * @return The last name
     */
    public String getLastName()
    {
        return lastName;
    }

    /**
     * Returns the first name of the employee
     *
     * @return The first name
     */
    public String getFirstName()
    {
        return firstName;
    }

    /**
     * Returns the job of the employee
     *
     * @return The job
     */
    public String getJobTitle()
    {
        return jobTitle;
    }

    /**
     * Returns string representation of the object
     *
     * @return The employee's details
     */
    @Override
    public String toString()
    {
        return "Employee: " + employeeNumber + ", " + firstName + " " + lastName + ", " + jobTitle;
    }


    abstract double pay();

    abstract void useSickDay(double amount);

    abstract double getSickDays();

    abstract void resetSickDays();

    abstract void printPayStub();
}
