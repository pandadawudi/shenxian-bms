package cn.panjin.shenxianbms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("cn.panjin.shenxianbms.**.mapper")
@SpringBootApplication
public class ShenxianBmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShenxianBmsApplication.class, args);
    }

}
