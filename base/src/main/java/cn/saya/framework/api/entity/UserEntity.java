package cn.saya.framework.api.entity;

import java.io.Serializable;

/**
 * @Title: UserEntity
 * @ProjectName Spring-Boot-Framework
 * @Description: TODO
 * @Author liunengkai
 * @Date: 2019-05-29 21:49
 * @Description:
 */

public class UserEntity implements Serializable {

    private static final long serialVersionUID = 641522069439878722L;
    private String name;
    private Integer age;
    private String sex;

    public UserEntity() {
    }

    public UserEntity(String name, Integer age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }

}
