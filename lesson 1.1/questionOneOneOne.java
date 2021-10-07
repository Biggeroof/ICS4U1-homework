import java.util.Scanner;

public class questionOneOneOne 
{
    public static void main (String[] args)
    {
        Scanner input = new Scanner(System.in);

        //a) ask user for size of array and make the array that size
        System.out.print("Enter an integer: ");
        int n = Integer.parseInt(input.nextLine());

        int[] arr = new int[n];
        //b) fill the array with 1
        for(int i = 0; i < n; i++)
        {
            arr[i] = 1;
        }
        //c) fill the array with user inputted integers
        for(int i = 0; i < n; i++)
        {
            System.out.print("Enter an integer: ");
            int a = Integer.parseInt(input.nextLine());
            arr[i] = a;
        }
        
        //d) swap values
        int temp = arr[n - 1];
        arr[n - 1] = arr[0];
        arr[0] = temp;

        //e) make all negative values positive
        for(int i = 0; i < n; i++)
        {
            if(arr[i] < 0)
            {
                arr[i] *= -1;
            }
        }

        //f) print stars for the numbers
        //iterate through the array
        for(int i = 0; i < n; i++)
        {
            //for each number, print n stars
            for(int j = 0; j < arr[i]; j++)
            {
                System.out.print("*");
            }
            System.out.println("");
        }

        //g) only print even numbers
        for(int i = 0; i < n; i++)
        {
            if(arr[i] % 2 == 0)
            {
                System.out.print(arr[i]);
                System.out.println("");
            }
        }
    }
}
