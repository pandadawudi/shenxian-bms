package cn.panjin.shenxianbms.application.multithreading.component;

/**
 * <p>
 * 死锁示例
 * </p>
 *
 * @Anthor panjin
 * @Description
 * @Date 2020/1/20 0020 14:00
 * @Version 1.0
 */
public class Deadlock {
    /** A锁 */
    private static String A = "A";

    /** B锁 */
    private static String B = "B";

    public void test() {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (A) {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (B) {
                        System.out.println("thread1...");
                    }
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (B) {
                    synchronized (A) {
                        System.out.println("thread2...");
                    }
                }
            }
        });
        t1.start();
        t2.start();
    }
}
