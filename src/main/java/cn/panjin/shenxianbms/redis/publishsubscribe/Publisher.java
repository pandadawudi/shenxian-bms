package cn.panjin.shenxianbms.redis.publishsubscribe;

import cn.panjin.shenxianbms.config.redis.RedisConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

/**
 * <p>
 * 消息发布者
 * </p>
 *
 * @Anthor panjin
 * @Description
 * @Date 2019/7/26 0026 16:42
 * @Version 1.0
 */
@Component
public class Publisher {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private CountDownLatch countDownLatch;

    /**
     * 发布消息
     */
    public void sendMessage() throws InterruptedException {
        redisTemplate.convertAndSend("patternTopicTest", "what's your problem");
        countDownLatch.await();
    }
}
