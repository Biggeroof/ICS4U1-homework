import java.util.Scanner;

public class Ex1 {

    public static int getInt(Scanner sc, String input){
        int num;
        while (true) {
            try {
                System.out.print(input);
                num = Integer.parseInt(sc.nextLine());
                break;
            }
            catch (NumberFormatException nfe) {
                System.out.println("The input was not a valid integer.");
            }
        }
        return num;
    }

    public static double getDouble(Scanner sc, String input){
        double decimal;
        while (true){
            try{
                System.out.print(input);
                decimal = Double.parseDouble(sc.nextLine());
                break;
            }
            catch (NumberFormatException nfe){
                System.out.println("The input was not a double.");
            }
        }
        return decimal;
    }

    public static int getPositiveInt(){
        Scanner sc = new Scanner(System.in);
        while (true){
            int num = getInt(sc, "Enter a positive integer: ");
            if (num > 0){
                return num;
            }
            else{
                System.out.println("The integer you entered was negative.");
            }
        }
    }

    public static void divide(){
        Scanner sc = new Scanner(System.in);
        int dividend = getInt(sc, "Enter the dividend: ");
        int divisor = getInt(sc, "Enter an divisor: ");
        try {
            int quotient = dividend / divisor;
            int remainder = dividend - quotient * divisor;
            System.out.printf("%d/%d = %d rem %d", dividend, divisor, quotient, remainder);
        } catch(ArithmeticException ae){
            System.out.println("The divisor cannot be 0.");
        }
    }
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        // System.out.println(getInt(sc, "Enter an integer: "));
        // System.out.println(getDouble(sc, "Enter an double: "));
        // System.out.println(getPositiveInt());
        divide();
    }
}