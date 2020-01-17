package cn.panjin.shenxianbms.application.multithreading.component;

import cn.panjin.shenxianbms.application.multithreading.service.OperationRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * <p>
 * 多线程学习
 * </p>
 *
 * @Anthor panjin
 * @Description
 * @Date 2019/12/23 0023 16:40
 * @Version 1.0
 */
@Component
@Scope("prototype")
public class SynchronizedSellingTickets {

    @Resource
    private RedisTemplate<String, Integer> redisTemplate;

    @Autowired
    private OperationRecordService operationRecordService;


    private static Integer ticketNumber = 15;


    /**
     * 加synchronized关键字的同步方法
     *
     *
     * 模拟A个人同时买火车票，仅存B张火车票
     */
    public synchronized void sellingTicketsYes(){
        sellingTickets();
    }

    public synchronized void sellingTicketsYesTwo(){
        sellingTickets();
    }

    /**
     * 不加synchronized关键字的普通方法
     */
    public void sellingTicketsNo(){
        sellingTickets();
    }

    /**
     * 静态synchronized关键字同步方法
     */
    public static synchronized void sellingTicketStatic(){
        simulation();
    }


    /**
     * 方法
     */
    @Transactional
    public void sellingTickets(){
        Object num = redisTemplate.opsForValue().get("ticketNum");
        int ticketNum = num == null ? 0 : (int) num;
        //获取线程名称
        String threadName = Thread.currentThread().getName();
        int count = 0;
        if(ticketNum >= 1){
            ticketNum = ticketNum - 1;
            count = operationRecordService.addOperationRecord(1L, 66,
                    threadName + "获得一张火车票，剩余：" + (ticketNum) + "张");
        }else {
            operationRecordService.addOperationRecord(1L, 67,
                    threadName + "来晚了，已经没有火车票了");
        }
        if(count == 1){
            redisTemplate.opsForValue().set("ticketNum", ticketNum);
        }
    }

    /**
     * 该方法用于测试当前实例被锁住时，能否调用非synchronized修饰的方法
     */
    public void noSynchronized(){
        simulation();
    }

    /**
     * 模拟
     */
    public static void simulation(){
        if(ticketNumber > 0){
            ticketNumber = ticketNumber - 1;
            System.out.println(Thread.currentThread().getId() + "买了一张票，还剩" + ticketNumber + "张");
        }else {
            System.out.println("没票了~~");
        }
    }

    /**
     * 该方法测试类被锁定
     */
    public void lockClass(){
        synchronized (SynchronizedSellingTickets.class){
            sellingTickets();
        }
    }

    /**
     * 抛出异常测试锁
     */
    public void printWord(){
        System.out.println(Thread.currentThread().getName() + "进入了方法。");
        synchronized (SynchronizedSellingTickets.class){
            System.out.println(Thread.currentThread().getName() + "获取到锁！");
            throw new RuntimeException("抛出一个异常~~");
        }
    }
}
