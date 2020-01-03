package cn.panjin.shenxianbms.application.multithreading.controller;

import cn.panjin.shenxianbms.application.multithreading.service.ThreadLocalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 * threadLocal学习
 * </p>
 *
 * @Anthor panjin
 * @Description
 * @Date 2019/12/27 0027 14:25
 * @Version 1.0
 */
@Controller
@RequestMapping("/threadLocal/")
public class ThreadLocalController {

    @Autowired
    private ThreadLocalService threadLocalService;

    /**
     * 数据隔离试验
     *
     * 学习到的：每次请求将会新建一个线程进行处理，这个方法调用的其他方法依然是属于这个线程的，打印出来的线程ID都是一个
     */
    @RequestMapping(value = "dataIsolationTest.do", method = RequestMethod.GET)
    @ResponseBody
    public void dataIsolationTest(){
        System.out.println(Thread.currentThread().getId());
        threadLocalService.doTest();
    }
}
