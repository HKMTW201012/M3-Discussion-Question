/**
 * 这个类是为了实现Faculty可以兼职上学这个要求！
 * Faculty本来应该仅仅实现工作，所以，不能把学习这个implementation写进Faculty；
 * 单独设置这个class用于【被Faculty委派】从而实现学习！
 * Student在这里仅仅作为一个【Faculty学习时的角色】；
 * 注意不能把Student当成另一个Faculty!!!
 */

public class Student implements Students
{
    private Faculty studentFaculty;

    public Student(Faculty studentFaculty)
    {
        this.studentFaculty = studentFaculty;
    }

    @Override
    public void studying()
    {
        System.out.println(studentFaculty.getName() + " is pursuing a degree!");

    }
}
