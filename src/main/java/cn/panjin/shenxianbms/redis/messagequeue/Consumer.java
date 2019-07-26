package cn.panjin.shenxianbms.redis.messagequeue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.QueryTimeoutException;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;



/**
 * <p>
 * redis消息队列消费者
 * redis消息消费是主动获取消息，如果不存在消息，则在过期时间之后报错，有则马上返回
 * </p>
 *
 * @Anthor panjin
 * @Description
 * @Date 2019/7/24 0024 15:10
 * @Version 1.0
 */
@Component
public class Consumer {

    @Autowired
    private RedisTemplate redisTemplate;

    private static String QUEUE_KEY = "my-queue";

    /**
     * 消费消息
     */
    public void consumeMessage(){
        Object messages = null;
        try {
            //这里的timeout时间和redis配置的超时时间，谁的时间短谁就生效
            messages = redisTemplate.opsForList().leftPop(QUEUE_KEY,60, TimeUnit.SECONDS);
        }catch (QueryTimeoutException exception){
            exception.printStackTrace();
            System.out.println("获取数据超时");
        }
        System.out.println(messages);
    }
}
