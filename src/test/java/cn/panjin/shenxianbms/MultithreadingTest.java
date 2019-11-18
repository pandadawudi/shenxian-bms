package cn.panjin.shenxianbms;


import cn.panjin.shenxianbms.multithreading.create.NewRunnable;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MultithreadingTest {

    @Autowired
    private NewRunnable newRunnable;

    /**
     * 测试多线程抛出异常
     */
    @Test
    public void test(){
        newRunnable.testRunnableThrowException();
    }
}
