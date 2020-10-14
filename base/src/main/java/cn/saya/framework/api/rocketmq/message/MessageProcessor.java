package cn.saya.framework.api.rocketmq.message;
import cn.saya.framework.api.tools.JsonUtil;
import org.apache.rocketmq.common.message.MessageExt;
/**
 * @Title: MessageProcessor
 * @ProjectName Spring-Boot-Framework
 * @Description: TODO
 * @Author liunengkai
 * @Date: 2019-05-29 21:16
 * @Description:
 *  MessageProcessor消息处理接
 */

public interface MessageProcessor<T> {

    public boolean handleMessage(T message);

    public Class<T> getClazz();

    public default T transferMessage(String message) {
        return JsonUtil.fromJson(message, getClazz());
    }

}