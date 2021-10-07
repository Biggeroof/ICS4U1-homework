import java.util.Scanner;
import java.util.ArrayList;

public class questionTwoOneThree 
{
    public static ArrayList<String> getStringList() 
    {
        ArrayList<String> arr = new ArrayList<String>();
        Scanner input = new Scanner(System.in);
        String phr = "a";
        
        while(true)
        {
            System.out.print("Enter a string: ");
            phr = input.nextLine();
            if(phr.equals(" "))
            {
                break;
            }
            arr.add(phr);
        }
            return arr;
    }

    public static int[] lengthsOfStrings(ArrayList<String> arr) 
    {
        int[] lengths = new int[arr.size()];

        for(int i = 0; i < arr.size(); i++)
        {
            lengths[i] = arr.get(i).length();
        }
        return lengths;
    }

    public static void removeLast(ArrayList<String> arr) 
    {
        arr.remove(arr.size() - 1);
    }

    public static void removeFirst(ArrayList<String> arr) 
    {
        arr.remove(0);
    }

    public static void printList(ArrayList<String> arr) 
    {
        for(int i = 0; i < arr.size(); i++)
        {
            System.out.println(arr.get(i));
        }
        
    }

    public static void printReversed(ArrayList<String> arr) 
    {
        for(int i = (arr.size() - 1); i >= 0; i--)
        {
            System.out.println(arr.get(i));
        }
        
    }

    public static ArrayList<String> removeFromList(ArrayList<String> arr, String remove) 
    {
        Scanner input = new Scanner(System.in);
        ArrayList<String> arr2 = arr;

        for(int i =0; i < arr.size(); i++)
        {
            if(arr2.get(i).equals(remove))
            {
                arr2.remove(i);
                return arr2;
            }
        }
        System.out.println("Could not find this string. Please enter the index instead(starting from 1): ");
        int index = Integer.parseInt(input.nextLine());
        arr2.remove(index - 1);
        return arr2;
        
    }
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        ArrayList<String> arr = getStringList();
        int[] lengths = lengthsOfStrings(arr);

        System.out.println("Printing elements: ");
        printList(arr);
        
        System.out.println("Printing lengths: ");
        for(int i = 0; i < lengths.length; i++)
        {
            System.out.println(lengths[i]);
        }

        System.out.println("Printing elements in reverse: ");
        printReversed(arr);  

        System.out.println("removing first and last items");
        removeFirst(arr);
        removeLast(arr);

        System.out.println("Printing elements: ");
        printList(arr);

        System.out.println("Enter a phrase you would like to remove from the list: ");
        String remove = input.nextLine();
        ArrayList<String> arr2 = removeFromList(arr, remove);
        System.out.println("removed!");
        System.out.println();
        printList(arr);
    }
}
