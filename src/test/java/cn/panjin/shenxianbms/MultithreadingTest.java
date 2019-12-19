package cn.panjin.shenxianbms;


import cn.panjin.shenxianbms.multithreading.create.NewRunnable;
import cn.panjin.shenxianbms.multithreading.synchronizedmap.Entity;
import cn.panjin.shenxianbms.multithreading.synchronizedmap.SynchronizedTest;
import cn.panjin.shenxianbms.multithreading.simulation.NetworkTicket;
import cn.panjin.shenxianbms.multithreading.simulation.RailwayStationTicket;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.RequestParam;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MultithreadingTest {

    @Autowired
    private NewRunnable newRunnable;


    /**
     * 测试多线程抛出异常
     */
    @Test
    public void test1(){
        newRunnable.testRunnableThrowException();
    }

    /**
     * Synchronized关键字测试：非静态方法锁当前实例
     * 结果：
     * 线程[线程1]获得锁，运行
     * 线程[线程10]获得锁，运行
     * 线程[线程2]获得锁，运行
     * 线程[线程3]获得锁，运行
     * 线程[线程4]获得锁，运行
     * 线程[线程9]获得锁，运行
     * 线程[线程5]获得锁，运行
     * 线程[线程6]获得锁，运行
     * 线程[线程7]获得锁，运行
     * 线程[线程8]获得锁，运行
     */
    @Test
    public void test2() {
        SynchronizedTest synchronizedTest = new SynchronizedTest();
        int count = 0;
        for(int i = 0; i < 10; i++){
            count++;
            new Thread(synchronizedTest, "线程" + count).start();
        }
    }


    @Test
    public void test3(){
        for(int i = 0; i < 100; i++){
            SynchronizedTest synchronizedTest = new SynchronizedTest();
            new Thread(synchronizedTest).start();
        }
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

    /**
     * 存在Thread.sleep(300)输出以下：
     *  start to execute ---
     *  finish to execute----
     *  the final value is:true
     *
     *  the final value is:true
     *  start to execute ---
     *  finish to execute----
     *
     * @throws InterruptedException
     */

    @Test
    public void test6() throws InterruptedException {
        Entity entity = new Entity();
        entity.start();
        Thread.sleep(300);
        entity.isRun(true);
        System.out.println("the final value is:" + entity.getRun());
    }
}
