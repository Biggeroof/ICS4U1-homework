import java.util.ArrayList;

public class People
{
    private ArrayList<Person> people;

    public People()
    {
        people = new ArrayList<>();
    }

    public void addPerson(String name, int age)
    {
        people.add(new Person(name, age));
    }

    public void addPerson(Person p)
    {
        people.add(p);
    }

    public void happyBirthday(String name)
    {
        //for each person p in the array people
        for (Person p: people)
        {
            if(p.getName().equals(name))
            {
                System.out.println("Happy birthday, " + name + "!");
                p.getOlder();
                break;
            }
        }
    }

    @Override
    public String toString()
    {
        return people.toString();
    }
}
