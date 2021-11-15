import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class QuestionThreeTwoTwo {

    public static void main(String[] args) {
	File file = new File("ICS homework/3.2 File Reading/names.txt");

    try
    {
        Scanner input = new Scanner(file);
        input.useDelimiter(",");
        long total = 0;
        int wordTotal = 0;
        ArrayList<String> arr = new ArrayList<>();

        while(input.hasNext())
        {
            arr.add(input.next());
        }
	
	Collections.sort(arr);
    arr.toString();

        for(int i = 0; i < arr.size(); i++)
        {
            System.out.println(arr.get(i));
            for(int j = 1; j < arr.get(i).length() - 1; j++)
            {
                
                wordTotal += (((int)(arr.get(i).charAt(j))) - 64);
            }
            total += (wordTotal * (i + 1));
            wordTotal = 0;
        }
        System.out.println(total);
    }
    catch(IOException iox)
    {
        System.out.println(iox.getMessage());
    }
    }
}
