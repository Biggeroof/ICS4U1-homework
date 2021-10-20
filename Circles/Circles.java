public class Circles {

    /*
     * DO NOT CHANGE ANY CODE BELOW
     * You may comment out code while testing.
     */
    public static void main(String[] args) {
        // create two circles
        Circle c1 = new Circle(4, -1, 6);
        Circle c2 = new Circle(3, 2, -2);

        // print them both using toString and printEquation
        System.out.println("c1:");
        System.out.println(c1);
        Circle.printEquation(c1);
        System.out.println("");

        System.out.println("c2:");
        System.out.println(c2);
        Circle.printEquation(c2);
        System.out.println("");

        // print the radius, diameter, circumference, and area, rounded nicely
        System.out.printf("Radius of c1: %.2f units%n", c1.getR());
        System.out.printf("Diameter of c1: %.2f units%n", c1.diameter());
        System.out.printf("Circumference of c1: %.2f units%n", c1.circumference());
        System.out.printf("Area of c1: %.2f units²%n", c1.area());
        System.out.println("");

        // find the smaller circle
        Circle smaller = c1.smaller(c2);
        System.out.println("Smaller of c1 and c2: " + smaller);
        System.out.println("");

        // create new circles and references
        System.out.println("More circles...");
        Circle c3 = c1;
        Circle c4 = new Circle(c1);
        Circle c5 = new Circle();
        System.out.print("c3: ");
        Circle.printEquation(c3);
        System.out.print("c4: ");
        Circle.printEquation(c4);
        System.out.print("c5: ");
        Circle.printEquation(c5);
        System.out.println();

        // test inside
        System.out.println("Is c2 entirely inside c1? " + c2.isInside(c1));
        System.out.println("Is c5 entirely inside c4? " + c5.isInside(c2));
        System.out.println("");

        // test equality/equivalence
        System.out.println("smaller == c2? " + (smaller == c2) );
        System.out.println("c1 == c3? " + (c1 == c3) );
        System.out.println("c1 == c4? " + (c1 == c4) );
        System.out.println("c1 equivalent to c4? " + (c1.equals(c4)) );

    }
}
