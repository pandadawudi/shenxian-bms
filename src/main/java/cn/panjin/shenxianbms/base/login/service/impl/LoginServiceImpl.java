package cn.panjin.shenxianbms.base.login.service.impl;

import cn.panjin.shenxianbms.base.login.service.LoginService;
import cn.panjin.shenxianbms.tool.web.WebResult;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 登陆
 * </p>
 *
 * @Anthor panjin
 * @Description
 * @Date 2019/7/1 0001 10:50
 * @Version 1.0
 */
@Service
public class LoginServiceImpl implements LoginService {
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
     * @Date 2019/7/1 0001 10:53
     * @Since
     **/
    @Override
    public WebResult doLogin(String userName, String password) {
        //用登陆账户查询人员是否存在
        return null;
    }
}
