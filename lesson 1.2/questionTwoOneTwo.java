import java.util.Scanner;

public class questionTwoOneTwo 
{

    public static int arraySum(int row, int[][] arr)
    {
        //iterate down entire row and add
        int total = 0;
        for (int i = 0; i < arr[row - 1].length; i++)
        {
            total += arr[row - 1][i];
        }
        return total;
    }

    public static void printArray(int[][] arr)
    {
        //make length row length - 1 since array indexes start at 0
        int lenr = arr.length - 1;
        int lenc;
        //print out the inital bracket
        System.out.print("[ ");
        //iterate through the rows except for the last one
        for(int i = 0; i < lenr; i++)
        {
            //print bracket for the inside of the 2d array
            System.out.print("[");
            //set lenc to 1 less than the length of the array at that row (array indexes start at 0)
            lenc = arr[i].length - 1;
            //printing all the column indexes in that row
            for(int j = 0; j < lenc; j++)
            {
                //print out [row][column] followed by a comma
                System.out.print(arr[i][j] + ", ");
            }
            //print out the last element in that row
            System.out.print(arr[i][lenc]);
            System.out.println("],");
        }

        //set lenc to the length of the last row
        lenc = arr[lenr].length - 1;

        System.out.print("[");
        for(int j = 0; j < lenc; j++)
        {
            //print out last row excpet for the last element 
            System.out.print(arr[lenr][j] + ", ");
        }
        //print out the last column element in the row
        System.out.print(arr[lenr][lenc]);
        //print the ending brackets
        System.out.print("] ]");
        System.out.println();
    }

    public static void printAll(int[][] arr) 
    {
        for(int i = 0; i < arr.length; i++)
        {
            for(int j = 0; j < arr[i].length; j++)
            {
                System.out.println("row " + i + ", col " + j + " = " + arr[i][j]);
            }
        }
    }
    public static void main(String[] args) 
    {
        int[][] data = { {3, 2, 5},
			{1, 4, 4, 8, 13},
			{9, 1, 0, 2},
			{0, 2, 6, 4, -1, -8} };
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a row in the array: ");
        int row = Integer.parseInt(input.nextLine());
        System.out.println(arraySum(row, data));
        printArray(data);
        printAll(data);
    }
    
}
