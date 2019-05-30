package cn.saya.framework;


import cn.saya.framework.api.entity.PandaEntity;
import cn.saya.framework.api.entity.UserEntity;
import com.alibaba.fastjson.JSON;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.junit.Test;
import org.junit.runner.RunWith;
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


	public void sendMessage() throws InterruptedException, RemotingException, MQClientException, MQBrokerException {
		UserEntity user  = new UserEntity("茜茜",18,"女");
		Message message = new Message("demo-topic", "demo-tag", JSON.toJSONString(user).getBytes());
		SendResult result = defaultMQProducer.send(message);
		System.out.println("发送了消息" + result);

		PandaEntity panda = new PandaEntity("虎子", 5);
		Message pandaMessage = new Message("animal", "panda", JSON.toJSONString(panda).getBytes());
		SendResult animalResult =  defaultMQProducer.send(pandaMessage);
		System.out.println("发送了消息" +animalResult );

		defaultMQProducer.shutdown();
		System.out.println("producer shutdown!");
	}

}
