package cn.saya.framework;


import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class FrameworkApplicationTests {


	@Test
	public void contextLoads() {
		System.out.println("启动");
	}

	/**使用RocketMq的生产者*/
	@Autowired
	private DefaultMQProducer defaultMQProducer;

	@Test
	public void send() throws MQClientException, MQBrokerException, RemotingException, InterruptedException{
		String msg = "demo msg test";
		System.out.println("开始发送消息："+msg);
		Message sendMsg = new Message("demo-topic","demo-tag",msg.getBytes());
		//默认3秒超时
		SendResult sendResult = defaultMQProducer.send(sendMsg);
		System.out.println("消息发送响应信息："+sendResult.toString());
	}

}
