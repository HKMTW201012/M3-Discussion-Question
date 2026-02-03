public class Dean extends Person implements Manage, DocSign
{
    /**
     * Dean may help a faculty to doTeach() if the number of faculty falls short.
     * He may also doWork() for a staff if more than one staff is on vacation.
     */

    private Teach teachDelegate;
    private AdminWork workDelegate;
    private DocSign signDelegate;

    public Dean(int years)
    {
        super(years);

        this.signDelegate = this;
    }

    @Override
    public void manage()
    {
        System.out.println("Dean is managing!");
    }

    @Override
    public void sign()
    {
        if(signDelegate == null)
        {
            throw new IllegalStateException("Sign delegate is null!");
        }

        if(signDelegate == this)
        {
            System.out.println("Dean is signing!");
        }

        else
        {
            signDelegate.sign(); //委派别人执行签字！！！
        }

    }
}
