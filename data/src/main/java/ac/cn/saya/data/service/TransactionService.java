package ac.cn.saya.data.service;

import ac.cn.saya.data.dao.first.LogDAO;
import ac.cn.saya.data.dao.second.NewsDAO;
import ac.cn.saya.data.entity.LogEntity;
import ac.cn.saya.data.entity.NewsEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @Title: TransactionService
 * @ProjectName Spring-Boot-Framework
 * @Description: TODO
 * @Author liunengkai
 * @Date: 2/18/21 22:57
 * @Description:
 */
@Service
public class TransactionService {

    @Resource
    private NewsDAO newsDAO;

    @Resource
    private LogDAO logDAO;

    @Transactional
    public void tx() {
        NewsEntity news = new NewsEntity();
        news.setTopic("分布式事务联合测试");
        news.setContent("分布式事务联合测试");
        news.setLabel("分布式");
        news.setSource("Pandora");
        // 修改业务库中的数据
        newsDAO.insertNews(news);
        if(false){
            throw new RuntimeException();
        }
        // 修改主库中的数据
        LogEntity log = new LogEntity("Pandora", "OX007", "127.0.0.1", "本机地址", "2021-02-21 00:00:00");
        logDAO.insert(log);
    }


}
