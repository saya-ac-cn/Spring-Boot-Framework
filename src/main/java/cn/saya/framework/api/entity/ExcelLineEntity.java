package cn.saya.framework.api.entity;


import java.util.List;

public class ExcelLineEntity {

    private Long deviceId;// 设备ID
    private String chainName;// 连锁名
    private String storeName;// 药店名
    private Double price;//	单价
    private Integer status;// 设备状态（4为撤机）
    private String macId;//
    private Double realReceivables;// 实收款
    private String chargeTime;// 缴费月份
    private Long flowId;// 汇款单号
    private String remittanceTime;// 汇款日期
    private String remitter;// 汇款人
    private Double remittanceTotal;//汇款总金额
    private String custCode;// 客户编码
    private List<ItemLineEntity> item;//内嵌行

    public ExcelLineEntity() {
        super();
    }

    public Long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Long deviceId) {
        this.deviceId = deviceId;
    }

    public String getChainName() {
        return chainName;
    }

    public void setChainName(String chainName) {
        this.chainName = chainName;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMacId() {
        return macId;
    }

    public void setMacId(String macId) {
        this.macId = macId;
    }

    public Double getRealReceivables() {
        return realReceivables;
    }

    public void setRealReceivables(Double realReceivables) {
        this.realReceivables = realReceivables;
    }

    public String getChargeTime() {
        return chargeTime;
    }

    public void setChargeTime(String chargeTime) {
        this.chargeTime = chargeTime;
    }

    public Long getFlowId() {
        return flowId;
    }

    public void setFlowId(Long flowId) {
        this.flowId = flowId;
    }

    public String getRemittanceTime() {
        return remittanceTime;
    }

    public void setRemittanceTime(String remittanceTime) {
        this.remittanceTime = remittanceTime;
    }

    public String getRemitter() {
        return remitter;
    }

    public void setRemitter(String remitter) {
        this.remitter = remitter;
    }

    public Double getRemittanceTotal() {
        return remittanceTotal;
    }

    public void setRemittanceTotal(Double remittanceTotal) {
        this.remittanceTotal = remittanceTotal;
    }

    public String getCustCode() {
        return custCode;
    }

    public void setCustCode(String custCode) {
        this.custCode = custCode;
    }

    public List<ItemLineEntity> getItem() {
        return item;
    }

    public void setItem(List<ItemLineEntity> item) {
        this.item = item;
    }




}