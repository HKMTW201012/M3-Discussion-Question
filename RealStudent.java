public class RealStudent implements Students, Subscriber
{
    private String name;
    private School school;

    public RealStudent(String name, School school)
    {
        this.name = name;
        this.school = school;
    }

    @Override
    public void studying()
    {
        System.out.println("Student " + name + " is studying");
    }

    @Override
    public void subscribing(String information)
    {
        System.out.println("Student " + name + " (" + school.schoolName() + ") received: " + information);


    }
}
