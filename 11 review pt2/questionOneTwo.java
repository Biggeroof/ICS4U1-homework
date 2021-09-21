import java.util.Scanner;

public class questionOneTwo {

    public static void main (String args[])
    {
        Scanner input = new Scanner(System.in);

        char a = input.next().charAt(0);
        char b = input.next().charAt(0);
        char c = input.next().charAt(0);
        char temp;

        if(a > b)
        {
            temp = a;
            a = b;
            b = temp;
        }

        if(a > c)
        {
            temp = a;
            a = c;
            c = temp;
        }

        if(b > c)
        {
            temp = b;
            b = c;
            c = temp;
        }

        System.out.print(a + " ");
        System.out.print(b + " ");
        System.out.println(c);
        
        input.close();
    }
}
