package cn.saya.framework.reflect;

import java.lang.reflect.Method;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: saya
 * Date: 2017/9/3
 * Time: 下午4:13
 * To change this template use File | Settings | File Templates.
 */
public class MethodDemo2 {



    //这里有控制台输入所以不能用Junit测试
    public static void main(String [] arg)
    {
        UserService us = new UserService();
		/*
		 * 通过键盘输入命令执行操作
		 * 输入update命令就调用update方法
		 * 输入delete命令就调用delete方法
		 * ...
		 */
        try {
            Scanner input=new Scanner(System.in);
            System.out.println("请输入命令:");
            String action =input.nextLine();
			/*
			 * action就是方法名称， 都没有参数--->通过方法的反射操作就会简单很多
			 * 通过方法对象然后进行反射操作
			 */
            Class c = us.getClass();
            Method m = c.getMethod(action); //原方法是无参的，只传方法名即可
            m.invoke(us);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
