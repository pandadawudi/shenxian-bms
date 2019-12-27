package cn.panjin.shenxianbms.application.multithreading.service.impl;

import cn.panjin.shenxianbms.application.multithreading.component.SynchronizedSellingTickets;
import cn.panjin.shenxianbms.application.multithreading.service.SynchronizedSimulationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 多线程模拟接口
 * </p>
 *
 * @Anthor panjin
 * @Description
 * @Date 2019/12/26 0026 16:17
 * @Version 1.0
 */
@Service
public class SynchronizedSimulationServiceImpl implements SynchronizedSimulationService {


    @Autowired
    private SynchronizedSellingTickets multithreadingSellingTickets;


    @Autowired
    private SynchronizedSellingTickets multithreadingSellingTickets2;

    /**
     * 测试synchronized关键字锁定实例
     */
    @Override
    public void simulation() {
        for(int i = 0; i < 100; i++){
             new Thread(
                    new Runnable() {
                        @Override
                        public void run() {
                            //如果调用包含synchronized关键字方法，效率低下，多线程问题解决，结果：
                            //Thread-16获得一张火车票，剩余：81张
                            //Thread-11获得一张火车票，剩余：80张
                            //...
                            multithreadingSellingTickets.sellingTicketsYes();

                            //如果调用不包含synchronized关键字方法，效率高，多线程问题未解决，结果：
                            //Thread-08获得一张火车票，剩余：81张
                            //Thread-12获得一张火车票，剩余：81张
                            //...
                            //multithreadingSellingTickets.sellingTicketsNo();
                        }
                    }
            ).start();
        }
    }

    /**
     * 测试synchronized锁定实例后，实例的非synchronized方法能被调用吗？
     *
     * 测试思路：先开一个线程调用包含synchronized关键字方法锁定该实例，之后再调用该实例的非synchronized方法
     *
     * 结果：
     * Thread-17正在运行~~~
     * Thread-16获得一张火车票，剩余：79张
     * Thread-17正在运行~~~
     * Thread-17正在运行~~~
     * Thread-16获得一张火车票，剩余：78张
     * Thread-17正在运行~~~
     * Thread-17正在运行~~~
     * Thread-16获得一张火车票，剩余：77张
     * Thread-17正在运行~~~
     * Thread-17正在运行~~~
     *
     * 正在运行~~~先打印出，说明没有锁住
     *
     * 使用System.out.println方法打印更能看出，100条打印秒出，而马上去查看数据库，发现还在一条一条新增中~~~
     */
    public void test1(){
        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        for(int i = 0; i < 100; i++) {
                            multithreadingSellingTickets.sellingTicketsYes();
                        }
                    }
                }
        ).start();

        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        for(int i = 0; i < 100; i++) {
                            multithreadingSellingTickets.noSynchronized();
                        }
                    }
                }
        ).start();
    }

    /**
     * 该方法测试类被锁定
     *
     * 思路：
     * multithreadingSellingTickets实例和multithreadingSellingTickets2实例混合调用lockClass调用lockClass方法多次
     *
     * 结果：
     * Thread-16获得一张火车票，剩余：64张
     * Thread-17获得一张火车票，剩余：63张
     * Thread-17获得一张火车票，剩余：62张
     * Thread-18获得一张火车票，剩余：61张
     * Thread-19获得一张火车票，剩余：60张
     * Thread-19获得一张火车票，剩余：59张
     * Thread-20获得一张火车票，剩余：58张
     * Thread-20获得一张火车票，剩余：57张
     * Thread-21获得一张火车票，剩余：56张
     * 。。。
     */
    @Override
    public void test2() {
        for (int i = 0; i < 40; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    multithreadingSellingTickets.lockClass();
                    multithreadingSellingTickets2.lockClass();
                }
            }).start();
        }

    }
}
