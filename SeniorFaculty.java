public class SeniorFaculty implements DocSign
{
    private Faculty seniorFaculty;

    public SeniorFaculty(Faculty seniorFaculty)
    {
        if (seniorFaculty == null) throw new IllegalArgumentException("No Qualified Faculty!");
        this.seniorFaculty = seniorFaculty;
    }

    @Override
    public void signing()
    {
        System.out.printf("Senior Faculty: " + seniorFaculty.getName() + " signed on the behalf of the Dean!");
    }
}
