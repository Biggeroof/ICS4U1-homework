import java.util.Scanner;

public class questionOneFour {
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
        if(numSolutions(a, b, c) == 2)
        {   
            System.out.print("Solutions: ");
            System.out.print( (-b + Math.sqrt(Math.pow(b, 2) - (4 * a * c))) / (2*a));
            System.out.print(" ,");
            System.out.println( (-b - Math.sqrt(Math.pow(b, 2) - (4 * a * c))) / (2*a));
        }
        else if(numSolutions(a, b, c) == 1)
        {
            System.out.print("Solutions: ");
            System.out.println( (-b + Math.sqrt(Math.pow(b, 2) - (4 * a * c))) / (2*a));
        }
        else
        {
            System.out.println("There are no solutions to this equation.");
        }

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
        System.out.print("Constant: " + discriminant(a, b, c));
        System.out.println("Number of solutions: " + numSolutions(a, b, c));
        solutions(a, b, c);
    }
}
