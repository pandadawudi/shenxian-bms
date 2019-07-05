package cn.panjin.shenxianbms.base.role.service;

import cn.panjin.shenxianbms.base.user.entity.BaseUser;
import cn.panjin.shenxianbms.tool.web.WebResult;

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
public interface BaseRoleService {
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
     * @Date 2019/7/4 0004 17:12
     * @Since
     **/
    WebResult addRoleService(String roleCode, String roleType, String roleName, String roleDescription, BaseUser user);
}
