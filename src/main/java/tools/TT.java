package tools;

/**
 * Created by chj on 2016/3/21.
 */
public class TT {

    public static void foo(final Object a)
    {
        Thread b=new Thread(new Runnable()
        {
            @Override
            public void run() {
                System.out.println(a);
            }
        });

        b.start();
    }

    public static void TestFoo()
    {
        foo(3);
    }

    public static void main(String [] args)
    {

       class  mThread extends Thread
        {

            @Override
            public void run() {
                foo(this);
            }

            @Override
            public String toString() {
                return this.getId()+"";
            }
        };

        mThread a=new mThread();

        mThread b=new mThread();
        mThread c=new mThread();

        a.start();
        b.start();
        c.start();

    }
}

