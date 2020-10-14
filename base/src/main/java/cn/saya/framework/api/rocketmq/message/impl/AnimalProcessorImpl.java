package cn.saya.framework.api.rocketmq.message.impl;

import cn.saya.framework.api.entity.PandaEntity;
import cn.saya.framework.api.rocketmq.message.MessageProcessor;
import org.springframework.stereotype.Service;

/**
 * @Title: AnimalProcessorImpl
 * @ProjectName Spring-Boot-Framework
 * @Description: TODO
 * @Author liunengkai
 * @Date: 2019-05-29 21:52
 * @Description:
 */
@Service
public class AnimalProcessorImpl implements MessageProcessor<PandaEntity> {

    @Override
    public boolean handleMessage(PandaEntity message) {
        System.out.println("animal receive:" + message.toString());
        return true;
    }

    @Override
    public Class<PandaEntity> getClazz() {
        return PandaEntity.class;
    }
}
