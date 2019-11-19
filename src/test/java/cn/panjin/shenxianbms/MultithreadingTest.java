package cn.panjin.shenxianbms;


import cn.panjin.shenxianbms.multithreading.create.NewRunnable;
import cn.panjin.shenxianbms.multithreading.simulation.NetworkTicket;
import cn.panjin.shenxianbms.multithreading.simulation.RailwayStationTicket;
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

    @Test
    public void test4(){
        RailwayStationTicket ticket = new RailwayStationTicket();
        for(int i = 0; i < 30; i++){
            new Thread(ticket, "线程" + i).start();
        }
    }

    /**
     * 测试网上火车售票
     */
    @Test
    public void test5(){
        // 创建票对象
        NetworkTicket ticket = new NetworkTicket();
        // 创建3个窗口
        Thread t1 = new Thread(ticket, "窗口1");
        Thread t2 = new Thread(ticket, "窗口2");
        Thread t3 = new Thread(ticket, "窗口3");
        t1.start();
        t2.start();
        t3.start();
    }
}
