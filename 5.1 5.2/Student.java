public class Student extends Persons{
    private String id;

    public Student (String name, int age, String id)
    {
        super(name, age);
        this.id = id;
    }

    @Override
    public String toString()
    {
        return super.toString() + ", " + id;
    }

    @Override
    public boolean equals(Object o)
    {
        if(super.equals(o))
        {
            Student s = (Student)o;
                return s.id == this.id;
        }
        return false;
    }
}