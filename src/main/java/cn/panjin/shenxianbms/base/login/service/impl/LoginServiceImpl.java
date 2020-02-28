package cn.panjin.shenxianbms.base.login.service.impl;

import cn.panjin.shenxianbms.base.login.service.LoginService;
import cn.panjin.shenxianbms.base.user.dao.BaseUserMapper;
import cn.panjin.shenxianbms.base.user.entity.BaseUser;
import cn.panjin.shenxianbms.config.id.SnowId;
import cn.panjin.shenxianbms.tool.web.WebResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

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

    @Resource
    private BaseUserMapper baseUserMapper;

    @Autowired
    private SnowId snowId;
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
    public WebResult doLogin(String userName, String password, HttpServletRequest request) {
        //用登陆账户查询人员是否存在
        BaseUser baseUser = baseUserMapper.getUserByLoginName(userName);
        if(baseUser == null){
            return new WebResult(500, "用户不存在", null);
        }
        String userPassword = baseUser.getPassword();
        if(password.equals(userPassword)){
            request.getSession().setAttribute("user", baseUser);
            return new WebResult(200, "登陆成功", null);
        }else {
            return new WebResult(500, "密码错误", null);
        }
    }

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
     * @Date 2019/7/4 0004 15:03
     * @Since
     **/
    @Override
    public WebResult doRegister(String userName, String password, String realName, String phone, String email, String sex) {
        BaseUser baseUser = new BaseUser();
        baseUser.setId(snowId.idWorker().nextId());
        baseUser.setLoginName(userName);
        baseUser.setPassword(password);
        baseUser.setLocked(true);
        baseUser.setStateType(false);
        baseUser.setRealName(realName);
        baseUser.setPhone(phone);
        baseUser.setEmail(email);
        baseUser.setSex(sex.equals("1") ? true : false);
        baseUser.setCreaterId(baseUser.getId());
        baseUser.setCreaterName(baseUser.getLoginName());
        baseUser.setCreateTime(new Date());
        int count = baseUserMapper.insert(baseUser);
        if(count == 1){
            return new WebResult(200, "注册成功", null);
        }else{
            return new WebResult(500, "注册失败", null);
        }

    }

    @Override
    public List<BaseUser> getUserList() {
        return baseUserMapper.getUserList();
    }
}
