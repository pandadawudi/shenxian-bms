package cn.panjin.shenxianbms.redis.publishsubscribe;

import cn.panjin.shenxianbms.model.adapter.HuaWeiTool;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 另外一个消息接收
 * </p>
 *
 * @Anthor panjin
 * @Description
 * @Date 2019/7/30 0030 9:57
 * @Version 1.0
 */
@Component
public class ReceiverOther {

    /**
     * 接收消息
     *
     * @param message
     */
    public void receiveMessageOther(String message) {
        System.out.println(message);
    }
}
