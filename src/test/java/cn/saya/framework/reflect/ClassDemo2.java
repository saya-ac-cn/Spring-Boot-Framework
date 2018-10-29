package cn.saya.framework.reflect;

import org.junit.Test;

/**
 * Created by IntelliJ IDEA.
 * User: saya
 * Date: 2017/9/3
 * Time: 下午3:34
 * To change this template use File | Settings | File Templates.
 */
public class ClassDemo2 {

    @Test
    public void saya()
    {
        Class c1 = int.class;//int 的类类型
        Class c2 = String.class;//String类的类类型   String类字节码（自己发明的)
        Class c3 = double.class;
        Class c4 = Double.class;
        Class c5 = void.class;

        System.out.println(c1.getName());//获取类名
        System.out.println(c1.getSimpleName());//不包含包名的类的名称
        System.out.println(c2.getName());
        System.out.println(c2.getSimpleName());//不包含包名的类的名称
        System.out.println(c5.getName());
    }

}
