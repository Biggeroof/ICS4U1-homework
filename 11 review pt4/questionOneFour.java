import java.util.Scanner;

public class questionOneFour {
    public static void main (String args[])
    {
        Scanner input = new  Scanner(System.in);
        System.out.println("Enter a string: ");
        String phr = input.nextLine();
        String done = "";

        for(int i = 0; i < phr.length(); i++)
        {
            char ch = phr.charAt(i);
            if( 'a' <= ch && ch <= 'z')
            {
                ch -= 32;
                done += ch;
            }
            else
            {
                done += ch;
            }
        }
        System.out.println("Uppercase Equivalent: ");
        System.out.println(done);
    }
}
