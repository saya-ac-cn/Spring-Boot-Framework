package cn.saya.framework.api.rocketmq.message.impl;

import cn.saya.framework.api.entity.UserEntity;
import cn.saya.framework.api.rocketmq.message.MessageProcessor;
import org.springframework.stereotype.Service;

/**
 * @Title: UserProcessorImpl
 * @ProjectName Spring-Boot-Framework
 * @Description: TODO
 * @Author liunengkai
 * @Date: 2019-05-29 21:51
 * @Description:
 * MessageProcessor实现类
 */
@Service
public class UserProcessorImpl implements MessageProcessor<UserEntity> {

    @Override
    public boolean handleMessage(UserEntity message) {
        System.out.println("user receive : " + message.toString());
        return true;
    }

    @Override
    public Class<UserEntity> getClazz() {
        return UserEntity.class;
    }
}
