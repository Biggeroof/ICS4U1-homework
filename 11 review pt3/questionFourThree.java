import java.text.DecimalFormat;
import java.util.Scanner;

public class questionFourThree {
    public static double discriminant (double a, double b, double c)
    {
        return (Math.pow(b, 2) - (4 * a * c));
    }

    public static int numSolutions(double a, double b, double c)
    {
        if(discriminant(a, b, c) > 0)
        {
            return 2;
        }
        else if(discriminant(a, b, c) < 0)
        {
            return 0;
        }
        else
        {
            return 1;
        }
    }

    public static void solutions(double a, double b, double c)
    {
        DecimalFormat df = new DecimalFormat("#.##");
        if(numSolutions(a, b, c) == 2)
        {   
            System.out.print("Solutions: ");
            System.out.print(df.format((-b + Math.sqrt(Math.pow(b, 2) - (4 * a * c))) / (2*a)));
            System.out.print(", ");
            System.out.println(df.format((-b - Math.sqrt(Math.pow(b, 2) - (4 * a * c))) / (2*a)));
        }
        else if(numSolutions(a, b, c) == 1)
        {
            System.out.print("Solutions: ");
            System.out.println(df.format((-b + Math.sqrt(Math.pow(b, 2) - (4 * a * c))) / (2*a)));
        }
        else
        {
            System.out.println("There are no solutions to this equation.");
        }

    }

    public static boolean isFactorable (double a, double b, double c)
    {
        if((Math.sqrt(discriminant(a, b, c))) % 1 == 0)
        {
            return true;
        } 
        return false;
    }

    public static void main (String args[])
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the x^2 coefficient: ");
        double a = Double.parseDouble(input.nextLine());
        System.out.print("Enter the x coefficient: ");
        double b = Double.parseDouble(input.nextLine());
        System.out.print("Enter the : ");
        double c = Double.parseDouble(input.nextLine());
        System.out.println("Constant: " + discriminant(a, b, c));
        System.out.println("Number of solutions: " + numSolutions(a, b, c));
        solutions(a, b, c);
        if(isFactorable(a, b, c) == true)
        {
            System.out.println("This equation is factorable");
        }
        else{
            System.out.println("This equation is not factorable");
        }
        

        input.close();
    }
}
