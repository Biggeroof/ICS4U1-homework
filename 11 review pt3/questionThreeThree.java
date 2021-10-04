import java.util.Scanner;

public class questionThreeThree {
    
    public static double calcSlope (double x1, double y1, double x2, double y2)
    {        
        if(x2 - x1 == 0)
        {
            return Double.POSITIVE_INFINITY;
        }

        if(y2 - y1 == 0)
        {
            return 0;
        }

        double slope = (y2 - y1) / (x2 - x1);

        return slope;
    }

    public static double calcLength (double x1, double y1, double x2, double y2)
    {
        return Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
    }
    public static void main (String args[])
    {
        Scanner input = new Scanner(System.in);
        double x1, y1, x2, y2, x3, y3, x4, y4;

        System.out.println("Please enter the coordinates of two points on line segment 1: ");
        System.out.println("Point A x-value: ");
        x1 = Integer.parseInt(input.nextLine());

        System.out.println("Point A y-value: ");
        y1 = Integer.parseInt(input.nextLine());

        System.out.println("Point B x-value: ");
        x2 = Integer.parseInt(input.nextLine());

        System.out.println("Point B y-value: ");
        y2 = Integer.parseInt(input.nextLine());

        System.out.println("Please enter the coordinates of two points on line segment 2: ");
        System.out.println("Point C x-value: ");
        x3 = Integer.parseInt(input.nextLine());

        System.out.println("Point C y-value: ");
        y3 = Integer.parseInt(input.nextLine());

        System.out.println("Point D x-value: ");
        x4 = Integer.parseInt(input.nextLine());
        
        System.out.println("Point D y-value: ");
        y4 = Integer.parseInt(input.nextLine());

        double lineOneSlope = calcSlope(x1, y1, x2, y2);
        double lineOneLength = calcLength(x1, y1, x2, y2);

        double lineTwoSlope = calcSlope(x3, y3, x4, y4);
        double lineTwoLength = calcLength(x3, y3, x4, y4);

        System.out.println("Results: ");
        if(lineOneLength == lineTwoLength)
        {
            System.out.println("The two line segments have the same length");
        }
        else
        {
            System.out.println("The two line segments do not have the same length");
        }

        if(lineOneSlope == lineTwoSlope)
        {
            System.out.println("The two line segments are parallel");
        }
        else if(lineOneLength == -(1/lineTwoSlope))
        {
            System.out.println("The two line segments are perpendicular");
        }
        else
        {
            System.out.println("The two line segments are neither perpendicular or parallel");
        }

        input.close();
    }
}
