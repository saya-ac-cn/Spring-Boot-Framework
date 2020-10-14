package cn.saya.framework.reflect;

/**
 * Created by IntelliJ IDEA.
 * User: saya
 * Date: 2017/9/3
 * Time: 下午4:49
 * To change this template use File | Settings | File Templates.
 */
public class User {

    private String username;
    private String userpass;
    private int age;
    public User(){}

    public User(String username, String userpass, int age) {
        super();
        this.username = username;
        this.userpass = userpass;
        this.age = age;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getUserpass() {
        return userpass;
    }
    public void setUserpass(String userpass) {
        this.userpass = userpass;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

}
