package cn.saya.framework.api.entity;

public class LogEntity {
    private int id;
    private String user;
    private String type;
    private String ip;
    private String city;
    private String date;

    public LogEntity() {
    }

    public LogEntity(String user, String type, String ip, String city, String date) {
        this.user = user;
        this.type = type;
        this.ip = ip;
        this.city = city;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
