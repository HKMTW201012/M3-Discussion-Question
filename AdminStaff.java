public class AdminStaff extends Person implements AdminWork
{
    private String name;

    public AdminStaff(String theName, int years)
    {
        super(years);

        this.name = theName;
    }

    public String getName()
    {
        return name;
    }

    @Override
    public void adminWork()
    {
        System.out.println("Admin staff " + name + " is working!!!");
    }
}
