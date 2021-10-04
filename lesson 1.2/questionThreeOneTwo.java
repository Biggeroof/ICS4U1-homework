public class questionThreeOneTwo 
{
    public static void printArray(int[][] arr)
    {
        int lenr = arr.length;
        int lenc;
        //System.out.print("[ ");
        for(int i = 0; i < lenr - 1; i++)
        {
            System.out.print("[");
            lenc = arr[i].length;
            for(int j = 0; j < lenc - 1; j++)
            {
                System.out.print(arr[i][j] + ", ");
            }
            System.out.print(arr[i][lenc - 1]);
            System.out.println("],");
        }

        lenc = arr[lenr - 1].length;

        System.out.print("[");
        for(int j = 0; j < lenc - 1; j++)
            {
                System.out.print(arr[lenr - 1][j] + ", ");
            }
        System.out.print(arr[lenr - 1][lenc - 1]);
        //add bracket back here later
        System.out.print("] ");
        System.out.println();
    }

    public static void swapRow(int arr[][], int row1, int row2) 
    {
        for(int i = 0; i < arr[0].length; i++)
        {
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
            int temp = arr[i][col1];
            arr[i][col1] = arr[i][col2];
            arr[i][col2] = temp;
        }
    }

    public static void multiplyRow(int[][] arr, int row, int num) 
    {
        for(int i = 0; i < arr[0].length; i++)
        {
            arr[row][i] *= num;
        }
    }

    public static int[][] rotate(int[][] arr) 
    {
        //length variables for the rotated array
        int lenr = arr[0].length;   
        int lenc = arr.length;
        int[][] rotated = new int[lenr][lenc];

        for(int i = 0; i < lenr; i++)
        {
            for(int j = 0; j < lenc; j++)
            {
                rotated[i][j] = arr[j][i];
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

        System.out.println("Swapping rows 1 and 2:");
        swapRow(arr, 0, 1);
        printArray(arr);

        System.out.println();

        System.out.println("Swapping columns 1 and 2:");
        swapColumn(arr, 0, 1);
        printArray(arr);

        System.out.println();

        System.out.println("Multiplying row 2 by 2:");
        multiplyRow(arr, 1, 2);
        printArray(arr);

        System.out.println();

        System.out.println("Rotating the array by 90 degrees clockwise:");
        int rotated[][] = rotate(arr);
        printArray(rotated);
    }
    
}
