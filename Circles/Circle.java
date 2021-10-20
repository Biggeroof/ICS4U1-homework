import java.util.Objects;

public class Circle
{
    private double centerX;
    private double centerY;
    private double radius;

    //mutators, accessors, and constructors
    public Circle()
    {
        centerX = 0;
        centerY = 0;
        radius = 1;
    }

    public Circle(double centerX, double centerY, double radius)
    {
        if(radius < 0)
        {
            radius *= -1;
        }

        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
    }

    public Circle(Circle other)
    {
        this.centerX = other.centerX;
        this.centerY = other.centerY;
        this.radius = other.radius;
    }

    public double getCenterX()
    {
        return centerX;
    }

    public void setCenterX(double centerX)
    {
        this.centerX = centerX;
    }

    public double getCenterY()
    {
        return centerY;
    }

    public void setCenterY(double centerY)
    {
        this.centerY = centerY;
    }

    public double getR()
    {
        return radius;
    }

    public void setR(double radius)
    {
        this.radius = radius;
    }

    public void setCircle(double centerX, double centerY, double radius)
    {
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
    }

    //instance methods
    public double area()
    {
        return Math.PI * Math.pow(radius, 2);
    }

    public double circumference()
    {
        return 2 * Math.PI * radius;
    }

    public double diameter()
    {
        return radius * 2;
    }

    public Circle smaller(Circle c)
    {
        if(area() < c.area())
        {
            return this;
        }
        return c;
    }

    public double distance(Circle c)
    {
        return Math.sqrt(Math.pow(this.centerX - c.centerX, 2) + Math.pow(this.centerY - c.centerY, 2));
    }

    public boolean isInside(Circle c)
    {
        double distance = distance(c);

        if(distance + radius < c.radius)
        {
            return true;
        }
        return false;
    }

    public boolean equals(Circle o)
    {

        return (o.centerX == centerX) && (o.centerY == centerY) && (o.radius == radius);
    }

    //class methods
    public static void printEquation(Circle c)
    {
        double tempX = c.centerX;
        double tempY = c.centerY;

        if(tempX >= 0 && tempY >= 0)
        {
            System.out.println("(x - " + Math.abs(tempX) + ")² + (y - " + Math.abs(tempY) + ")² = " + Math.pow(c.radius, 2));
        }
        else if(tempX < 0 && tempY > 0)
        {
            System.out.println("(x + " + Math.abs(tempX) + ")² + (y - " + Math.abs(tempY) + ")² = " + Math.pow(c.radius, 2));
        }
        else if(tempX > 0 && tempY < 0)
        {
            System.out.println("(x - " + Math.abs(tempX) + ")² + (y + " + Math.abs(tempY) + ")² = " + Math.pow(c.radius, 2));

        }
        else
        {
            System.out.println("(x + " + Math.abs(tempX) + ")² + (y + " + tempY + ")² = " + Math.pow(c.radius, 2));
        }

    }

    @Override
    public String toString()
    {
        return "Circle: centre at (" + centerX + ", " + centerY + ") " + "and radius " + radius;
    }
}
