package cn.panjin.shenxianbms.base.compiler.service.impl;

import cn.panjin.shenxianbms.base.compiler.dao.SpcSourceDataMapper;
import cn.panjin.shenxianbms.base.compiler.entity.ParamsListVO;
import cn.panjin.shenxianbms.base.compiler.entity.ParamsVO;
import cn.panjin.shenxianbms.base.compiler.entity.SpcSourceData;
import cn.panjin.shenxianbms.base.compiler.service.CompilerService;
import cn.panjin.shenxianbms.base.user.dao.BaseUserMapper;
import cn.panjin.shenxianbms.tool.calculator.Eval;
import cn.panjin.shenxianbms.tool.web.WebResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @Anthor panjin
 * @Description
 * @Date 2020/2/26 0026 19:41
 * @Version 1.0
 */
@Service
public class CompilerServiceImpl implements CompilerService {

    @Resource
    private SpcSourceDataMapper spcSourceDataMapper;

    @Resource
    private BaseUserMapper baseUserMapper;

    @Autowired
    private Eval eval;


    @Override
    public List<SpcSourceData> getSourceDataByStatus() {
        return spcSourceDataMapper.getSourceDataByStatus(1);
    }

    /**
     * 编译伪代码
     *
     * @param textareaData 伪代码主体
     * @param dataArr      选择的源数据ID
     */
    @Override
    public WebResult compileSourceCode(String textareaData, String dataArr) {
        Class<?> clazz = structureCompile(textareaData, dataArr);
        if (clazz != null) {
            return new WebResult(200, "编译成功", null);
        } else {
            return new WebResult(500, "编译失败", null);
        }
    }

    /**
     * 组装参数，编译，返回编译后的对象
     *
     * @param textareaData 伪代码主体
     * @param dataArr      选择的源数据ID
     */
    public Class<?> structureCompile(String textareaData, String dataArr) {
        String[] idArr = dataArr.split(",");
        //根据ID集合获取所有节点
        List<SpcSourceData> list = spcSourceDataMapper.getSourceDataByIds(idArr);
        //将中文名字置换为英文名字，作为参数
        ParamsListVO paramsListVO = replaceCode(list, textareaData);
        String codes = eval.structureFunction(paramsListVO);
        System.out.println(codes);
        String[] c = eval.structureClass(codes);
        Class<?> clazz = eval.compile(c[0], c[1]);
        return clazz;
    }

    /**
     * 计算该人员的项目
     *
     * @param textareaData
     * @param dataArr
     * @param userId
     * @return
     */
    @Override
    public WebResult calculationThisUser(String textareaData, String dataArr, Long userId) {
        String[] idArr = dataArr.split(",");
        //根据ID集合获取所有节点
        List<SpcSourceData> list = spcSourceDataMapper.getSourceDataByIds(idArr);
        //将中文名字置换为英文名字，作为参数
        ParamsListVO paramsListVO = replaceCode(list, textareaData);
        String codes = eval.structureFunction(paramsListVO);
        String[] c = eval.structureClass(codes);
        //获取参数数据类型class
        List<ParamsVO> paramsVOList = paramsListVO.getList();
        Class[] args = new Class[paramsVOList.size()];
        //获取参数数组
        Object[] params = new Object[paramsVOList.size()];
        if (!CollectionUtils.isEmpty(paramsVOList)) {
            for (int i = 0; i < paramsVOList.size(); i++) {
                args[i] = paramsVOList.get(i).getCl();
                String sql = paramsVOList.get(i).getSql();
                sql = sql.replace("{userId}", userId.toString());
                Object result = chooseGetFunction(paramsVOList.get(i).getCl(), sql);
                params[i] = result;
            }
        }
        return eval.run("doCalculation", args, params, c);
    }

    /**
     * 根据传入的参数类型，mybatis使用不同的查询方法
     */
    private Object chooseGetFunction(Class c, String sql) {
        Object result = null;
        if (c == Byte.class) {
            result = spcSourceDataMapper.executeSqlToByte(sql);
        } else if (c == Short.class) {
            result = spcSourceDataMapper.executeSqlToShort(sql);
        } else if (c == Integer.class) {
            result = spcSourceDataMapper.executeSqlToInteger(sql);
        } else if (c == Long.class) {
            result = spcSourceDataMapper.executeSqlToLong(sql);
        } else if (c == Float.class) {
            result = spcSourceDataMapper.executeSqlToFloat(sql);
        } else if (c == Double.class) {
            result = spcSourceDataMapper.executeSqlToDouble(sql);
        } else if (c == Boolean.class) {
            result = spcSourceDataMapper.executeSqlToBoolean(sql);
        } else if (c == Character.class) {
            result = spcSourceDataMapper.executeSqlToCharacter(sql);
        } else if (c == String.class) {
            result = spcSourceDataMapper.executeSqlToString(sql);
        } else if (c == BigDecimal.class) {
            result = spcSourceDataMapper.executeSqlToBigDecimal(sql);
        } else {
            result = spcSourceDataMapper.executeSqlToObject(sql);
        }
        return result;
    }

    /**
     * 将中文名字替换为英文参数
     */
    private ParamsListVO replaceCode(List<SpcSourceData> list, String code) {
        ParamsListVO paramsListVO = new ParamsListVO();
        List<ParamsVO> paramsVOList = new ArrayList<>();
        if (!CollectionUtils.isEmpty(list) && !StringUtils.isEmpty(code)) {
            for (SpcSourceData spcSourceData : list) {
                if (code.contains(spcSourceData.getDataName())) {
                    code = code.replace(spcSourceData.getDataName(), spcSourceData.getDataEnglishName());
                    ParamsVO paramsVO = new ParamsVO();
                    paramsVO.setParamName(spcSourceData.getDataEnglishName());
                    paramsVO.setParamType(spcSourceData.getDataType());
                    paramsVO.setSql(spcSourceData.getDataSql());
                    //获取此参数类型class
                    paramsVO.setCl(eval.getDateTypeClass(spcSourceData.getDataType()));
                    paramsVOList.add(paramsVO);
                }
            }
            paramsListVO.setList(paramsVOList);
        }
        paramsListVO.setCode(code);
        return paramsListVO;
    }
}
