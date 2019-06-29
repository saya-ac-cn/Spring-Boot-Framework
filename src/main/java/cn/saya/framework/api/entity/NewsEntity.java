package cn.saya.framework.api.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @Title: NewsEntity
 * @ProjectName DataCenter
 * @Description: TODO
 * @Author Saya
 * @Date: 2019/1/11 21:14
 * @Description:
 * 动态实体类
 * Mybatis-plus默认使用实体名作为mysql表
 * 可以额外指定
 */
@TableName(value = "news")
public class NewsEntity{

    /**
     * 编号
     * @@TableId :
     *      value:指定表中的主键列的列名，如果字段和实体名一致，则可以忽略，采用驼峰命名
     *      type：指定主键策略
     */
    @TableId(value="id",type = IdType.AUTO)
    private Integer id;

    /**
     * 主题
     */
    @TableField(value = "topic")
    private String topic;

    /**
     * 标签
     */
    private String label;

    /**
     * 正文
     */
    private String content;

    /**
     * 作者
     */
    private String source;

    /**
     * 创建时间
     */
    private String createtime;

    /**
     * 修改时间
     */
    private String updatetime;

    /**
     * 序列号
     * 不是本表的字段，即，插入记录时，本属性不会作为值插入到表中
     */
    @TableField(exist = false)
    private String seqNo;

    public NewsEntity() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }
}
