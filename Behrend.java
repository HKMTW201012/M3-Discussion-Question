public class Behrend
{
    //定义一个新字段，类型是PublicBoard;
    //意思是：Behrend校区有一个公告栏！！！
    private final PublicBoard theBoard = new PublicBoard();

    //Behrend对外提供一个“只读访问”公告栏的【方法】！！！
    //外部对象只能！！！订阅，或者发布信息！！！
    public PublicBoard getBoard()
    {
        return theBoard;
    }

    //这是用于向全部订阅者发布信息的方法！！！
    public void announceJobToAllStudents(String message)
    {
        //调用PublicBoard的post方法！！！
        theBoard.post(message);
    }
}
