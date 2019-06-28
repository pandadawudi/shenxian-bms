package cn.panjin.shenxianbms.tool.id;

import org.springframework.context.annotation.Configuration;

import java.util.Random;
import java.util.UUID;

/**
 * <p>
 * UUID生成器
 * </p>
 *
 * @Anthor panjin
 * @Description
 * @Date 2019/6/28 0028 14:20
 * @Version 1.0
 */
@Configuration
public class UuidWorker {

    public Long nextId(){
        int randNo= UUID.randomUUID().toString().hashCode();
        if (randNo < 0) {
            randNo=-randNo;
        }
        return Long.valueOf(randNo);
    }
}
