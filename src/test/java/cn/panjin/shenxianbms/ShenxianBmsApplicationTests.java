package cn.panjin.shenxianbms;

import cn.panjin.shenxianbms.base.user.dao.BaseUserMapper;
import cn.panjin.shenxianbms.base.user.entity.BaseUser;
import cn.panjin.shenxianbms.tool.id.UuidWorker;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShenxianBmsApplicationTests {

    @Autowired
    private UuidWorker uuidWorker;

    @Autowired
    private RedisTemplate redisTemplate;

    @Resource
    private BaseUserMapper baseUserMapper;

    @Test
    public void contextLoads() {
    }

    @Test
    public void getIdTest(){
        System.out.println("e");
        System.out.println("df");
    }
}
