import java.util.*;
import java.io.*;


// One way of creating threads is my extending the Thread class (not recommended)
// This is not recommended since it prevents us from inheriting any other class (Java restircs mutiple inheritance)
class Greet extends Thread
{
    public void sayhi()
    { System.out.println("Hi"); }

    @Override
    public void run()
    {
        for(int i=1;i<=100;i++)
        {
            sayhi();
            
        }
    }

}

class AnotherGreet extends Thread
{
    public void sayhello()
    { System.out.println("Hello"); }

    @Override
    public void run()
    {
        for(int i=1;i<=100;i++)
            sayhello();
    }

}

// Another (recommended) way of creating threds is by implementing the Runnable interface
class Wish implements Runnable
{

    public void saygoodmorning()
    { System.out.println("Good Morning!"); }
    
    @Override
    public void run()
    {
        for(int i=1;i<=100;i++)
            saygoodmorning();
    }
}

class WishAgain implements Runnable
{
    public void saygoodnight()
    { System.out.println("Good Night"); }

    @Override
    public void run()
    {
        for(int i=1;i<=100;i++)
            saygoodnight();
    }
}


public class CreatingThreads {
    public static void main(String[] args) {

        Greet obj=new Greet();
        AnotherGreet obj2=new AnotherGreet();
        Runnable obj3=new Wish();
        Runnable obj4=new WishAgain();
        Thread t3=new Thread(obj3);
        Thread t4=new Thread(obj4);

        var tname=obj.getName();
        System.out.println(tname);

        var tname2=obj2.getName();
        System.out.println(tname2);

        obj.start();
        obj2.start();

        // System.out.print("\033[H\033[2J");

        var tname3=t3.getName();
        System.out.println(tname3);

        var tname4=t4.getName();
        System.out.println(tname4);

        t3.start();
        t4.start();

    }    
}
