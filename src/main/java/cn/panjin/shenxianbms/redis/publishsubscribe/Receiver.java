package cn.panjin.shenxianbms.redis.publishsubscribe;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;


/**
 * <p>
 * 消息接收器
 * </p>
 *
 * @Anthor panjin
 * @Description
 * @Date 2019/7/26 0026 16:02
 * @Version 1.0
 */
@Component
public class Receiver {

    private static final Logger LOGGER = LoggerFactory.getLogger(Receiver.class);

    private CountDownLatch latch;

    @Autowired
    public Receiver(CountDownLatch latch) {
        this.latch = latch;
    }

    public void receiveMessage(String message) {
        LOGGER.info("Received <" + message + ">");
        System.out.println(message);
        latch.countDown();
    }
}
