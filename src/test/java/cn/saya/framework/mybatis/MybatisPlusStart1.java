package cn.saya.framework.mybatis;

import cn.saya.framework.api.dao.NewsDAO;
import cn.saya.framework.api.entity.NewsEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Title: MybatisPlusStart1
 * @ProjectName Spring-Boot-Framework
 * @Description: TODO
 * @Author liunengkai
 * @Date: 2019-06-29 10:00
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisPlusStart1 {

    @Autowired
    @Qualifier("newsDAO")
    private NewsDAO newsDAO;

    @Test
    public void insert(){
        NewsEntity newsEntity = new NewsEntity();
        newsEntity.setContent("测试发布内容2");
        newsEntity.setLabel("mybatis-plus2");
        newsEntity.setSource("Pandora");
        newsEntity.setTopic("Mybatis-plus2");
        newsDAO.insert(newsEntity);
        // 直接从实体类中获取，无须其它繁琐的配置
        System.out.println("主键回填后的值："+newsEntity.getId());
    }

    @Test
    public void update(){
        NewsEntity newsEntity = new NewsEntity();
        newsEntity.setContent("测试修改内容");
        newsEntity.setId(1);
        newsDAO.updateById(newsEntity);
    }

}
