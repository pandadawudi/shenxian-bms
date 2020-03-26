package cn.panjin.shenxianbms.base.compiler.controller;

import cn.panjin.shenxianbms.base.compiler.entity.SpcSourceData;
import cn.panjin.shenxianbms.base.compiler.service.CompilerService;
import cn.panjin.shenxianbms.base.user.entity.BaseUser;
import cn.panjin.shenxianbms.tool.web.WebResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 源数据设置Controller
 * </p>
 *
 * @Anthor panjin
 * @Description
 * @Date 2020/2/28 0028 14:34
 * @Version 1.0
 */
@Controller
@RequestMapping("/source/")
@Slf4j
public class BaseDataSetUpController {

    @Autowired
    private CompilerService compilerService;

    /**
     * 跳转到源数据增删页面
     *
     * @return
     * @throws
     */
    @RequestMapping(value = "login.html", method = RequestMethod.GET)
    public String login(){
        return "source";
    }

    /**
     * 获取源数据表格
     */
    @RequestMapping(value = "getSourceData.do", method = RequestMethod.GET)
    @ResponseBody
    public WebResult getSourceData(){
        //获取所有符合条件的源数据
        List<SpcSourceData> sourceDataList = compilerService.getSourceDataByStatus();
        return new WebResult(0, "获取成功", sourceDataList);
    }

    /**
     * 保存源数据
     */
    @RequestMapping(value = "saveSourceData.do", method = RequestMethod.POST)
    @ResponseBody
    public WebResult saveSourceData(String dataName, String dataEnglishName, String dataType, String tableName,
                                    String fieldName, String dataSql){
        return compilerService.saveSourceData(dataName, dataEnglishName,
                dataType, tableName, fieldName, dataSql);
    }

    /**
     * 删除源数据
     */
    @RequestMapping(value = "deleteSourceData.do", method = RequestMethod.POST)
    @ResponseBody
    public WebResult deleteSourceData(Long id){
        return compilerService.deleteSourceData(id);
    }


    @RequestMapping(value = "export.do", method = RequestMethod.GET)
    public void export(HttpServletRequest request, HttpServletResponse response){
        compilerService.export(request, response);
    }
}
