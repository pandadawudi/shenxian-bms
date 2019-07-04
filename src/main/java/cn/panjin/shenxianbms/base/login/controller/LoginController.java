package cn.panjin.shenxianbms.base.login.controller;

import cn.panjin.shenxianbms.base.login.service.LoginService;
import cn.panjin.shenxianbms.tool.web.WebResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

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

    @Autowired
    private LoginService loginService;

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
    @RequestMapping(value = "doLogin.do", method = RequestMethod.POST)
    @ResponseBody
    public WebResult doLogin(@RequestParam String userName, @RequestParam String password, HttpServletRequest request){
        return loginService.doLogin(userName,password,request);
    }

    /**
     * 注册
     *
     * @return
     * @throws
     */
    @RequestMapping(value = "doRegister.do", method = RequestMethod.POST)
    @ResponseBody
    public WebResult doRegister(@RequestParam String userName, @RequestParam String password,
                                @RequestParam String realName, @RequestParam String phone,
                                @RequestParam String email, @RequestParam String sex){
        return loginService.doRegister(userName,password,realName,phone,email,sex);
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
