public class Main {
    public static void main(String[] args) {
        Fraction f = new Fraction(3, 5);
        System.out.println("f: " + f);

        Fraction g = new Fraction(7, 10);
        System.out.println("g: " + g);

        System.out.println("is f greater than g?: " + f.greaterThan(g));
        //Fraction multiply = f.multiply(g);
        Fraction multiply = product(f, g);
        System.out.println("Product of " + f + " and " + g + ": " + multiply);

        //System.out.println("Adding " + f + " and " + g + ": " + f.add(g));
        System.out.println("Adding " + f + " and " + g + ": " + sum(f, g));

        System.out.println("Subtracting " + f + " by " + g + ": " + difference(f, g));

        //System.out.println("Dividing " + f + " by " + g + ": " + f.divide(g));
        System.out.println("Dividing " + f + " by " + g + ": " + quotient(f, g));

        System.out.println("Reciprocal of " + f + ": " + f.reciprocal());

        System.out.println("Are they equal?: " + f.equals(g));

    }

    public static Fraction product(Fraction f1, Fraction f2) 
    {
        return f1.multiply(f2);
    }

    public static Fraction sum(Fraction f1, Fraction f2) 
    {
        return f1.add(f2);
    }

    public static Fraction difference(Fraction f1, Fraction f2) 
    {
        f2.setNumerator(f2.getNumerator() * -1);
        return f1.add(f2);
    }

    public static Fraction quotient(Fraction f1, Fraction f2) 
    {
        return f1.divide(f2);
    }

}
