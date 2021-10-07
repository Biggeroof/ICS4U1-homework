import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class questionOneOneThree 
{
    public static ArrayList<Integer> getIntList() 
    {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        Scanner input = new Scanner(System.in);
        String number = "a";
        
        while(true)
        {
            System.out.print("Enter an integer: ");
            number = input.nextLine();
            //checks if the input is a space
            if(number.equals(" "))
            {
                //exit if space
                break;
            }
            arr.add(Integer.parseInt(number));
        }
            return arr;
    }

    public static Integer greatest(ArrayList<Integer> arr) 
    {
        Integer greatest = -9999999;
        for(int i = 0; i < arr.size(); i++)
        {
            if(arr.get(i) > greatest)
            {
                greatest = arr.get(i);
            }
        }
        return greatest;
    }

    public static Integer sum(ArrayList<Integer> arr) 
    {
        Integer sum = 0;
        for(int i = 0; i < arr.size(); i++)
        {
            sum += arr.get(i);
        }    
        return sum;
    }

    public static double average(ArrayList<Integer> arr) 
    {
        if(arr.size() == 0)
        {
            return 0;
        }
        double total = sum(arr);
        return total /= arr.size();
    }
    
    public static double median(ArrayList<Integer> arr) 
    {
        int len = arr.size() - 1;
        Collections.sort(arr);
        double median;
        if(len == 0)
        {
            return 0;
        }
        if((len + 1 ) % 2 == 0)
        {
            //if mod 2 is 0 then avg 2 values in middle 1, 2, 3, 4         2 + 3 = 5, 5 / 2 = 2.5
            median = (double)((arr.get(len / 2)) + (arr.get(len / 2 + 1))) / 2;
        }
        else
        {
            //get value in middle of array
            median = arr.get((len / 2));
        }
        return median;
    }

    public static double variance(ArrayList<Integer> arr) 
    {
        double avg = average(arr);
        double variance = 0;
        for (Integer i : arr) 
        {
            variance += Math.pow(i - avg, 2);
        }
        return (variance / (arr.size() - 1));
    }

    public static boolean moreThanOnce(int num, ArrayList<Integer> arr) 
    {
        int occurences = 0;

        //iterate through entire array, if number appears twice return true if not return false
        for (Integer i : arr) 
        {
            if(i == num)
            {
                occurences++;
            } 
            if(occurences == 2)
            {
                return true;
            }
        }
        return false;
        
    }

    public static ArrayList<Integer> combine(ArrayList<Integer> arr1, ArrayList<Integer> arr2) 
    {
        boolean duplicate = false;
        ArrayList<Integer> combined = new ArrayList<Integer>();

        //iterate through original array 1 to add elements
        for(int i = 0; i < arr1.size(); i++)
        {
            duplicate = false;
            //iterare through the entire combined array to check for identical elements
            for(int j = 0; j < combined.size(); j++)
            {
                //if any elements from array i match j dont add them
                if(arr1.get(i) == combined.get(j))
                {
                    duplicate = true;
                    break;
                }
            }
            if(!(duplicate == true))
            {
                combined.add(arr1.get(i));
            }
        }

        //do the same for 2nd array
        for(int i = 0; i < arr2.size(); i++)
        {
            duplicate = false;
            for(int j = 0; j < combined.size(); j++)
            {
                if(arr2.get(i) == combined.get(j))
                {
                    System.out.println("here");
                    duplicate = true;
                    break;
                }
            }
            if(!(duplicate == true))
            {
                combined.add(arr2.get(i));
            }
        }

        return combined;
    }
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> arr = getIntList();
        System.out.println("The greatest number in this array is: " + greatest(arr));
        System.out.println("The sum is: " + sum(arr));
        System.out.println("The average is: " + average(arr));
        System.out.println("The median is: " + median(arr));
        System.out.println("The variance is: " + variance(arr));
        System.out.print("Please enter an integer: ");
        int check = Integer.parseInt(input.nextLine());
        System.out.println("Does the number appear more than once?: " + moreThanOnce(check, arr));
        ArrayList<Integer> arr2 = getIntList();
        ArrayList<Integer> combined =  combine(arr, arr2);
        System.out.println("array 1: " + arr);
        System.out.println("array 2: " + arr2);
        System.out.println("combined: " + combined);
    }
}
