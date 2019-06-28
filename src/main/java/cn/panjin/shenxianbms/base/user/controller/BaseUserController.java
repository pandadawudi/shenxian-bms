package cn.panjin.shenxianbms.base.user.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * <p>
 * User控制器
 * </p>
 *
 * @Anthor panjin
 * @Description
 * @Date 2019/6/28 0028 15:36
 * @Version 1.0
 */
@Controller
@RequestMapping("/user/")
@Slf4j
public class BaseUserController {

    /**
     * 测试登陆
     *
     * @return
     * @throws
     */
    @RequestMapping(value = "test.do", method = RequestMethod.GET)
    public String index(){
        return "index";
    }
}
