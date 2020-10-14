package cn.saya.framework.reflect;

import org.junit.Test;

/**
 * Created by IntelliJ IDEA.
 * User: saya
 * Date: 2017/9/3
 * Time: 下午3:38
 * To change this template use File | Settings | File Templates.
 */
public class ClassDemo3 {

    @Test
    public void saya()
    {
        String s = "hello";
        System.out.println("-------------打印类的基本信息以及该类的所有方法-------------");
        ClassUtil.printClassMethodMessage(s);
        System.out.println("-------------获取成员变量的信息-------------");
        ClassUtil.printFieldMessage(s);
        System.out.println("-------------打印对象的构造函数的信息-------------");
        ClassUtil.printConMessage(s);

        Integer n1 = 1;
        System.out.println("-------------打印类的基本信息以及该类的所有方法-------------");
        ClassUtil.printClassMethodMessage(n1);
        System.out.println("-------------获取成员变量的信息-------------");
        ClassUtil.printFieldMessage(n1);
        System.out.println("-------------打印对象的构造函数的信息-------------");
        ClassUtil.printConMessage(n1);
    }

}
