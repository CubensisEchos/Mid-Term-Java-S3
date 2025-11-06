public class Person
{
    private int id;
    private String name;
    private int age;
    private String phoneNumber;


    //constructors
    public Person()
    {
        this.id = 0;
        this.name = "";
        this.age = 0;
        this.phoneNumber = "";
    }

    public Person(int id, String name, int age, String phoneNumber)
    {
        this.id = id;
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }


    //get and set stuff
    public int getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }


    //toString
    public String toString()
    {
        return "Person [id=" + id + ", name=" + name + ", age=" + age + ", phoneNumber=" + phoneNumber + "]";
    }
}