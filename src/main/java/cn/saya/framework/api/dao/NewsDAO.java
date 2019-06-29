package cn.saya.framework.api.dao;

import cn.saya.framework.api.entity.NewsEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @Title: NewsDAO
 * @ProjectName Spring-Boot-Framework
 * @Description: TODO
 * @Author liunengkai
 * @Date: 2019-06-29 10:03
 * @Description:
 * 动态持久层
 */
@Mapper
@Repository("newsDAO")
public interface NewsDAO extends BaseMapper<NewsEntity> {
}
