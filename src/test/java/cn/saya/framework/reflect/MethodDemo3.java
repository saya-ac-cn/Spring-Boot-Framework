package cn.saya.framework.reflect;

import org.junit.Test;

/**
 * Created by IntelliJ IDEA.
 * User: saya
 * Date: 2017/9/3
 * Time: 下午4:50
 * To change this template use File | Settings | File Templates.
 */
public class MethodDemo3 {

    @Test
    public void saya()
    {
        User u1 = new User("zhangsan", "123456", 30);
        System.out.println(BeanUtil.getValueByPropertyName(u1, "username"));
        System.out.println(BeanUtil.getValueByPropertyName(u1, "userpass"));
    }

}
