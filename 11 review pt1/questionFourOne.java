import java.text.DecimalFormat;
import java.util.Scanner;

public class questionFourOne {
    
    public static void main (String args[])
    {
        Scanner input = new Scanner(System.in);
        final double BURGER = 1.69;
        final double FRIES = 1.09;
        final double DRINK = 0.99;
        DecimalFormat df = new DecimalFormat("#.##");

        System.out.println("Number of burgers: ");
        int numBurgers;
        numBurgers = Integer.parseInt(input.nextLine());

        System.out.println("Number of fries: ");
        int numFries;
        numFries = Integer.parseInt(input.nextLine());

        System.out.println("Number of drinks: ");
        int numDrink;
        numDrink = Integer.parseInt(input.nextLine());

        double subtotal = (BURGER * numBurgers) + (FRIES *  numFries) + (DRINK * numDrink);
        System.out.println("Subtotal: " + subtotal);

        double PST = subtotal * 0.08;
        System.out.println("PST: " + df.format(PST));

        double GST = subtotal * 0.05;
        System.out.println("GST: " + df.format(GST));

        double total = subtotal + PST + GST;
        System.out.println("Total: " + df.format(total));

        double tender = Double.parseDouble(input.nextLine());
        System.out.println("Change: " + df.format((tender - total)));
        input.close();
    }

    }
