package payroll;

public abstract class Employee
{
    protected String employeeNumber;
    protected String lastName;
    protected String firstName;
    protected String jobTitle;

    public Employee(String employeeNumber, String lastName, String firstName, String jobTitle)
    {
        this.employeeNumber = employeeNumber;
        this.lastName = lastName;
        this.firstName = firstName;
        this.jobTitle = jobTitle;
    }

    public String getEmployeeNumber()
    {
        return employeeNumber;
    }

    public String getLastName()
    {
        return lastName;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public String getJobTitle()
    {
        return jobTitle;
    }

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
