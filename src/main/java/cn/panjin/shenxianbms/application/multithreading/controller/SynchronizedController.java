package cn.panjin.shenxianbms.application.multithreading.controller;

import cn.panjin.shenxianbms.application.multithreading.service.SynchronizedSimulationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 * 多线程学习
 * </p>
 *
 * @Anthor panjin
 * @Description
 * @Date 2019/12/23 0023 17:03
 * @Version 1.0
 */
@Controller
@RequestMapping("/synchronized/")
public class SynchronizedController {

    @Autowired
    private SynchronizedSimulationService multithreadingSimulationService;

    /**
     * 抢火车票模拟调用接口
     */
    @RequestMapping(value = "buyingTrainTickets.do", method = RequestMethod.GET)
    @ResponseBody
    public void buyingTrainTickets(){
        multithreadingSimulationService.test2();
    }

}
