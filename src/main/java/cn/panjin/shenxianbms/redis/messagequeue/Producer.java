package cn.panjin.shenxianbms.redis.messagequeue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * <p>
 * redis消息队列生产者
 * 生产者消费者模式：生产者生产消息放到队列里，多个消费者同时监听队列，谁先抢到消息谁就会从队列中取走消息；
 *     即对于每个消息只能被最多一个消费者拥有。
 *     所以：只有一个消费者将获得消息
 *           生产者不需要在接收者消费该消息期间处于运行状态，接收者也同样不需要在消息发送时处于运行状态。
 *           每一个成功处理的消息都由接收者签收
 *     总结：这种消息队列本质就是redis的list数据类型，可以不要看做MQ那种消息队列
 * </p>
 *
 * @Anthor panjin
 * @Description
 * @Date 2019/7/24 0024 14:49
 * @Version 1.0
 */
@Component
public class Producer {

    @Autowired
    private RedisTemplate redisTemplate;

    private static String QUEUE_KEY = "my-queue";

    /**
     * 生产消息方法
     */
    public void ProductMessage(){
        Date date = new Date();
        for (int i = 0; i < 10; i++) {
            redisTemplate.opsForList().leftPush(QUEUE_KEY, "这是第" + i + "个消息，时间：" + date);
        }
    }
}
