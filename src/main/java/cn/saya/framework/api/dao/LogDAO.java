package cn.saya.framework.api.dao;

import cn.saya.framework.api.entity.LogEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


import java.util.List;

@Mapper
@Repository("logDAO")
public interface LogDAO extends BaseMapper<LogEntity> {

    public List<LogEntity> findAll();

}
