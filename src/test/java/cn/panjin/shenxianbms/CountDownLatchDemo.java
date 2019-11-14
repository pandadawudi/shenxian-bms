package cn.panjin.shenxianbms;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <p>
 * 倒计时器示例：
 * 上述代码中我们先生成了一个CountDownLatch实例。计数数量为10，这表示需要有10个线程来完成任务，
 * 等待在CountDownLatch上的线程才能继续执行。latch.countDown();方法作用是通知CountDownLatch
 * 有一个线程已经准备完毕，倒计数器可以减一了。latch.await()方法要求主线程等待所有10个检查任务
 * 全部准备好才一起并行执行。
 * </p>
 *
 * @Anthor panjin
 * @Description
 * @Date 2019/7/29 0029 9:28
 * @Version 1.0
 */
public class CountDownLatchDemo implements Runnable{
    static final CountDownLatch latch = new CountDownLatch(10);
    static final CountDownLatchDemo demo = new CountDownLatchDemo();

    @Override
    public void run() {
        // 模拟检查任务
        try {
            Thread thread = Thread.currentThread();
            System.out.println("进入线程，线程ID为：" + thread.getId() + ",线程名称：" + thread.getName());
            int time = new Random().nextInt(10) * 1000;
            System.out.println("time=" + time);
            Thread.sleep(time);
            System.out.println("线程" + thread.getName() + ",check complete");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            //计数减一
            //放在finally避免任务执行过程出现异常，导致countDown()不能被执行
            latch.countDown();
        }
    }


    public static void main(String[] args) throws InterruptedException {
        //创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待
        ExecutorService exec = Executors.newFixedThreadPool(10);
        for (int i=0; i<10; i++){
            exec.submit(demo);
        }

        // 等待检查
        latch.await();

        // 发射火箭
        System.out.println("Fire!");
        // 关闭线程池
        exec.shutdown();
    }
}
