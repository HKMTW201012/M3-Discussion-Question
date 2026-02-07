import java.util.ArrayList;
import java.util.List;

public class PublicBoard
{
    //定义一个列表
    //用于存放【所有订阅公告的对象】！！！
    //Subscriber是接口，代表【能接收公告的人】！！！
    private final List<Subscriber> subers = new ArrayList<>();

    //这个方法用于【添加订阅公告的对象】
    //对象都是【实现了Subscriber接口的对象】！！！
    //例如：RealStudent，FacultySubscriber！！！
    public void addSubscribers(Subscriber s)
    {
        //这里的作用是：
        //不可以让Subscriber是null，这样是不现实的！！！
        if(s == null)
        {
            throw new IllegalArgumentException("Subscriber must not be null");
        }

        subers.add(s); //把【订阅公告的对象】加入列表！！！
    }

    public void unsubscribe(Subscriber s)
    {
        subers.remove(s); //把【订阅公告的对象】从列表移除！！！
    }

    //这是PublicBoard发布信息的方法！！！
    public void post(String message)
    {
        System.out.println("Behrend is announcing: " + message);

        //依次遍历每一个订阅者!!!
        for(Subscriber s : subers)
        {
            //调用每一个订阅者的subscribing(message) 方法！！！
            //这里的意思是：
            //PublicBoard不管订阅者是谁！只要这个对象实现了Subscriber接口，就会收到通知！！！
            s.subscribing(message);
        }
    }
}
