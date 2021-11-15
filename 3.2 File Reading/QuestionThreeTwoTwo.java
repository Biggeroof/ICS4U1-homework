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
        ArrayList<String> arr = new ArrayList<>();

        while(input.hasNext())
        {
            arr.add(input.next());
        }
	
	Collections.sort(arr);

        for(int i = 0; i < arr.size(); i++)
        {
            total += (((int) arr.get(i).charAt(1)) - 64) * (i + 1);
        }
        System.out.println(total);
    }
    catch(IOException iox)
    {
        System.out.println(iox.getMessage());
    }
    }
}
