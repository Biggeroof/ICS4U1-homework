public class Main {
    public static void main(String[] args) {
        Fraction f = new Fraction(3, 1);
        System.out.println("f: " + f);

        Fraction g = new Fraction(-8.343);
        System.out.println("g: " + g);

        System.out.println("is f greater than g?: " + f.greaterThan(g));
        //Fraction multiply = f.multiply(g);
        Fraction multiply = product(f, g);
        System.out.println("Product of " + f + " and " + g + ": " + multiply);

        //Fraction add = f.add(g);
        //System.out.println(add);

        //Fraction test = new Fraction(3, 6);
        //System.out.println(test.gcd(test.getNumerator(), test.getDenominator()));

        System.out.println("are they equal?: " + f.equals(g));


    }

    public static Fraction product(Fraction f1, Fraction f2) {
        return f1.multiply(f2);
    }

}
