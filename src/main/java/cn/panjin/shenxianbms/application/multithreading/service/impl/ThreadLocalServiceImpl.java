package cn.panjin.shenxianbms.application.multithreading.service.impl;

import cn.panjin.shenxianbms.application.multithreading.component.ThreadLocalUserSession;
import cn.panjin.shenxianbms.application.multithreading.service.ThreadLocalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * ThreadLocal学习接口
 * </p>
 *
 * @Anthor panjin
 * @Description
 * @Date 2019/12/27 0027 14:52
 * @Version 1.0
 */
@Service
public class ThreadLocalServiceImpl implements ThreadLocalService {

    @Autowired
    private ThreadLocalUserSession threadLocalUserSession;

    /**
     * ThreadLocal测试方法
     */
    @Override
    public void doTest() {
        System.out.println(Thread.currentThread().getId());
        threadLocalUserSession.dataIsolationTest();
    }
}
