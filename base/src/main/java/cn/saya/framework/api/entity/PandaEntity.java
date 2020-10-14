package cn.saya.framework.api.entity;

import java.io.Serializable;

/**
 * @Title: PandaEntity
 * @ProjectName Spring-Boot-Framework
 * @Description: TODO
 * @Author liunengkai
 * @Date: 2019-05-29 21:44
 * @Description:
 */

public class PandaEntity implements Serializable {

    private static final long serialVersionUID = 9169618509823150917L;
    private String name;
    private Integer age;

    public PandaEntity() {
    }

    public PandaEntity(String name, Integer age) {
        this.name = name;
        this.age = age;
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

    @Override
    public String toString() {
        return "Panda{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

}
