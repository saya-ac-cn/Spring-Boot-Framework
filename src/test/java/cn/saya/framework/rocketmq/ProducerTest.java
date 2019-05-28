package cn.saya.framework.rocketmq;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import java.util.Scanner;
/**
 * @Title: ProducerTest
 * @ProjectName Spring-Boot-Framework
 * @Description: TODO
 * @Author liunengkai
 * @Date: 2019-04-08 23:12
 * @Description:
 * 服务启动参数：
 * nohup sh bin/mqnamesrv &
 * nohup sh bin/mqbroker -n localhost:9876 -c conf/broker.conf autoCreateTopicEnable=true &
 * 服务日志查看：
 * tail -f ~/logs/rocketmqlogs/namesrv.log
 * tail -f ~/logs/rocketmqlogs/broker.log
 * 关闭服务
 * sh bin/mqshutdown broker
 * sh bin/mqshutdown namesrv
 */

public class ProducerTest {

    /**
     * nohup sh mqbroker -n localhost:9876 autoCreateTopicEnable=true &
     * @param args
     * @throws MQClientException
     */
    public static void main(String[] args) throws MQClientException {
        DefaultMQProducer producer = new DefaultMQProducer("my-group");
        producer.setNamesrvAddr("120.132.116.155:9876");
        producer.setInstanceName("rmq-instance");
        producer.start();
        try {
            Message message = new Message("demo-topic", "demo-tag", "这是一条测试消息".getBytes());
            producer.send(message);

            while (true) {
                String text = new Scanner(System.in).next();
                Message msg = new Message("demo-topic",// topic
                        "demo-tag",// tag
                        text.getBytes() // body
                );
                SendResult sendResult = producer.send(msg);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        producer.shutdown();
    }

}
