public class MyProg
{
    public static void main(String[] args)
    {
        Dean dean = new Dean(20);
        Faculty faculty_1 = new Faculty("Wang", 10);
        Faculty sign_secretary = new Faculty("Junjun", 3);
        AdminStaff staff_1 = new AdminStaff("Sun", 5);

        dean.setTeachDelegate(faculty_1);
        dean.helpTeach();

        dean.setWorkDelegate(staff_1);
        dean.helpWork();

        dean.signing();

        dean.setSignDelegate(sign_secretary);
        dean.signing();

    }
}
