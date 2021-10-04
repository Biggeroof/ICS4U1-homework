import java.text.DecimalFormat;

public class questionOneThree {
    public static void main (String args[])
    {
        int rows = 5;
        printTriangle(rows);
        DecimalFormat df = new DecimalFormat("#.##");

        System.out.println("double of 16: " + numDouble(16));
        System.out.println("Avg of 12.0 33.2 and 25.3: " + doubleAvg(12.0, 33.2, 25.3));
        System.out.println("Circumference of a cirle with radius 5: " + df.format(circumference(5)));
    }    
    
    public static int numDouble (int num)
    {
        return num * 2;
    }

    public static double doubleAvg (double one, double two, double three)
    {
        return ((one + two + three) / 3.0);
    }

    public static void printTriangle (int rows)
    {
        for(int i = 1; i <= rows; i++)
        {
            for( int j = 0; j < i; j++)
            {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static double circumference (double radius)
    {
        return 2 * radius * Math.PI;
    }
}