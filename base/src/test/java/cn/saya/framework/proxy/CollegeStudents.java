package cn.saya.framework.proxy;

/**
 * @Title: CollegeStudents
 * @ProjectName Spring-Boot-Framework
 * @Description: TODO
 * @Author liunengkai
 * @Date: 2019-03-17 13:29
 * @Description:
 * 大学生类
 */

public class CollegeStudents implements IStudent {

    /**
     * @描述 学生缴费
     * @参数 name
     * @返回值
     * @创建人 saya.ac.cn-刘能凯
     * @创建时间 2019-03-17
     * @修改人和其它信息
     */
    @Override
    public void pay(String name) {
        System.out.println(name + "办理学费缴纳业务");
    }

    /**
     * @描述 学生注册
     * @参数 name
     * @返回值 void
     * @创建人 saya.ac.cn-刘能凯
     * @创建时间 2019-03-17
     * @修改人和其它信息
     */
    @Override
    public void register(String name) {
        System.out.println(name + "办理学籍注册业务");
    }
}
