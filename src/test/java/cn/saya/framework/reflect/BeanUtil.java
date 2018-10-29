package cn.saya.framework.reflect;

import java.lang.reflect.Method;

/**
 * Created by IntelliJ IDEA.
 * User: saya
 * Date: 2017/9/3
 * Time: 下午4:51
 * To change this template use File | Settings | File Templates.
 */
public class BeanUtil {

    /**
     * 根据标准javaBean对象的属性名获取其属性值
     *
     * @param obj
     * @param propertyName
     * @return
     */
    public static Object getValueByPropertyName(Object obj, String propertyName) {
        // 1.根据属性名称就可以获取其get方法
        String getMethodName = "get"
                + propertyName.substring(0, 1).toUpperCase()//方法名第一个字母大写
                + propertyName.substring(1);//截取第二个字符到最后
        //2.获取方法对象
        Class c = obj.getClass();
        try {
            //get方法都是public的且无参数
            Method m= c.getMethod(getMethodName);//getter是无参的，只传方法名即可
            //3 通过方法的反射操作方法
            Object value = m.invoke(obj);//执行getter方法
            return value;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
