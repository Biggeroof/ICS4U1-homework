import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class QuestionThreeTwoOne {

    public static void main(String args[]) {
        File file = new File("ICS homework/3.2 File Reading/grid.txt");
        
        try {
            Scanner input = new Scanner(file);
            int greatest = 0;
            int total;
            int cases = 0;
            int[][] arr = new int[20][20];
            int lenr = arr.length;
            int lenc = arr[0].length;
            for(int i = 0; i < lenr; i++)
            {
                for(int j = 0; j < lenc; j++)
                {
                    arr[i][j] = Integer.parseInt(input.next());
                }
            }

            //horizontal
            for(int i = 0; i < lenr; i++)
            {
                for(int j = 0; j < lenc - 3; j++)
                {
                    total = arr[i][j] * arr[i][j + 1] * arr[i][j + 2] * arr[i][j + 3];
                    if (total > greatest)
                    {
                        greatest = total;
                        cases = 1;
                    }
                }
            }

            //vertical
            for(int i = 0; i < lenr; i++)
            {
                for(int j = 0; j < lenc - 3; j++)
                {
                    total = arr[j][i] * arr[j + 1][i] * arr[j + 2][i] * arr[j + 3][i];
                    if (total > greatest)
                    {
                        greatest = total;
                        cases = 2;
                    }
                }
            }

            //diag left to right
            for(int i = 0; i < lenr - 3; i++)
            {
                for(int j = 0; j < lenc - 3; j++)
                {
                    total = arr[j][i] * arr[j + 1][i + 1] * arr[j + 2][i + 2] * arr[j + 3][i + 3];
                    if (total > greatest)
                    {
                        
                        greatest = total;
                        cases = 3;
                    }
                }
            }

            //diag right to left
            for(int i = lenr - 1; i > lenr - (lenr - 4); i--)
            {
                for(int j = 0; j < lenc - 3; j++)
                {
                    total = arr[j][i] * arr[j + 1][i - 1] * arr[j + 2][i - 2] * arr[j + 3][i - 3];
                    if (total > greatest)
                    {
                        greatest = total;
                        cases = 4;
                    }
                }
            }
            System.out.println(greatest + " " + cases);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
}
