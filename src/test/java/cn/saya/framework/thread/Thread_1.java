package cn.saya.framework.thread;

import org.junit.Test;

/**
 * @Title: Thread_1
 * @ProjectName Spring-Boot-Framework
 * @Description: TODO
 * @Author Saya
 * @Date: 2018/10/13 22:42
 * @Description:
 */

public class Thread_1 extends Thread {

    private Integer ticket = 10;

    /**
     * If this thread was constructed using a separate
     * <code>Runnable</code> run object, then that
     * <code>Runnable</code> object's <code>run</code> method is called;
     * otherwise, this method does nothing and returns.
     * <p>
     * Subclasses of <code>Thread</code> should override this method.
     *
     * @see #start()
     * @see #stop()
     * @see #Thread(ThreadGroup, Runnable, String)
     */
    @Override
    public void run() {
        for(int i=0;i<20;i++){
            if(this.ticket>0){
                System.out.println(this.getName()+" 卖票：ticket"+this.ticket--);
                }
            }
    }

    @Test
    public void threadRun()
    {
        Thread_1 thread1 = new Thread_1();
        Thread_1 thread2 = new Thread_1();
        Thread_1 thread3 = new Thread_1();
        thread1.start();
        thread2.start();
        thread3.start();
    }

}
