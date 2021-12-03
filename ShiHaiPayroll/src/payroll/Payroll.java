package payroll;

import java.io.*;
import java.util.ArrayList;

public class Payroll
{
    private ArrayList<Employee> staffList;

    public Payroll()
    {
        staffList = new ArrayList<>();
    }

    public boolean loadStaffList(String filename)
    {
        String row;
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            while ((row = reader.readLine()) != null) {
                String[] text = row.split(",");

                if(text[4].equals("full-time"))
                {
                    staffList.add(new FullTimeEmployee(text[0], text[1], text[2], text[3], Double.parseDouble(text[5]), Double.parseDouble(text[6])));
                }
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

    public boolean saveStaffList(String filename)
    {
        String row;
        try
        {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
            for(int i = 0; i < staffList.size(); i++)
            {
                Employee temp = staffList.get(i);
                if((staffList.get(i)) instanceof FullTimeEmployee)
                {
                    //2 write statements here as just having 1 was too long
                    writer.write(temp.employeeNumber + "," + temp.lastName + "," + temp.firstName + "," + temp.jobTitle);
                    writer.write(",full-time," + ((FullTimeEmployee)temp).getYearlySalary() + "," + temp.getSickDays() + "\n");
                }
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

    public void listAllEmployees()
    {
        System.out.println("All Employees:");
        for (Employee i: staffList)
        {
            System.out.println(i);
        }
        System.out.println();
    }

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

    public void printAllPayStubs()
    {
        System.out.println("All Employee Pay Stubs:");
        for (Employee i: staffList)
        {
            i.printPayStub();
        }
    }

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
