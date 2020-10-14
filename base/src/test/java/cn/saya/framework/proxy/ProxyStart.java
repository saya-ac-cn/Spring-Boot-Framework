package cn.saya.framework.proxy;

import org.junit.Test;

import java.lang.reflect.Proxy;

/**
 * @Title: ProxyStart
 * @ProjectName Spring-Boot-Framework
 * @Description: TODO
 * @Author liunengkai
 * @Date: 2019-03-17 13:42
 * @Description:
 */

public class ProxyStart {

    public static void consumer(IStudent student){
        student.pay("saya");
        student.register("saya");
    }

    @Test
    public void go(){
        CollegeStudents student = new CollegeStudents();
        consumer(student);

        System.out.println("/*******************************/");

        /**
         * 通过调用静态方法Proxy.newProxyInstance()可以创建动态代理。这个方法需要得到一个类
         * 加载器（你通常可以从已经被加载的对象中获取其类加载器，然后传递给它），一个你希望该代
         * 理实现的接口列表（不是类或者抽象类），以及InvocationHandler接口的一个实现。动态代理可以
         * 将所有调用重定向到调用处理器，因此通常会向调用处理器的构造器传递一个“实际”对象的引用，从而
         * 使得调用处理器执行其中介任务时，可以将请求转发。
         */
        IStudent proxy = (IStudent) Proxy.newProxyInstance(
                IStudent.class.getClassLoader(),
                new Class[]{IStudent.class},
                new DynamicProxyHandler(student));

        consumer(proxy);

    }

}
