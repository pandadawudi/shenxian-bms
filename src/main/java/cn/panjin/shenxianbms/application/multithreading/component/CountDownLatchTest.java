package cn.panjin.shenxianbms.application.multithreading.component;

import java.util.concurrent.CountDownLatch;

/**
 * <p>
 * CountDownLatch例子
 * </p>
 *
 * @Anthor panjin
 * @Description
 * @Date 2020/4/9 0009 10:30
 * @Version 1.0
 */
public class CountDownLatchTest {


    private static CountDownLatch countDownLatch = new CountDownLatch(2);


    public static void main(String[] args) {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("A");
                countDownLatch.countDown();
                System.out.println("B");
            }
        });
        thread.start();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("C");
                countDownLatch.countDown();
                System.out.println("D");
            }
        });
        thread1.start();

        System.out.println("1");
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("2");
    }
}
