public class SeniorAdmin implements Manage
{
    private AdminStaff seniorStaff;

    public SeniorAdmin(AdminStaff seniorStaff)
    {
        if(seniorStaff == null)
        {
            throw new IllegalArgumentException("No Senior Staff!");
        }

        this.seniorStaff = seniorStaff;
    }

    @Override
    public void manage()
    {
        System.out.println("Senior Staff " + seniorStaff.getName() + " is managing!\n");
    }
}
