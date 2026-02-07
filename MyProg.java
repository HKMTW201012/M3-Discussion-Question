public class MyProg
{
    public static void main(String[] args)
    {
        Dean dean = new Dean(20);

        //多态！
        //动态绑定！
        School CS = new SE();
        School SOB1 = new SOB();

        Faculty faculty_1 = new Faculty("Wang", 10, CS);
        Faculty secretaryFaculty = new Faculty("Junjun", 3, SOB1);
        AdminStaff staff_1 = new AdminStaff("Sun", 5);

        Behrend be = new Behrend();

        //Dean帮忙授课【委派】
        dean.setTeachDelegate(faculty_1);
        dean.helpTeach();

        //Dean帮忙工作【委派】
        dean.setWorkDelegate(staff_1);
        dean.helpWork();

        dean.signing(); //Dean自己签字！！！

        //When Dean out sick,
        //Certain faculty signs via FacultySigner (faculty itself NOT DocSign)
        dean.setSignDelegate(new SeniorFaculty(secretaryFaculty));
        dean.signing();

        dean.manage(); //Dean自己管理！！！

        dean.setManageDelegate(new SeniorAdmin(staff_1));
        dean.helpManage(); //Dean委派VP管理！！！

        faculty_1.setStudyDelegate(new Student(faculty_1));
        faculty_1.purseDegree("Software Engineering!");

        /**
         * be
         *
         * 这是一个 Behrend 对象（校区层级）。
         *
         * be.getBoard()
         *
         * 调用 Behrend 的 getBoard() 方法
         *
         * 返回 PublicBoard theBoard
         *
         * 含义：拿到 Behrend 的“公告栏/公告板”。
         *
         * .theSubscribers(...)
         *
         * 在拿到的 PublicBoard 上调用 theSubscribers(Subscriber s) 方法
         *
         * 这个方法的作用：把一个订阅者加入订阅列表
         *
         * 这里的作用是：让 faculty_1 这个老师开始订阅 Behrend 的公告栏！！！
         */
        be.getBoard().addSubscribers(new FacultySubscriber(faculty_1)); //先订阅公告栏
        be.announceJobToAllStudents("New internship available!"); //再发布

    }
}
