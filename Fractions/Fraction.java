public class Fraction
{
    private int numerator;
    private int denominator;
    //constructors
    public Fraction(int numerator, int denominator)
    {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Fraction(Fraction other)
    {
        other.numerator = numerator;
        other.denominator = denominator;
    }

    public Fraction(int numerator)
    {
        this.numerator = numerator;
        denominator = 1;
    }

    public Fraction()
    {
        numerator = 1;
        denominator = 1;
    }

    public Fraction(double decimal)
    {
        String s = String.valueOf(decimal);
        int len = s.length() - 1 - s.indexOf('.');
        int denom = 1;

        for (int i = 0; i < len; i++) {
            decimal *= 10;
            denom *= 10;
        }

        int num = (int) Math.round(decimal);
        int gcd = gcd(num, denom);
        this.numerator = num / gcd;
        this.denominator = denom /gcd;
    }

    //accessors and mutators
    public void setDenominator(int denominator)
    {
        this.denominator = denominator;
    }

    public int getDenominator()
    {
        return denominator;
    }

    public void setNumerator(int numerator)
    {
        this.numerator = numerator;
    }

    public int getNumerator()
    {
        return numerator;
    }

    public void setFraction(int numerator, int denominator)
    {
        this.denominator = denominator;
        this.numerator = numerator;
    }

    //instance methods
    public double toDecimal()
    {
        return (double) numerator / denominator;
    }

    public boolean greaterThan(Fraction other) {
        return this.toDecimal() > other.toDecimal(); //`this` is optional
        //return toDecimal() > other.toDecimal();
    }

    public Fraction multiply(Fraction other)
    {
        Fraction multiply = new Fraction(this.numerator * other.numerator, this.denominator * other.denominator);
        multiply.reduce();
        return multiply;
    }

    public Fraction add(Fraction other)
    {
        Fraction add = new Fraction(((this.numerator * other.denominator) + (other.numerator * this.denominator)), (this.denominator * other.denominator));
        add.reduce();
        return add;
    }

    public int gcd(int numerator, int denominator)
    {
        int a = numerator;
        int b = denominator;
        if(a == 0)
        {
            return b;
        }
        return gcd(b%a, a);
    }

    @Override
    //overrides the built in toString()
    public String toString()
    {
        if(denominator == 0)
        {
            return "0";
        }
        if(denominator == 1)
        {
            return Integer.toString(numerator);
        }
        if(denominator < 0)
        {
            return (numerator*-1 + "/" + denominator*-1);
        }
        return numerator + "/" + denominator;
    }

    public boolean equals(Fraction other)
    {
        if(this.numerator * other.denominator == this.denominator * other.numerator)
        {
            return true;
        }
        return false;
    }

    public void timesEquals(Fraction other)
    {
        numerator  *= other.numerator;
        denominator *= other.denominator;
        reduce();
    }

    public void plusEquals(Fraction other)
    {
        numerator = (this.numerator * other.denominator) + (other.numerator * this.denominator);
        denominator = (this.denominator * other.denominator);
        reduce();
    }

    public void integerMultiply(int k)
    {
        this.numerator *= k;
        reduce();
    }

    public void reduce()
    {
        int gcd = gcd(numerator, denominator);
        numerator = numerator / gcd;
        denominator = denominator / gcd;

        if(denominator < 0 || (denominator < 0 && numerator < 0))
        {
            denominator *= -1;
            numerator *= -1;
        }
    }

    public Fraction reciprocal()
    {
        Fraction reciprocal = new Fraction(denominator, numerator);
        return reciprocal;
    }

    public Fraction divide(Fraction other)
    {
        Fraction divided = multiply(other.reciprocal());
        return divided;
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
        //Fraction subtract = new Fraction(f2.getNumerator(), f2.getDenominator());
        //Fraction subtract = f2;
        //this is a reference to f2, so it mutates f2 (won't work)

        //subtract.setNumerator(subtract.getNumerator() * -1);
        f2.integerMultiply(-1);
        Fraction total = new Fraction(f1.add(f2));
        f2.integerMultiply(-1);
        return total;
    }

    public static Fraction quotient(Fraction f1, Fraction f2)
    {
        return f1.divide(f2);
    }
}
