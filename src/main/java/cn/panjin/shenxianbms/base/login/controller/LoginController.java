package cn.panjin.shenxianbms.base.login.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>
 * 登陆注册控制器
 * </p>
 *
 * @Anthor panjin
 * @Description
 * @Date 2019/7/1 0001 10:47
 * @Version 1.0
 */
@Controller
@RequestMapping("/login/")
@Slf4j
public class LoginController {

    /**
     * 跳转登录页面
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
     * 登陆
     *
     * @return
     * @throws
     */
    @RequestMapping(value = "doLogin.do", method = RequestMethod.GET)
    public String doLogin(@RequestParam String userName, @RequestParam String password){


        return "register";
    }
}
