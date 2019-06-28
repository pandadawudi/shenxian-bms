package cn.panjin.shenxianbms.config.id;

import cn.panjin.shenxianbms.tool.id.SnowWorker;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>
 * 配置类
 * </p>
 *
 * @Anthor panjin
 * @Description
 * @Date 2019/6/27 0027 15:44
 * @Version 1.0
 */
@Configuration
public class SnowId {

    /**
     * 当前机器id
     */
    @Value("${snow.worker.workerId}")
    private long workerId;


    /**
     * 序列号
     */
    @Value("${snow.worker.dataCenterId}")
    private long dataCenterId;


    @Bean
    public SnowWorker idWorker() {
        return new SnowWorker(workerId, dataCenterId);
    }
}
