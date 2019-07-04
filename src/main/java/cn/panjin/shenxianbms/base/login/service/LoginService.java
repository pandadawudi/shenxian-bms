package cn.panjin.shenxianbms.base.login.service;

import cn.panjin.shenxianbms.tool.web.WebResult;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 登陆
 * </p>
 *
 * @Anthor panjin
 * @Description
 * @Date 2019/7/1 0001 10:49
 * @Version 1.0
 */
public interface LoginService {
    /**
     * <p>
     * 登陆验证
     * </p>
     *
     * @Description
     * @Author panjin
     * @Param
     * @Return
     * @Throws
     * @Date 2019/7/1 0001 10:51
     * @Since
     **/
    WebResult doLogin(String userName, String password, HttpServletRequest request);
    
    /**
     * <p>
     * 注册
     * </p>
     * 
     * @Description 
     * @Author panjin
     * @Param 
     * @Return 
     * @Throws
     * @Date 2019/7/4 0004 15:02
     * @Since
     **/
    WebResult doRegister( String userName, String password, String realName, String phone, String email, String sex);
}
