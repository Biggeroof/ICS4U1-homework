import java.util.Scanner;

public class questionThreeTwo {
    public static void main (String args[])
    {
        Scanner input = new Scanner(System.in);

        int year = Integer.parseInt(input.nextLine());
        boolean isLeap = false;;

        if(year % 4 == 0)
        {
            isLeap = true;
        }

        if(year % 100 == 0)
        {
            isLeap = false;
            if(year % 400 == 0)
            {
                isLeap = true;
            }
        }

        if(isLeap == true)
        {
            System.out.println("The year " + year + " is a leap year");
        }
        else
        {
            System.out.println("The year "+ year + " is not a leap year");
        }

        input.close();
    }
}
