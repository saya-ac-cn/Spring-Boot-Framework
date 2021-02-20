package ac.cn.saya.data.dao.first;

import ac.cn.saya.data.entity.LogEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Title: LogDAO
 * @ProjectName DataCenter
 * @Description: TODO
 * @Author Saya
 * @Date: 2018/9/22 22:23
 * @Description: 日志Dao
 */

@Mapper
public interface LogDAO {

    /**
     * 插入一条日志
     * 返回插入后的主键
     *
     * @param entity
     * @return
     */
    public Integer insert(LogEntity entity);

}
