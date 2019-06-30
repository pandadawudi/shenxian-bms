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
     * 登录页面
     *
     * @return
     * @throws
     */
    @RequestMapping(value = "login.html", method = RequestMethod.GET)
    public String login(){
        return "login";
    }

    /**
     * 注册页面
     *
     * @return
     * @throws
     */
    @RequestMapping(value = "register.html", method = RequestMethod.GET)
    public String register(){
        return "register";
    }

    /**
     * 主页面
     *
     * @return
     * @throws
     */
    @RequestMapping(value = "main.html", method = RequestMethod.GET)
    public String main(){
        return "main";
    }
}
