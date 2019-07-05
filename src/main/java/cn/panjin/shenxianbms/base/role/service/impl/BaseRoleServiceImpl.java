package cn.panjin.shenxianbms.base.role.service.impl;

import cn.panjin.shenxianbms.base.role.dao.BaseRoleMapper;
import cn.panjin.shenxianbms.base.role.entity.BaseRole;
import cn.panjin.shenxianbms.base.role.service.BaseRoleService;
import cn.panjin.shenxianbms.base.user.entity.BaseUser;
import cn.panjin.shenxianbms.config.id.SnowId;
import cn.panjin.shenxianbms.tool.web.WebResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * <p>
 * 角色接口
 * </p>
 *
 * @Anthor panjin
 * @Description
 * @Date 2019/7/4 0004 17:09
 * @Version 1.0
 */
@Slf4j
@Service
public class BaseRoleServiceImpl implements BaseRoleService {

    @Autowired
    private SnowId snowId;

    @Resource
    private BaseRoleMapper baseRoleMapper;

    /**
     * <p>
     * 新增角色
     * </p>
     *
     * @Description
     * @Author panjin
     * @Param
     * @Return
     * @Throws
     * @Date 2019/7/4 0004 17:18
     * @Since
     **/
    @Override
    public WebResult addRoleService(String roleCode, String roleType, String roleName, String roleDescription, BaseUser user) {
        BaseRole baseRole = new BaseRole();
        baseRole.setId(snowId.idWorker().nextId());
        baseRole.setRoleCode(roleCode);
        baseRole.setRoleType(new Byte(roleType));
        baseRole.setRoleName(roleName);
        baseRole.setRoleDescription(roleDescription);
        baseRole.setRoleStatus(true);
        baseRole.setCreaterId(user.getId());
        baseRole.setCreaterName(user.getLoginName());
        baseRole.setCreateTime(new Date());
        int count = baseRoleMapper.insert(baseRole);
        if(count == 1){
            return new WebResult(200,"创建角色成功", null);
        }else {
            return new WebResult(500,"创建角色失败", null);
        }
    }
}
