package cn.saya.framework.thread;

import org.junit.Test;

/**
 * @Title: Thread_1_
 * @ProjectName Spring-Boot-Framework
 * @Description: TODO
 * @Author Saya
 * @Date: 2018/10/13 22:50
 * @Description:
 */

public class Thread_1_ implements Runnable {

    private Integer ticket = 10;

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
     * run()就和普通的成员方法一样，可以被重复调用。单独调用run()的话，会在当前线程中执行run()，而并不会启动新线程！
     */
    @Override
    public void run() {
        for(int i=0;i<20;i++){
            if(this.ticket>0){
                System.out.println(Thread.currentThread().getName()+" 卖票：ticket"+this.ticket--);
            }
        }
    }

    @Test
    public void threadRun()
    {
        Thread_1_ thread = new Thread_1_();
        Thread thread1 = new Thread(thread);
        Thread thread2 = new Thread(thread);
        Thread thread3 = new Thread(thread);
        thread1.start();
        thread2.start();
        thread3.start();//启动一个新线程，新线程会执行相应的run()方法。start()不能被重复调用。
        //thread3.run();//会直接在当前线程中运行run()方法，并不会启动一个新线程来运行run()。
    }

}
