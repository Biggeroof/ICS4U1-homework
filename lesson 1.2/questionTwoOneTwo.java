import java.util.Scanner;

public class questionTwoOneTwo 
{

    public static int arraySum(int row, int[][] arr)
    {
        int total = 0;
        for (int i = 0; i < arr[row - 1].length; i++)
        {
            total += arr[row - 1][i];
        }
        return total;
    }

    public static void printArray(int[][] arr)
    {
        int lenr = arr.length - 1;
        int lenc;
        System.out.print("[ ");
        for(int i = 0; i < lenr; i++)
        {
            System.out.print("[");
            lenc = arr[i].length - 1;
            for(int j = 0; j < lenc; j++)
            {
                System.out.print(arr[i][j] + ", ");
            }
            System.out.print(arr[i][lenc]);
            System.out.println("],");
        }

        lenc = arr[lenr].length - 1;

        System.out.print("[");
        for(int j = 0; j < lenc; j++)
            {
                System.out.print(arr[lenr][j] + ", ");
            }
        System.out.print(arr[lenr][lenc]);
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
