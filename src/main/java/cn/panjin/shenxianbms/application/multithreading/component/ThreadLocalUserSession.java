package cn.panjin.shenxianbms.application.multithreading.component;

import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;

/**
 * <p>
 * ThreadLocal学习：用户session
 * </p>
 *
 * @Anthor panjin
 * @Description
 * @Date 2019/12/27 0027 14:56
 * @Version 1.0
 */
@Component
public class ThreadLocalUserSession {

    final static ThreadLocal threadLocal = new ThreadLocal();


    /**
     * ThreadLocal数据隔离测试
     */
    public void dataIsolationTest(){
        System.out.println(Thread.currentThread().getId());
        threadLocal.set("abc");
        threadLocal.set(123);
        System.out.println(threadLocal.get());
    }
}
