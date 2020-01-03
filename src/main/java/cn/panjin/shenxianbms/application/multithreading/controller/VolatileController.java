package cn.panjin.shenxianbms.application.multithreading.controller;

import cn.panjin.shenxianbms.application.multithreading.service.VolatileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 * volatile关键字学习
 * </p>
 *
 * @Anthor panjin
 * @Description
 * @Date 2019/12/30 0030 19:20
 * @Version 1.0
 */
@Controller
@RequestMapping("/volatile/")
public class VolatileController {

    @Autowired
    private VolatileService volatileService;

    /**
     *不加volatile关键字的单例模式双层验证试验
     */
    @RequestMapping(value = "volatileTest.do", method = RequestMethod.GET)
    @ResponseBody
    public void volatileTest(){
        volatileService.volatileTest();
    }
}
