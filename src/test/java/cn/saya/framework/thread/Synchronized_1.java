package cn.saya.framework.thread;

import org.junit.Test;

/**
 * @Title: Synchronized_1
 * @ProjectName Spring-Boot-Framework
 * @Description: TODO
 * @Author Saya
 * @Date: 2018/10/13 23:05
 * @Description:
 */

public class Synchronized_1 implements Runnable {

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        synchronized (this){
            try {
                for (Integer i = 0;i < 5;i++)
                {
                    Thread.sleep(1000);//休眠1s
                    System.out.println(Thread.currentThread().getName() + " loop" + i);
                }
            }catch (InterruptedException e)
            {

            }
        }
    }

}

class TestRun{

    public static void main(String[] args)
    {
        Synchronized_1 thread = new Synchronized_1();
        Thread thread1 = new Thread(thread,"线程A");
        Thread thread2 = new Thread(thread,"线程B");
        thread1.start();
        thread2.start();
    }
}