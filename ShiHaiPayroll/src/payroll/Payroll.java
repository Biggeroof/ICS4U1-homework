package payroll;

import java.io.*;
import java.util.ArrayList;

public class Payroll
{
    private ArrayList<Employee> staffList;

    /**
     * Initializes the stafflist arraylist
     */
    public Payroll()
    {
        staffList = new ArrayList<>();
    }

    /**
     * Loads a stafflist from a file
     *
     * @param filename the name of the file to load from
     * @return Whether the loading was successful or not
     */
    public boolean loadStaffList(String filename)
    {
        String row;
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            //read the file row by row
            //1 row is 1 employee
            while ((row = reader.readLine()) != null) {
                //split the row into the variables needed by splitting on the commas
                String[] text = row.split(",");

                //if the employee type is full-time, add a full time employee to the staff list
                if(text[4].equals("full-time"))
                {
                    staffList.add(new FullTimeEmployee(text[0], text[1], text[2], text[3], Double.parseDouble(text[5]), Double.parseDouble(text[6])));
                }
                //if the employee is part-time, add a part-time employee to the staff list
                else
                {
                    staffList.add(new PartTimeEmployee(text[0], text[1], text[2], text[3], Double.parseDouble(text[5]), Double.parseDouble(text[6]), Double.parseDouble(text[7])));
                }
            }
            reader.close();
            return true;
        }
        catch (IOException e)
        {
            System.out.println("Problem reading file.");
            return false;
        }
    }

    /**
     * Saves a staff list into a file
     *
     * @param filename The name of the file to save into
     * @return Whether the saving was successful or not
     */
    public boolean saveStaffList(String filename)
    {
        String row;
        try
        {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
            for(int i = 0; i < staffList.size(); i++)
            {
                Employee temp = staffList.get(i);
                //if the current employee is full-time, write their information into the file in the format for a full-time employee
                if(temp instanceof FullTimeEmployee)
                {
                    writer.write(temp.employeeNumber + "," + temp.lastName + "," + temp.firstName + "," + temp.jobTitle);
                    writer.write(",full-time," + ((FullTimeEmployee)temp).getYearlySalary() + "," + temp.getSickDays() + "\n");
                }
                //if the current employee is part-time, write their information into the file in the format for a part-time employee
                else
                {
                    writer.write(temp.employeeNumber + "," + temp.lastName + "," + temp.firstName + "," + temp.jobTitle);
                    writer.write(",part-time," + ((PartTimeEmployee)temp).getNumHoursAssigned() + "," + ((PartTimeEmployee)temp).getHourlyWage() + "," + temp.getSickDays() + "\n");
                }
            }
            writer.close();
            return true;
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
            return false;
        }
    }

    /**
     * Prints all the employee info by using the class toStrings
     */
    public void listAllEmployees()
    {
        System.out.println("All Employees:");
        for (Employee i: staffList)
        {
            System.out.println(i);
        }
        System.out.println();
    }

    /**
     * Returns an employee given their id
     *
     * @param id The id of the employee to look for
     * @return The employee if they are found
     */
    public Employee getEmployee(String id)
    {
        for (Employee i: staffList)
        {
            if(i.getEmployeeNumber().equals(id))
            {
                return i;
            }
        }
        return null;
    }

    /**
     * Prints out a pay stub for an employee given their id
     *
     * @param id The id of the employee
     */
    public void printEmployeePayStub(String id)
    {
        Employee temp = getEmployee(id);

        if(temp != null)
        {
            temp.printPayStub();
        }
        else
        {
            System.out.println("Employee " + id + " not found!\n");
        }

    }

    /**
     * Prints the pay stubs for all employees
     */
    public void printAllPayStubs()
    {
        System.out.println("All Employee Pay Stubs:");
        for (Employee i: staffList)
        {
            i.printPayStub();
        }
    }

    /**
     * Uses a certain amount of sick days for an employee given the employee's id
     *
     * @param id The id of the employee to use sick days for
     * @param amount The amount of sick days to be used
     */
    public void enterSickDay(String id, double amount)
    {
        Employee temp = getEmployee(id);

        if(temp != null)
        {
            temp.useSickDay(amount);
            System.out.println("New sick days taken: " + temp.getSickDays() + "\n");
        }
        else
        {
            System.out.println("Employee " + id + " not found!\n");
        }
    }

    /**
     * Resets the sick days for all full-time employees to their yearly allotted amount (20)
     */
    public void yearlySickDayReset()
    {
        for (Employee i: staffList)
        {
            if(i instanceof FullTimeEmployee)
            {
                i.resetSickDays();
            }
        }
    }

    /**
     * Resets the sick days for all part-time employees to 0
     */
    public void monthlySickDayReset()
    {
        for (Employee i: staffList)
        {
            if(i instanceof PartTimeEmployee)
            {
                i.resetSickDays();
            }
        }
    }
}
