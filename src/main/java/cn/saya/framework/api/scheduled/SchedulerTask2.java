package cn.saya.framework.api.scheduled;

import org.apache.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Title: SchedulerTask2
 * @ProjectName Spring-Boot-Framework
 * @Description: TODO
 * @Author Saya
 * @Date: 2018/10/10 21:58
 * @Description:
 * 定时任务2
 */

@Component
public class SchedulerTask2 {

    private static final Logger logger = Logger.getLogger(SchedulerTask2.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 6000)
    public void reportCurrentTime() {
        logger.error("现在时间：" + dateFormat.format(new Date()));
    }

}
