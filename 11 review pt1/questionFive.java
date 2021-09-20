import java.util.Scanner;

public class questionFive {
    
    public static void main (String args[])
    {
        Scanner input = new Scanner(System.in);
        int num = Integer.parseInt(input.nextLine());
        System.out.println(num);
        int sum = 0;

        while (num > 0) {
            //adds the modulo of the number to sum(this gives last digit)
            sum += num % 10;
            //divide the number by 10 in order to be able to get the next digit
            num = num / 10;
        }

        System.out.println(sum);

        input.close();
    }
}
