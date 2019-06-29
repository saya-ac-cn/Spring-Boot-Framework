package cn.saya.framework.api.dao;

import cn.saya.framework.api.entity.LogEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


import java.util.List;

@Mapper
@Repository("logDAO")
public interface LogDAO {

    public List<LogEntity> findAll();

}
