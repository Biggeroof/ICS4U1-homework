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
        this.centerX = centerX;
        this.centerY = centerY;
        //take the absolute value of the radius before assigning it
        this.radius = Math.abs(radius);
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
        //calculates and returns area pi * r^2
        return Math.PI * Math.pow(radius, 2);
    }

    public double circumference()
    {
        //calculates and returns circumference 2 * pi * r
        return 2 * Math.PI * radius;
    }

    public double diameter()
    {
        //calculates and returns diameter 2 * r
        return radius * 2;
    }

    public Circle smaller(Circle c)
    {
        //compares the areas of the circle and returns the area of the smaller one
        if(area() < c.area())
        {
            return this;
        }
        return c;
    }

    public double distance(Circle c)
    {
        //calculates and returns the distance between the centers of the circles
        return Math.sqrt(Math.pow(this.centerX - c.centerX, 2) + Math.pow(this.centerY - c.centerY, 2));
    }

    public boolean isInside(Circle c)
    {
        double distance = distance(c);

        //if the radius of the circle added with the distance between the 2 centres is greater than the "outer" circle's radius, then return true
        if(distance + radius < c.radius)
        {
            return true;
        }
        return false;
    }

    public boolean equals(Circle o)
    {
        //checks all 3 parameters of each object and returns true if they are all the same
        return (o.centerX == centerX) && (o.centerY == centerY) && (o.radius == radius);
    }

    //class methods
    public static void printEquation(Circle c)
    {
        double tempX = c.centerX;
        double tempY = c.centerY;

        //if x and y coordinates are greater than zero, make both of the signs negative in print
        if(tempX >= 0 && tempY >= 0)
        {
            System.out.println("(x - " + Math.abs(tempX) + ")² + (y - " + Math.abs(tempY) + ")² = " + Math.pow(c.radius, 2));
        }
        //if x is less than zero and y is greater than zero, make the first sign positive and the second one negative
        else if(tempX < 0 && tempY > 0)
        {
            System.out.println("(x + " + Math.abs(tempX) + ")² + (y - " + Math.abs(tempY) + ")² = " + Math.pow(c.radius, 2));
        }
        //if x is greater than zero and y is less than zero, make the first sign negative and the second one positive
        else if(tempX > 0 && tempY < 0)
        {
            System.out.println("(x - " + Math.abs(tempX) + ")² + (y + " + Math.abs(tempY) + ")² = " + Math.pow(c.radius, 2));

        }
        //if both x and y coordinates are less than zero, make both signs positive
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
