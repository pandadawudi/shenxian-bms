package cn.panjin.shenxianbms.application.multithreading.component;

import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>
 *
 * </p>
 *
 * @Anthor panjin
 * @Description
 * @Date 2020/4/20 0020 15:55
 * @Version 1.0
 */
public class ReentrantLockTest {
    ReentrantLock reentrantLock = new ReentrantLock();


    private void test1(){
        reentrantLock.lock();


    }
}
