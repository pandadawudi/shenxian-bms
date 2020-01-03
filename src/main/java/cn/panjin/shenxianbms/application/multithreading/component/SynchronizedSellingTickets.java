package cn.panjin.shenxianbms.application.multithreading.component;

import cn.panjin.shenxianbms.application.multithreading.dao.BmsOperationRecordMapper;
import cn.panjin.shenxianbms.application.multithreading.entity.BmsOperationRecord;
import cn.panjin.shenxianbms.tool.id.SnowWorker;
import org.springframework.beans.factory.annotation.Autowired;
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
public class SynchronizedSellingTickets {

    @Autowired
    private RedisTemplate redisTemplate;

    @Resource
    private BmsOperationRecordMapper bmsOperationRecordMapper;

    @Autowired
    private SnowWorker snowWorker;


    /**
     * synchronized关键字学习
     *
     * 对象锁
     *
     * MultithreadingServiceImpl的含有synchronized关键字方法
     *
     * 模拟A个人同时买火车票，有B个窗口售票，仅存C张火车票
     */
    public synchronized void sellingTicketsYes(){
        sellingTickets();
    }

    /**
     * 如果不加synchronized关键字
     */
    public void sellingTicketsNo(){
        sellingTickets();
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
        BmsOperationRecord bmsOperationRecord = new BmsOperationRecord();
        bmsOperationRecord.setId(snowWorker.nextId());
        bmsOperationRecord.setObjectId(1L);
        bmsOperationRecord.setOperationType(1);
        if(ticketNum >= 1){
            ticketNum = ticketNum - 1;
            bmsOperationRecord.setOperationContent(threadName + "获得一张火车票，剩余：" + (ticketNum) + "张");
        }else {
            bmsOperationRecord.setOperationContent(threadName + "来晚了，已经没有火车票了");
        }
        int i = bmsOperationRecordMapper.insert(bmsOperationRecord);
        if(i == 1){
            redisTemplate.opsForValue().set("ticketNum", ticketNum);
        }
    }

    /**
     * 该方法用于测试当前实例被锁住时，能否调用非synchronized修饰的方法
     */
    public void noSynchronized(){
        String threadName = Thread.currentThread().getName();
        BmsOperationRecord bmsOperationRecord = new BmsOperationRecord();
        bmsOperationRecord.setId(snowWorker.nextId());
        bmsOperationRecord.setObjectId(2L);
        bmsOperationRecord.setOperationType(2);
        bmsOperationRecord.setOperationContent(threadName + "正在运行~~~");
        bmsOperationRecordMapper.insert(bmsOperationRecord);
        //System.out.println("wodetian");
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
     * 打印
     */
    public void printWord(){
        System.out.println("cao");
    }
}
