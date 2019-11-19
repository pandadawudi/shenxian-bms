package cn.panjin.shenxianbms.multithreading.simulation;

/**
 * 模拟火车站售票
 * 多线程处理
 */
public class RailwayStationTicket implements Runnable{

    //火车票数量
    private int count = 20;


    /**
     * 购买火车票方法
     */
    public synchronized void buyTicket(){
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + "：开始买票~");
        count--;
        if(count < 0){
            System.out.println(threadName + "：已无余票~~~");
        }else {
            System.out.println(threadName + "：买票成功，当前余票：" + count);
        }

    }


    @Override
    public void run() {
        buyTicket();
    }
}
