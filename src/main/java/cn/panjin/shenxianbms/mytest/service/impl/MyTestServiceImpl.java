package cn.panjin.shenxianbms.mytest.service.impl;

import cn.panjin.shenxianbms.base.role.dao.BaseRoleMapper;
import cn.panjin.shenxianbms.base.role.service.BaseRoleService;
import cn.panjin.shenxianbms.base.user.dao.BaseUserMapper;
import cn.panjin.shenxianbms.base.user.entity.BaseUser;
import cn.panjin.shenxianbms.mytest.service.MyTestService;
import cn.panjin.shenxianbms.tool.web.WebResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * <p>
 * 测试接口
 * </p>
 *
 * @Anthor panjin
 * @Description
 * @Date 2019/6/19 0019 15:43
 * @Version 1.0
 */
@Slf4j
@Service
public class MyTestServiceImpl implements MyTestService {

    @Resource
    private BaseRoleService baseRoleService;

    @Autowired
    private BaseUserMapper baseUserMapper;

    @Resource
    private BaseRoleMapper baseRoleMapper;

    /**
     * <p>
     * 测试事务:经测试，事务生效，Springboot不需要特殊配置事务
     * </p>
     **/
    @Override
    @Transactional
    public void testTransactional1() {
        BaseUser baseUser = baseUserMapper.getUserByLoginName("admin");
        WebResult webResult = baseRoleService.addRoleService("admin", "1", "管理员", "大权力", baseUser);
        System.out.println(webResult.getMsg());
        int i = 1 / 0;
    }

    /**
     * <p>
     * 测试事务:经测试，事务不会生效
     * </p>
     **/
    @Override
    @Transactional
    public void testTransactional2() {
        BaseUser baseUser = baseUserMapper.getUserByLoginName("admin");
        try {
            WebResult webResult = baseRoleService.addRoleService("admin", "1", "管理员", "大权力", baseUser);
            System.out.println(webResult.getMsg());
            int i = 1 / 0;
        }catch (RuntimeException e){
            e.printStackTrace();
        }
    }

    /**
     * <p>
     * 事务生效
     * </p>
     **/
    @Override
    @Transactional
    public void testTransactional3() {
        BaseUser baseUser = baseUserMapper.getUserByLoginName("admin");
        try {
            WebResult webResult = baseRoleService.addRoleService("admin", "1", "管理员", "大权力", baseUser);
            System.out.println(webResult.getMsg());
            int i = 1 / 0;
        }catch (RuntimeException e){
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    /**
     * <p>
     * 事务没有生效
     *
     * rollbackFor = RuntimeException.class在实际运用中没有任何意义，
     * 一般都会使用rollbackFor = Exception.class或者其他异常，但是不能是Runnable ，因为RuntimeException默认回滚
     * </p>
     **/
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void testTransactional4() {
        BaseUser baseUser = baseUserMapper.getUserByLoginName("admin");
        try {
            WebResult webResult = baseRoleService.addRoleService("admin", "1", "管理员", "大权力", baseUser);
            System.out.println(webResult.getMsg());
            int i = 1 / 0;
        }catch (RuntimeException e){
            e.printStackTrace();
        }
    }

    /**
     * <p>
     * 事务没有生效
     * </p>
     **/
    @Override
    public void testTransactional5() {
        this.deleteRole();
        int i = 1 / 0;
    }

    /**
     * <p>
     * 事务生效
     * </p>
     **/
    @Override
    public void testTransactional6() {
        this.deleteRole1();
        int i = 1 / 0;
    }

    @Transactional
    public void deleteRole(){
        baseRoleMapper.deleteByPrimaryKey(1146734338864451584L);
    }

    @Transactional
    public void deleteRole1(){
        baseRoleMapper.deleteByPrimaryKey(1146734338864451584L);
        int i = 1 / 0;
    }
}
