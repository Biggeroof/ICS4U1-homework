import java.util.Scanner;

public class questionThreeFour {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Input: ");
        String numbers = input.nextLine();
        int total = 0;
        int add;
        int len = numbers.length();

        if(numbers.length() % 2 == 0)
        {
            for(int i = 2; i <= len; i += 2 )
            {
                add = Integer.parseInt(numbers.substring(i - 2, i));
                total += add;
                
            }
        }
        else
        {
            for(int i = 2; i <= len - 1; i += 2 )
            {
                add = Integer.parseInt(numbers.substring(i - 2, i));
                total += add;
            }
            
            add = Integer.parseInt(numbers.substring(len - 1));
            total += add;
        }
        System.out.print("Output: ");
        System.out.println(total);

    }
}
