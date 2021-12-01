import java.util.ArrayList;

public class Peoples {

    public static void main(String[] args) {
	    Person p = new Person("Alan", 42);
        System.out.println(p);
        p.getOlder();
        System.out.println(p);

        People ppl = new People();
        ppl.addPerson(p);
        System.out.println(ppl);
        Person q = new Person("Dave", 35);
        ppl.addPerson(q);
        ppl.addPerson(new Person("Ronald", 88));
        System.out.println(ppl);
        ppl.happyBirthday("Alan");
        ppl.addPerson("Ollie", 4);
        System.out.println(ppl.getPerson(0).getName());
        

    }
}
