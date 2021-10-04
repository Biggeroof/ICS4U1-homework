import java.text.DecimalFormat;
import java.text.Format;
import java.util.Scanner;

public class questionThreeOneOne 
{

    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);


        System.out.print("Enter an integer: ");
        int n = Integer.parseInt(input.nextLine());
        double total = 0;
        double smallest = 99999999;
        int indexSmallest = 0;
        DecimalFormat df = new DecimalFormat("#");

        double[] arr = new double[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter a double: ");
            double a = Double.parseDouble(input.nextLine());
            arr[i] = a;
        }

        for(int i = 0; i < n; i++)
        {
            total += arr[i];
        }

        System.out.println("Sum: " + total);
        System.out.println("Average: " + (total / n));

        for(int i = 0; i < n - 1; i++)
        {
            System.out.print(df.format(arr[i]) + ", ");
        }
        System.out.println(df.format(arr[n - 1]));

        for(int i = 0; i < n; i++)
        {
            if(arr[i] < smallest)
            {
                smallest = arr[i];
                indexSmallest = i;
                
            }

        }
            System.out.println("smallest number: " + smallest);
            System.out.println("index of smallest number: " + indexSmallest);
    }
}
