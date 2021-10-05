import java.util.Scanner;

public class questionThreeFour {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

        System.out.print("Input: ");
        String numbers = input.nextLine();
        int total = 0;

		
		if(numbers.length() % 2 == 0)
		{
		    for(int i = 2; i <= numbers.length(); i += 2)
		    {
		        total += Integer.parseInt(numbers.substring(i - 2, i));
		    }
		}
		
		else
		{
		    for(int i = 2; i <= (numbers.length() - 1); i += 2)
		    {
		        total += Integer.parseInt(numbers.substring(i - 2, i));
		    }
		    total += Integer.parseInt(numbers.substring(numbers.length() - 1));
		}
		System.out.println(total);
	}
}
