public class Dean extends Person implements Manage, DocSign
{
    /**
     * Dean may help a faculty to doTeach() if the number of faculty falls short.
     *
     * He may also doWork() for a staff if more than one staff is on vacation.
     *
     * When the dean is out sick, certain faculty may signDoc() for him.
     *
     */

    private Teach teachDelegate;
    private AdminWork workDelegate;
    private DocSign signDelegate;
    private Manage manageDelegate;

    public Dean(int years)
    {
        super(years);

        this.signDelegate = this; //默认通常情况下Dean自己签字！！！
    }

    //Manage是Dean的【本职工作】，也就是说Dean需要一直持有这个功能！
    //执行Manage接口！
    //这里的意思是Dean本身自己执行管理工作！
    @Override
    public void manage()
    {
        System.out.println("\nDean is managing!\n");
    }

    //Sign也是Dean的【本职工作】！！！
    //Dean也是需要一直持有这个功能！所以执行此接口！
    //同时，Dean可以委派他人签字！！！
    @Override
    public void signing()
    {
        if(signDelegate == null)
        {
            throw new IllegalStateException("Sign delegate is null!");
        }

        if(signDelegate == this)
        {
            //如果执行签字接口的是Dean，也就是this；
            //就使用Dean自己的签字方法！
            DeanSigning();
        }

        else
        {
            //如果执行签字接口的不是Dean，就委派！
            signDelegate.signing(); //委派别人执行签字！！！
        }

    }

    //Dean自己的private签字方法！
    //这也是Dean本人签字的体现！
    private void DeanSigning()
    {
        System.out.println("Dean is signing!");
    }

    //Dean帮忙授课！
    //注意！不是Dean亲自去上课，而是把“授课”这个人物委派给可以授课的对象！
    public void helpTeach()
    {
        if(teachDelegate == null)
        {
            throw new IllegalStateException("No Instructor!!!");
        }

        //把授课这个任务委派给可以授课的对象！！！
        teachDelegate.teach();
    }

    //同理！Dean本身不工作，而是把工作委派给可以工作的对象！
    public void helpWork()
    {
        if(workDelegate == null)
        {
            throw new IllegalStateException("No Staff!!!");
        }

        //把工作委派给可以工作的对象！！！
        workDelegate.adminWork();

    }

    //Sometimes, a staff may take over the dean’s doManage() duty if he is out sick.
    public void helpManage()
    {
        //如果有Staff可以被委派，就委派！
        if(manageDelegate != null)
        {
            manageDelegate.manage();
        }
        //没有可以被委派的Staff时，Dean还是自己管理！
        else
        {
            manage();
        }

    }

    public void setTeachDelegate(Teach theTeach)
    {
        this.teachDelegate = theTeach;
    }

    public void setWorkDelegate(AdminWork theWork)
    {
        this.workDelegate = theWork;
    }

    public void setSignDelegate(DocSign theSign)
    {
        if(theSign == null)
        {
            throw new IllegalArgumentException("Dean is unavailable! A staff is required!");
        }

        this.signDelegate = theSign;
    }

    public void setManageDelegate(Manage theManage)
    {
        this.manageDelegate = theManage;
    }
}
