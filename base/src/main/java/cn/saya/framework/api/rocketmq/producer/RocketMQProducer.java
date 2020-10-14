package cn.saya.framework.api.rocketmq.producer;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
/**
 * @Title: RocketMQProducer
 * @ProjectName Spring-Boot-Framework
 * @Description: TODO
 * @Author liunengkai
 * @Date: 2019-05-29 21:21
 * @Description:
 * MQ生产者配置
 */

@SpringBootConfiguration
public class RocketMQProducer {

    private static final Logger log = LoggerFactory.getLogger(RocketMQProducer.class);
    //使用Value注解加载配置文件的配置
    @Value("${rocketmq.producer.groupName}")
    private String groupName;
    @Value("${rocketmq.producer.namesrvAddr}")
    private String nameserAddr;
    @Value("${rocketmq.producer.instanceName}")
    private String instanceName;
    @Value("${rocketmq.producer.maxMessageSize}")
    private int maxMessageSize;
    @Value("${rocketmq.producer.sendMsgTimeout}")
    private int sendMsgTimeout;

    private DefaultMQProducer producer;

    @Bean
    public DefaultMQProducer getRocketMQProducer() {

        producer = new DefaultMQProducer(groupName);
        producer.setNamesrvAddr(nameserAddr);
        producer.setInstanceName(instanceName);
        producer.setMaxMessageSize(maxMessageSize);
        producer.setSendMsgTimeout(sendMsgTimeout);
        producer.setVipChannelEnabled(false);

        try {
            producer.start();
            log.info("rocketMQ is start !!groupName : {},nameserAddr:{}",groupName,nameserAddr);
        } catch (MQClientException e) {
            log.error(String.format("rocketMQ start error,{}",e.getMessage()));
            e.printStackTrace();
        }
        return producer;
    }

}
