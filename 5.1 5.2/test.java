public class test 
{

    public static void main(String[] args) {
        Persons p = new Persons("Alan", 42);
        Student q = new Student("Ada", 37, "10010101");
        // print each person using toString
        Persons r = p;
        System.out.println(r.equals(p));
        Student s = new Student("Ada", 37, "10010101");
        System.out.println(s.equals(q));

        //c) the equals method works like this because r is a reference to p (i think) so they count as equal, while s isnt a ref to q

    }
    
}
