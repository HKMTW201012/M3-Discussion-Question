public class FacultySubscriber implements Subscriber
{
    private Faculty oneFaculty;

    public FacultySubscriber(Faculty f)
    {
        this.oneFaculty = f;
    }

    @Override
    public void subscribing(String message)
    {
        System.out.println("Faculty " + oneFaculty.getName() + " received: " + message);
    }
}
