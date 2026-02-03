public class AdminStaff extends Person implements AdminWork
{
    private String name;
    public AdminStaff(String theName, int years)
    {
        super(years);

        this.name = theName;
    }

    @Override
    public void adminWork()
    {
        System.out.println("Staff " + name + "is working!!!");
    }
}
