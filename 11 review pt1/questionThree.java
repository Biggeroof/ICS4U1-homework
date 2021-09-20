import java.util.Scanner;

public class questionThree {
    public static void main (String args [])
    {
        Scanner input = new Scanner(System.in);

        double one = Double.parseDouble(input.nextLine());
        double two = Double.parseDouble(input.nextLine());
        double three = Double.parseDouble(input.nextLine());
        
        double mean = (one + two + three) / 3;
        System.out.println(mean);  

        input.close();
    }
     
}
