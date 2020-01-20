package cn.panjin.shenxianbms.application.multithreading.component;

import java.util.Optional;

/**
 * <p>
 * Synchronized关键字源码class
 * </p>
 *
 * @Anthor panjin
 * @Description
 * @Date 2020/1/17 0017 14:09
 * @Version 1.0
 */
public class SynchronizedSourceCode {
    /**
     * 测试方法
     */
    public void test(){
        synchronized (this){
            System.out.println("这是一段同步代码");
        }
    }
}
