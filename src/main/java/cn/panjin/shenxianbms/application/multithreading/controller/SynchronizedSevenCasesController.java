package cn.panjin.shenxianbms.application.multithreading.controller;

import cn.panjin.shenxianbms.application.multithreading.service.SynchronizedSevenCasesService;
import cn.panjin.shenxianbms.application.multithreading.service.SynchronizedSimulationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 * Synchronized七种使用情形
 * </p>
 *
 * @Anthor panjin
 * @Description
 * @Date 2020/1/16 0016 9:46
 * @Version 1.0
 */
@Controller
@RequestMapping("/seven/")
public class SynchronizedSevenCasesController {

    @Autowired
    private SynchronizedSevenCasesService synchronizedSevenCasesService;

    /**
     * 测试接口
     */
    @RequestMapping(value = "test.do", method = RequestMethod.GET)
    @ResponseBody
    public void test(){
        synchronizedSevenCasesService.seventh();
    }
}
