public class Fraction
{
    private int numerator;
    private int denominator;
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
        return multiply;
    }

    //does it without caring about the gcf so no simplifying
    public Fraction add(Fraction other)
    {
        Fraction add = new Fraction(((this.numerator * other.denominator) + (other.numerator * this.denominator)), (this.denominator * other.denominator));
        return add;
    }

    public int gcd(int numerator, int demoninator)
    {
        int a = numerator;
        int b = demoninator;
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
}
