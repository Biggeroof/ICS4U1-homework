public class Persons {
    
    protected String name;
    protected int age;

    public Persons(String name, int age)
    {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString()
    {
        return "Name: " + name + ", Age: " + age;
    }

    @Override
    public boolean equals(Object o)
    {
        if((o != null) && (o.getClass() == this.getClass()))
        {
            Persons p = (Persons)o;
            return (p.name.equals(this.name)) && (p.age == this.age);
        }
        return false;
    }
}
