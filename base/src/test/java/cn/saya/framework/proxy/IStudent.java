package cn.saya.framework.proxy;

/**
 * @Title: IStudent
 * @ProjectName Spring-Boot-Framework
 * @Description: TODO
 * @Author liunengkai
 * @Date: 2019-03-17 13:25
 * @Description:
 * 学生接口
 */

public interface IStudent {

    /**
     * @描述 学生缴费
     * @参数 name
     * @返回值
     * @创建人  saya.ac.cn-刘能凯
     * @创建时间  2019-03-17
     * @修改人和其它信息
     */
    public void pay(String name);

    /**
     * @描述 学生注册
     * @参数  name
     * @返回值  void
     * @创建人  saya.ac.cn-刘能凯
     * @创建时间  2019-03-17
     * @修改人和其它信息
     */
    public void register(String name);

}
