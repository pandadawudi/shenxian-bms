package cn.panjin.shenxianbms.config.pagehelper;

import com.github.pagehelper.PageHelper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * <p>
 * 分页插件配置
 * </p>
 *
 * @Anthor panjin
 * @Description
 * @Date 2019/7/5 0005 11:34
 * @Version 1.0
 */
@Configuration
public class PageHelperConfig {
    @Bean
    public PageHelper pageHelper(){
        PageHelper pageHelper = new PageHelper();
        Properties properties = new Properties();
        properties.setProperty("offsetAsPageNum","true");
        properties.setProperty("rowBoundsWithCount","true");
        properties.setProperty("reasonable","true");
        properties.setProperty("dialect","mysql");//配置mysql数据库的方言
        pageHelper.setProperties(properties);
        return pageHelper;
    }
}