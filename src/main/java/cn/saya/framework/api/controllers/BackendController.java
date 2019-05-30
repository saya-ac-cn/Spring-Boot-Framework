package cn.saya.framework.api.controllers;

import cn.saya.framework.api.entity.LogEntity;
import cn.saya.framework.api.entity.PandaEntity;
import cn.saya.framework.api.entity.UserEntity;
import cn.saya.framework.api.service.impl.BackendService;
import cn.saya.framework.api.tools.Result;
import cn.saya.framework.api.tools.ResultUtil;
import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/api/backend")
public class BackendController {

    @Autowired
    @Qualifier("backendService")
    private BackendService backendService;

    /**使用RocketMq的生产者*/
    @Autowired
    private DefaultMQProducer defaultMQProducer;

    @GetMapping(value = "/log")
    public Result<LogEntity> showLog() throws Exception
    {
        Gson gson = new Gson();
        return ResultUtil.success(gson.toJson(backendService.findLogAll()));
    }

    @GetMapping(value = "/mq")
    public Result<String> send() throws Exception
    {
        StringBuffer sbr = new StringBuffer();
        UserEntity user  = new UserEntity("茜茜",18,"女");
        Message message = new Message("demo-topic", "demo-tag", JSON.toJSONString(user).getBytes());
        SendResult result = defaultMQProducer.send(message);
        sbr.append("发送了消息" + result+"\n");

        PandaEntity panda = new PandaEntity("虎子", 5);
        Message pandaMessage = new Message("saya", "saya", JSON.toJSONString(panda).getBytes());
        SendResult animalResult =  defaultMQProducer.send(pandaMessage);
        sbr.append("发送了消息" +animalResult +"\n");

        defaultMQProducer.shutdown();
        sbr.append("producer shutdown!");
        return ResultUtil.success(sbr.toString());
    }
}
