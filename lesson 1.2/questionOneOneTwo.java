import java.util.Scanner;
import java.util.Arrays;

public class questionOneOneTwo 
{
    public static void main(String args[]) 
    {
        Scanner input = new Scanner(System.in);
        //declare an empty 2d array
        int[][] arr;

        System.out.println("Enter the length of the array: ");
        int r = Integer.parseInt(input.nextLine());
        //sets the row length of the array to r
        arr = new int[r][];

        for(int i = 0; i < r; i++)
        {
            System.out.print("Enter the length of array " + (i + 1) + ": ");
            int c = Integer.parseInt(input.nextLine());
            //sets the column length of row i to c
            arr[i] = new int[c];
            System.out.println("Enter " + c + " integer(s): ");
            for(int j = 0; j < c; j++)
            {
                //gets the values
                arr[i][j] = Integer.parseInt(input.nextLine());
            }
        }
        //prints out the array
        System.out.println(Arrays.deepToString(arr));
    }
}
