import java.util.Scanner;

public class questionTwoFour {
    public static void main (String args[])
    {
        Scanner input = new  Scanner(System.in);
        System.out.println("Enter a mesage to be encrypted: ");
        String phr = input.nextLine();
        String done = "";
        char temp;
        int len = phr.length();

        if(len == 1)
        {
            System.out.print("Encrypted: ");
            System.out.println(phr);
            return;
        }

        done += phr.charAt(len - 1);

        for(int i = 1; i < len - 1; i++)
        {
            if( phr.charAt(i) == 125)
            {
                done += '!';
            }
            else if(phr.charAt(i) == 126)
            {
                done += '"';
            }
            else if(phr.charAt(i) == 32)
            {
                done += " ";
            }
            else
            {
                temp = phr.charAt(i);
                temp += 2;
                done += temp;
            }     

        }
        done += phr.charAt(0);

        System.out.print("Encrypted: ");
        System.out.println(done);
    }
}
