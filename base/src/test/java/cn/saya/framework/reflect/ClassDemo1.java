package cn.saya.framework.reflect;


import org.junit.Test;

/**
 * Created by IntelliJ IDEA.
 * User: saya
 * Date: 2017/9/3
 * Time: 下午3:07
 * To change this template use File | Settings | File Templates.
 */

class Pandora{

    public Pandora() {
    }

    void print(){
        System.out.println("调用打印方法");
    }
}

public class ClassDemo1 {

    @Test
    public void saya(){

        //Pandora的实例对象如何表示
        Pandora pandora1 = new Pandora();//foo1就表示出来了.
        //Pandora这个类 也是一个实例对象，Class类的实例对象,如何表示呢
        //任何一个类都是Class的实例对象，这个实例对象有三种表示方式

        //第一种表示方式--->实际在告诉我们任何一个类都有一个隐含的静态成员变量class
        Class c1 = Pandora.class;

        //第二中表达方式  已经知道该类的对象通过getClass方法
        Class c2 = pandora1.getClass();

		/*官网 c1 ,c2 表示了Pandora类的类类型(class type)
		 * 万事万物皆对象，
		 * 类也是对象，是Class类的实例对象
		 * 这个对象我们称为该类的类类型
		 *
		 */

        //不管c1  or c2都代表了Pandora类的类类型，一个类只可能是Class类的一个实例对象
        System.out.println(c1 == c2);

        //第三种表达方式
        Class c3 = null;
        try {
            c3 = Class.forName("cn.saya.framework.reflect.Pandora");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(c2==c3);

        // 第四种
        Class c4 = null;
        ClassLoader classLoader = this.getClass().getClassLoader();
        try {
            c4 = classLoader.loadClass("cn.saya.framework.reflect.Pandora");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(c4==c3);

        //我们完全可以通过类的类类型创建该类的对象实例---->通过c1 or c2 or c3创建Pandora的实例对象
        try {
            Pandora foo = (Pandora)c1.newInstance();//需要有无参数的构造方法，否则异常
            foo.print();
        } catch (InstantiationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


}
