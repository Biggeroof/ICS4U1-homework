public class Main {
    public static void main(String[] args) {
        Fraction f = new Fraction(3, 5);
        System.out.println("f: " + f);

        Fraction g = new Fraction(7, 10);
        System.out.println("g: " + g);

        Fraction test = new Fraction(-8.343);
        System.out.println(test);

        System.out.println("is f greater than g?: " + f.greaterThan(g));
        //Fraction multiply = f.multiply(g);
        System.out.println("Product of " + f + " and " + g + ": " + Fraction.product(f, g));


        //System.out.println("Adding " + f + " and " + g + ": " + f.add(g));
        System.out.println("Adding " + f + " and " + g + ": " + Fraction.sum(f, g));


        System.out.println("Subtracting " + f + " by " + g + ": " + Fraction.difference(f, g));


        //System.out.println("Dividing " + f + " by " + g + ": " + f.divide(g));
        System.out.println("Dividing " + f + " by " + g + ": " + Fraction.quotient(f, g));


        System.out.println("Reciprocal of " + f + ": " + f.reciprocal());

        System.out.println("Are they equal?: " + f.equals(g));

        //all of these change the original f object directly
        System.out.println("multiplying f by g: ");
        f.timesEquals(g);
        System.out.println("f: " + f);

        System.out.println("adding g to f: ");
        f.plusEquals(g);
        System.out.println("f: " + f);

        System.out.println("mutiplying f by 3");
        f.integerMultiply(3);
        System.out.println("f: " + f);

    }
}
