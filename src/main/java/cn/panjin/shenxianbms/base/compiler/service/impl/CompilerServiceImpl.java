package cn.panjin.shenxianbms.base.compiler.service.impl;

import cn.panjin.shenxianbms.base.compiler.dao.SpcSourceDataMapper;
import cn.panjin.shenxianbms.base.compiler.entity.ParamsListVO;
import cn.panjin.shenxianbms.base.compiler.entity.ParamsVO;
import cn.panjin.shenxianbms.base.compiler.entity.SpcSourceData;
import cn.panjin.shenxianbms.base.compiler.service.CompilerService;
import cn.panjin.shenxianbms.base.user.dao.BaseUserMapper;
import cn.panjin.shenxianbms.tool.dynamic.CodeAssemble;
import cn.panjin.shenxianbms.tool.dynamic.CompileTool;
import cn.panjin.shenxianbms.tool.dynamic.CustomClassLoader;
import cn.panjin.shenxianbms.tool.web.WebResult;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.io.File;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.net.URISyntaxException;
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

    private static final String className = "cn.panjin.shenxianbms.tool.calculator.DynamicConstructionClass";

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
        boolean result = structureCompile(textareaData, dataArr);
        if (result) {
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
    public boolean structureCompile(String textareaData, String dataArr) {
        String[] idArr = dataArr.split(",");
        //根据ID集合获取所有节点
        List<SpcSourceData> list = spcSourceDataMapper.getSourceDataByIds(idArr);
        //将中文名字置换为英文名字，作为参数
        ParamsListVO paramsListVO = replaceCode(list, textareaData);
        String codes = CodeAssemble.structureFunction(paramsListVO);
        System.out.println(codes);
        String[] c = CodeAssemble.structureJavaFile(codes);
        return CompileTool.compiledDynamic(c[0], c[1]);
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
        String codes = CodeAssemble.structureFunction(paramsListVO);
        String[] c = CodeAssemble.structureJavaFile(codes);
        //获取参数数据类型class
        List<ParamsVO> paramsVOList = paramsListVO.getList();
        Class[] args = new Class[paramsVOList == null ? 0 : paramsVOList.size()];
        //获取参数数组
        Object[] params = new Object[paramsVOList == null ? 0 : paramsVOList.size()];
        if (!CollectionUtils.isEmpty(paramsVOList)) {
            for (int i = 0; i < paramsVOList.size(); i++) {
                args[i] = paramsVOList.get(i).getCl();
                String sql = paramsVOList.get(i).getSql();
                sql = sql.replace("{userId}", userId.toString()).replace("{month}", "202002");
                Object result = chooseGetFunction(paramsVOList.get(i).getCl(), sql);
                params[i] = result;
            }
        }
        WebResult webResult = null;
        try {
            webResult = run("doCalculation", args, params, c);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return webResult;
    }

    /**
     * 保存源数据
     *
     * @param dataName
     * @param dataEnglishName
     * @param dataType
     * @param tableName
     * @param fieldName
     * @param dataSql
     * @return
     */
    @Override
    public WebResult saveSourceData(String dataName, String dataEnglishName, String dataType,
                                    String tableName, String fieldName, String dataSql) {
        SpcSourceData spcSourceData = new SpcSourceData();
        spcSourceData.setDataName(dataName);
        spcSourceData.setDataEnglishName(dataEnglishName);
        spcSourceData.setDataType(dataType);
        spcSourceData.setTableName(tableName);
        spcSourceData.setFieldName(fieldName);
        spcSourceData.setDataSql(dataSql);
        spcSourceData.setDataStatus(1);
        int count = spcSourceDataMapper.insert(spcSourceData);
        return new WebResult(200, "保存成功", count);
    }

    /**
     * 删除源数据
     *
     * @param id
     * @return
     */
    @Override
    public WebResult deleteSourceData(Long id) {
        Integer count = spcSourceDataMapper.deleteByPrimaryKey(id);
        return new WebResult(200, "删除成功", count);
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
                    paramsVO.setCl(getDateTypeClass(spcSourceData.getDataType()));
                    paramsVOList.add(paramsVO);
                }
            }
            paramsListVO.setList(paramsVOList);
        }
        paramsListVO.setCode(code);
        return paramsListVO;
    }

    /**
     * 根据数据类型获取该类型的class
     */
    public Class getDateTypeClass(String dataType) {
        Class c = null;
        try {
            if ("BigDecimal".equals(dataType)) {
                c = Class.forName("java.math." + dataType);
            } else {
                c = Class.forName("java.lang." + dataType);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return c;
    }

    /**
     * 创建对象、传入参数、并运行
     *
     * @param method 方法名称
     * @param args   参数类型class数组
     * @param params 参数值数组
     * @return
     */
    public WebResult run(String method, Class[] args, Object[] params, String[] c) throws URISyntaxException {
        WebResult webResult = null;
        boolean result = CompileTool.compiledDynamic(c[0], c[1]);
        Class<?> clazz = null;
        if (result) {
            File classPath = new File(Thread.currentThread().getContextClassLoader().getResource("").toURI());
            String outDir = classPath.getAbsolutePath() + File.separator;
            CustomClassLoader customClassLoader = new CustomClassLoader(outDir);
            try {
                clazz = customClassLoader.findClass(className);

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            webResult = new WebResult(500, "编译失败", null);
        }
        System.out.println(clazz.hashCode());
        Object invoke = null;
        try {
            // 生成对象
            Object obj = clazz.newInstance();
            // 调用方法
            Method m = clazz.getDeclaredMethod(method, args);
            invoke = m.invoke(obj, params);
            webResult = new WebResult(200, "计算成功，值为：" + invoke, invoke);
        } catch (Exception e) {
            e.printStackTrace();
            webResult = new WebResult(200, "计算出错，信息：" + e.getMessage(), null);
        }
        return webResult;
    }
}
