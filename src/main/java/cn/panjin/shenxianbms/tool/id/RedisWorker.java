package cn.panjin.shenxianbms.tool.id;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.UUID;

/**
 * <p>
 * Redis主键生成器
 * </p>
 *
 * @Anthor panjin
 * @Description
 * @Date 2019/6/28 0028 11:44
 * @Version 1.0
 */
@Configuration
public class RedisWorker {

    @Autowired
    private RedisTemplate redisTemplate;

    @Value("${spring.redis.keyId}")
    private String key;

    @Value("${spring.redis.delta}")
    private Long delta;

    /**
     * 获取唯一Id
     * @param key
     * @param delta 增加量（不传采用1）
     * @return
     * @throws
     */
    public Long increment(String key,Long delta){
        try {
            if (null == delta) {
                delta = 1L;
            }
            return redisTemplate.opsForValue().increment(key, delta);
        } catch (Exception e) {//redis宕机时采用uuid的方式生成唯一id
            UuidWorker uuidWorker = new UuidWorker();
            return uuidWorker.nextId();
        }
    }

    /**
     * 获取下一个id
     * @return
     * @throws
     */
    public Long nextId(){
        return  this.increment(key, delta);
    }

}
