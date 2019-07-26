package cn.panjin.shenxianbms;

import cn.panjin.shenxianbms.redis.messagequeue.Consumer;
import cn.panjin.shenxianbms.redis.messagequeue.Producer;
import cn.panjin.shenxianbms.redis.publishsubscribe.Publisher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * <p>
 * redis消息对列测试
 * </p>
 *
 * @Anthor panjin
 * @Description
 * @Date 2019/7/24 0024 15:23
 * @Version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisMessageQueueTest {

    @Autowired
    private Producer producer;

    @Autowired
    private Consumer consumer;

    /**
     * 测试向消息对列中发送消息
     */
    @Test
    public void sendMessage() {
        producer.ProductMessage();
    }

    /**
     * 获取消息
     */
    @Test
    public void gainMessage() {
        consumer.consumeMessage();
    }

    @Autowired
    private Publisher publisher;

    /**
     * 测试发布订阅模式
     */
    @Test
    public void testPublisher() throws InterruptedException {
        publisher.sendMessage();
    }

}
