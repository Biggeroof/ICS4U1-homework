import java.util.Scanner;

public class questionTwoTwo {
    
    public static void main (String args[])
    {
        Scanner input = new Scanner(System.in);
        int num = Integer.parseInt(input.nextLine());
        int res = 2;
        int count = 1;

        while(res <= num)
        {
            res = (int)Math.pow(2, count);
            count++;
        }
        System.out.println(res + " is the smallest power of 2 greater than " + num);

        input.close();
    }

}
