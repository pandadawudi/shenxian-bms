package cn.panjin.shenxianbms.base.compiler.controller;

import cn.panjin.shenxianbms.base.compiler.entity.SpcSourceData;
import cn.panjin.shenxianbms.base.compiler.service.CompilerService;
import cn.panjin.shenxianbms.base.compiler.service.impl.CompilerServiceImpl;
import cn.panjin.shenxianbms.base.login.service.LoginService;
import cn.panjin.shenxianbms.base.user.entity.BaseUser;
import cn.panjin.shenxianbms.tool.web.WebResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * <p>
 * 编译器Controller
 * </p>
 *
 * @Anthor panjin
 * @Description
 * @Date 2020/2/26 0026 16:06
 * @Version 1.0
 */
@Controller
@RequestMapping("/compiler/")
@Slf4j
public class CompilerController {

    @Autowired
    private CompilerService compilerService;

    @Autowired
    private LoginService loginService;
    /**
     * 跳转编译器页面
     *
     * @return
     * @throws
     */
    @RequestMapping(value = "login.html", method = RequestMethod.GET)
    public String login(){
        return "compiler";
    }

    /**
     * 获取源数据
     */
    @RequestMapping(value = "getSourceData.do", method = RequestMethod.GET)
    @ResponseBody
    public WebResult getSourceData(){
        //获取所有符合条件的源数据
        List<SpcSourceData> sourceDataList = compilerService.getSourceDataByStatus();
        //查询所有计算的人员
        List<BaseUser> userList = loginService.getUserList();
        Map map = new HashMap();
        map.put("sourceDataList", sourceDataList);
        map.put("userList", userList);
        return new WebResult(200, "SUCCESS", map);
    }

    /**
     * 编译源代码
     * 1.jdk加一个包：D:\Java\jdk\lib\tools.jar
     */
    @RequestMapping(value = "compileSourceCode.do", method = RequestMethod.POST)
    @ResponseBody
    public WebResult compileSourceCode(String textareaData, String dataArr){
        WebResult webResult = compilerService.compileSourceCode(textareaData, dataArr);
        return webResult;
    }

    /**
     * 计算
     */

    @RequestMapping(value = "calculationThisUser.do", method = RequestMethod.POST)
    @ResponseBody
    public WebResult calculationThisUser(String textareaData, String dataArr, Long userId){
        WebResult webResult = compilerService.calculationThisUser(textareaData, dataArr, userId);
        return webResult;
    }

}
