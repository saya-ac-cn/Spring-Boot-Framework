package cn.saya.framework.api.entity;

/**
 * @Title: ItemLineEntity
 * @ProjectName Spring-Boot-Framework
 * @Description: TODO
 * @Author Saya
 * @Date: 2018/10/18 21:31
 * @Description:
 */

public class ItemLineEntity {

    private String storeName;// 药店名
    private String startTime;// 开始时间
    private String endTime;//结束时间
    private Double price;//单价

    public ItemLineEntity() {
        super();
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

}
