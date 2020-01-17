package cn.panjin.shenxianbms.application.multithreading.service.impl;

import cn.panjin.shenxianbms.application.multithreading.component.SynchronizedSellingTickets;
import cn.panjin.shenxianbms.application.multithreading.service.SynchronizedSevenCasesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * Synchronized七种使用情形
 * </p>
 *
 * @Anthor panjin
 * @Description
 * @Date 2020/1/15 0015 18:59
 * @Version 1.0
 */
@Service
public class SynchronizedSevenCasesServiceImpl implements SynchronizedSevenCasesService {

    /**
     * 售票类的第一个实例
     */
    @Autowired
    private SynchronizedSellingTickets synchronizedSellingTicketsOne;

    /**
     * 售票类的第二个实例
     */
    @Autowired
    private SynchronizedSellingTickets synchronizedSellingTicketsTwo;

    /**
     *
     * 1、多个线程同时访问一个对象的同步方法 （等待）
     */
    @Override
    public void first() {
        for(int i = 0; i < 15; i++){
            new Thread(){
                public void run(){
                    synchronizedSellingTicketsOne.sellingTicketsYes();
                }
            }.start();
        }
    }

    /**
     *
     * 2、多个线程访问的是两个对象的同步方法 （同时）
     */
    @Override
    public void second() {
        for(int i = 0; i < 50; i++){
            new Thread(){
                public void run(){
                    synchronizedSellingTicketsOne.sellingTicketsYes();
                }
            }.start();
            new Thread(){
                public void run(){
                    synchronizedSellingTicketsTwo.sellingTicketsYes();
                }
            }.start();
        }
    }

    /**
     *3、多个线程访问的是synchronized的静态方法 （等待）
     */
    @Override
    public void third() {
        for(int i = 0; i < 20; i++){
            new Thread(){
                public void run(){
                    synchronizedSellingTicketsOne.sellingTicketStatic();
                }
            }.start();
        }
    }

    /**
     *4、同时访问同步方法和非同步方法 （同时）
     */
    @Override
    public void fourth() {
        for(int i = 0; i < 50; i++){
            new Thread(){
                public void run(){
                    synchronizedSellingTicketsOne.sellingTicketsYes();
                }
            }.start();
            new Thread(){
                public void run(){
                    synchronizedSellingTicketsOne.sellingTicketsNo();
                }
            }.start();
        }
    }

    /**
     * 5、访问同一个对象的不同的同步方法 （等待）  锁的重入
     */
    @Override
    public void fifth() {
        for(int i = 0; i < 50; i++){
            new Thread(){
                public void run(){
                    synchronizedSellingTicketsOne.sellingTicketsYes();
                }
            }.start();
            new Thread(){
                public void run(){
                    synchronizedSellingTicketsOne.sellingTicketsYesTwo();
                }
            }.start();
        }
    }


    /**
     * 6、同时访问静态synchronized和非静态synchronized方法 （同时）
     */
    @Override
    public void sixth() {
        for(int i = 0; i < 50; i++){
            new Thread(){
                public void run(){
                    synchronizedSellingTicketsOne.sellingTicketsYes();
                }
            }.start();
            new Thread(){
                public void run(){
                    synchronizedSellingTicketsOne.lockClass();
                }
            }.start();
        }
    }

    /**
     * 7、方法抛出异常后，会释放锁
     */
    @Override
    public void seventh() {
        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        synchronizedSellingTicketsOne.printWord();
                    }
                }
        ){}.start();
        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        synchronizedSellingTicketsOne.printWord();
                    }
                }
        ){}.start();
    }
}
