import java.util.Scanner;

import java.util.Scanner;

public class questionFourOneOne 
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String phrase = input.nextLine();
        char[] charPhrase = new char[phrase.length()];
        String[] stringPhrase = new String[phrase.length()];

        for(int i = 0; i < phrase.length(); i++)
        {
            charPhrase[i] = phrase.charAt(i);
            stringPhrase[i] = Character.toString(phrase.charAt(i));
        }

        System.out.println("Enter an integer: ");
        int n = Integer.parseInt(input.nextLine());
        String[] arr = new String[n];

        for(int i = 0; i < n; i++)
        {
            System.out.println("Enter a string: ");
            arr[i] = input.nextLine();
        }

        for(int i = 0; i < n - 1; i++)
        {
            System.out.print(arr[i] + " ");
        }
        System.out.println(arr[n - 1]);
    }
}
