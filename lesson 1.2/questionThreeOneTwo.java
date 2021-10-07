public class questionThreeOneTwo 
{
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

    public static void swapRow(int arr[][], int row1, int row2) 
    {
        for(int i = 0; i < arr[0].length; i++)
        {
            //iterate down the columns and swap row elements
            int temp = arr[row1][i];
            arr[row1][i] = arr[row2][i];
            arr[row2][i] = temp;
        }
    }

    public static void swapColumn(int arr[][], int col1, int col2) 
    {
        //col1 = 0 col2 = 1
        for(int i = 0; i < arr.length; i++)
        {
            //iterate down rows and swap column elements
            int temp = arr[i][col1];
            arr[i][col1] = arr[i][col2];
            arr[i][col2] = temp;
        }
    }

    public static void multiplyRow(int[][] arr, int row, int num) 
    {
        //iterate down row and multiply by num
        for(int i = 0; i < arr[0].length; i++)
        {
            arr[row][i] *= num;
        }
    }

    public static int[][] rotate(int[][] arr) 
    {
        //length variables for the rotated array (swapped with the original array)
        int lenr = arr[0].length;
        int lenc = arr.length;
        int[][] rotated = new int[lenr][lenc];

        //row for new array
        for(int i = 0; i < lenr; i++)
        {
            //column for new array
            for(int j = 0; j < lenc; j++)
            {
                //swap the rows and columns (start from back of the row of original array)
                rotated[i][lenc - (j + 1)] = arr[j][i];
            }
        }
        return rotated;
    }
    public static void main(String[] args) 
    {
        int[][] arr = { {3, 2, 5, 23, 1},
        {1, 4, 4, 8, 13},
        {9, 1, 0, 2, 7},
        {0, 2, 6, 4, -1} };

        System.out.println("Orginal array: ");
        printArray(arr);

        System.out.println();

        // System.out.println("Swapping rows 1 and 2:");
        // swapRow(arr, 0, 1);
        // printArray(arr);

        // System.out.println();

        // System.out.println("Swapping columns 1 and 2:");
        // swapColumn(arr, 0, 1);
        // printArray(arr);

        // System.out.println();

        // System.out.println("Multiplying row 2 by 2:");
        // multiplyRow(arr, 1, 2);
        // printArray(arr);

        // System.out.println();

        System.out.println("Rotating the array by 90 degrees clockwise:");
        int[][] rotated = rotate(arr);
        printArray(rotated);
    }
    
}

