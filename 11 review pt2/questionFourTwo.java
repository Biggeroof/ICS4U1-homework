import java.util.Scanner;

public class questionFourTwo {
    
    public static int findgcd(int num1, int num2)
    {
        //euclids algorithm
        if(num2 == 0)
        {
            return num1;
        }
        return findgcd(num2, num1 % num2);
    }

    public static void main (String args[])
    {
        System.out.print("Enter a positive integer: ");
        Scanner input = new Scanner(System.in);
        int num = Integer.parseInt(input.nextLine());

        int a, b, c = 0;
        boolean print = true;
        int m = 2;
         
        while (c < num) {

            for (int n = 1; n < m; n++) {
                a = m * m - n * n;
                b = 2 * m * n;
                c = m * m + n * n;
         
                if (c > num)
                {
                    break;
                }

                int d = findgcd(a, b);
                int gcd = findgcd(c, d);

                int tempA = a / gcd;
                int tempB = b / gcd;
                int tempC = c / gcd;

                if(tempA*tempA + tempB * tempB == tempC * tempC && gcd != 1)
                {
                    print = false;
                }

                if(print == true)
                {
                    System.out.println(a + " " + b + " " + c);
                }
                print = true;
            }
            m++;
        }
        input.close();
    }
}
