import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class linearSearch
{
    public static void main(String[] args) 
    {
    int[] arr = {69, 87, 2, 5, 95, 20, 23, 9, 39, 18};
    int number = 39;

    System.out.println(linearSearch(arr, number));  
    }

    public static boolean linearSearch(int[] arr, int number) 
    {
        for(int i = 0; i < arr.length; i++)
        {
            if(arr[i] == number)
            {
                return true;
            }
        }
        return false;
    }
}
