public class Faculty extends Person implements Teach, DocSign
{
    private String name;

    //Constructor!!!
    public Faculty(String theName, int years)
    {
        super(years);

        this.name = theName;
    }
    @Override
    public void teach()
    {
        System.out.println("Faculty " + name + " is teaching!");
    }

    @Override
    public void signing()
    {
        System.out.println("Faculty " + name + " signed on the behalf of Dean!");

    }
}
