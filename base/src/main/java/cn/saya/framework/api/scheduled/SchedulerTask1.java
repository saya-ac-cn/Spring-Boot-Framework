package cn.saya.framework.api.scheduled;

import org.apache.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @Title: SchedulerTask1
 * @ProjectName Spring-Boot-Framework
 * @Description: TODO
 * @Author Saya
 * @Date: 2018/10/10 21:56
 * @Description:
 * 定时任务1
 */
@Component
public class SchedulerTask1 {

    private static final Logger logger = Logger.getLogger(SchedulerTask1.class);

    private int count=0;

    @Scheduled(cron="*/6 * * * * ?")
    private void process(){
        logger.error("this is scheduler task runing  "+(count++));
    }

}
