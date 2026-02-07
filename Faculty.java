/**
 * Sometimes, a staff may take over the dean’s doManage() duty if he is out sick.
 * Besides, a staff is allowed to take courses to pursue another degree.
 */

public class Faculty extends Person implements Teach //不再执行DocSign, Manage
{
    private String name;
    private Students studyDelegate;
    private School school; //让Faculty属于一个具体的学院！

    //Constructor!!!
    public Faculty(String theName, int years, School theSchool)
    {
        super(years);

        this.name = theName;
        this.school = theSchool;
    }

    public String getName()
    {
        return name;
    }

    public School getSchool()
    {
        return school;
    }

    //尽可被委派教学任务！！！
    @Override
    public void teach()
    {
        System.out.println("Faculty " + name + " from " + school.schoolName() + " is teaching!");
    }

    /**
     * 不再执行签字任务！！！
     *
    @Override
    public void signing()
    {
        System.out.println("Faculty " + name + " signed on the behalf of Dean!");

    }
     *
     */

    /**
     * 不再执行管理任务！！！
     *
    @Override
    public void manage()
    {
        System.out.println("Faculty " + name + " is managing!");
    }
    */

    //仍然可以成为Part-Time Student！！！
    public void setStudyDelegate(Students theStudyDelegate)
    {
        this.studyDelegate = theStudyDelegate;
    }

    public void purseDegree(String major)
    {
        if(studyDelegate == null)
        {
            throw new IllegalStateException("Not Pursuing A Degree!");
        }

        else
        {
            studyDelegate.studying();
            System.out.println("Faculty " + name + " from " + school.schoolName() + " is pursing the degree of " + major);
        }
    }

}
