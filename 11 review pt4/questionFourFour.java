import java.util.Scanner;

public class questionFourFour {
    public static boolean isAlpha(String phr)
    {
        char ch;
        for(int i = 0; i < phr.length(); i++)
        {
            ch = phr.charAt(i);
            if (!((65 <= ch && ch <= 90) || (97 <= ch && ch <= 122))) 
            {
                return false;
            }
        }
        return true;
    }

    public static boolean containsUpper(String phr)
    {
        char ch;
        for(int i = 0; i < phr.length(); i++)
        {
            ch = phr.charAt(i);
            if ((65 <= ch && ch <= 90)) 
            {
                return true;
            }
        }
        return false;
    }

    public static boolean ContainsLower(String phr)
    {
        char ch;
        for(int i = 0; i < phr.length(); i++)
        {
            ch = phr.charAt(i);
            if ((97 <= ch && ch <= 122)) 
            {
                return true;
            }
        }
        return false;
    }

    public static boolean containsDigit(String phr) {
        char ch;
        for(int i = 0; i < phr.length(); i++)
        {
            ch = phr.charAt(i);
            if ((48 <= ch && ch <= 57)) 
            {
                return true;
            }
        }
        return false;
    }

    public static boolean containsSymbol(String phr) {
        String specialChars = "/*!@#$%^&*()\"{}_[]|\\?/<>,.";
        for(int i = 0; i < phr.length(); i++)
        {
            if (specialChars.contains(phr.substring(i, i + 1)))
            {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean match = false;
        String password = "";
        int len = 0;       
        String strength = "invalid";

        while(!match)
        {
            System.out.print("Please enter a new password: ");
            password = input.nextLine();
            len = password.length();

            System.out.print("Please re-enter a new password: ");
            String compare = input.nextLine();

            if(password.equals(compare))
            {
                match = true;
            }
            else
            {
                System.out.println("Passwords do not match. Try again.");
            }
        }

        if (isAlpha(password) == true && len > 8)
        {
            strength = "weak";
        }
        else if (containsUpper(password) == true && ContainsLower(password) == true && containsDigit(password) == true)
        {
            strength = "medium";
        }

        if (containsUpper(password) == true && ContainsLower(password) == true && containsDigit(password) == true && len > 15 && containsSymbol(password))
        {
            strength = "strong";
        }     

        System.out.println("The password strengh is " + strength + "!");
    }
}
