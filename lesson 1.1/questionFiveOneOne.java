import java.util.Scanner;

public class questionFiveOneOne 
{
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        String[] names = {"Alan", "Ada", "Grace", "Linus"};
        int[] numbers = {181256345, 181159830, 181245891, 189875304};
        boolean nameFound = false;

        System.out.println("Class:");
        System.out.println("  CS101");
        System.out.println("Students:");
        for(int i = 0; i < names.length; i++)
        {
            System.out.print("  " + names[i] + ", " + numbers[i]);
            System.out.println();
        }           
        
        System.out.print("Please enter a name: ");
        String name = input.nextLine();

        for(int i = 0; i < names.length; i++)
        {
            if(name.equals(names[i]))
            {
                nameFound = true;                
                System.out.println(name + "'s student number is " + numbers[i]);
                break;
            }
        }
        if(!nameFound)
        {
            System.out.println("Student " + name + " does not exist");
        }
    }
    
}
