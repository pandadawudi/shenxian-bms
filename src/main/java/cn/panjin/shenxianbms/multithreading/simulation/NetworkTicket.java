package cn.panjin.shenxianbms.multithreading.simulation;

/**
 * 从网上摘抄的火车站售票模拟
 */
public class NetworkTicket implements Runnable {
    // 共100票
    int ticket = 100;
    Object o = new Object();
    @Override
    public void run() {
        // 模拟卖票
        while (true) {
            synchronized(o){
                if (ticket > 0) {
                    // 模拟选坐的操作
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "正在卖票:"
                            + ticket--);
                }
            }
        }
    }
}
