import java.util.Scanner;

public class questionOneOneOne 
{
    public static void main (String[] args)
    {
        Scanner input = new Scanner(System.in);


        System.out.print("Enter an integer: ");
        int n = Integer.parseInt(input.nextLine());

        int[] arr = new int[n];

        for(int i = 0; i < n; i++)
        {
            arr[i] = 1;
        }

        for(int i = 0; i < n; i++)
        {
            System.out.print("Enter an integer: ");
            int a = Integer.parseInt(input.nextLine());
            arr[i] = a;
        }

        int temp = arr[n - 1];
        arr[n - 1] = arr[0];
        arr[0] = temp;

        for(int i = 0; i < n; i++)
        {
            if(arr[i] < 0)
            {
                arr[i] *= -1;
            }
        }

        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < arr[i]; j++)
            {
                System.out.print("*");
            }
            System.out.println("");
        }

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
