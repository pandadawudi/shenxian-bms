package cn.panjin.shenxianbms.tool.dynamic;

import cn.panjin.shenxianbms.base.compiler.entity.ParamsListVO;
import cn.panjin.shenxianbms.base.compiler.entity.ParamsVO;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * <p>
 * 代码组装类
 * </p>
 */
public class CodeAssemble {

    private static final String className = "cn.panjin.shenxianbms.tool.calculator.DynamicConstructionClass";
    private static final String packagePath = "package cn.panjin.shenxianbms.tool.calculator;\n";
    private static final String importBigDecimal = "\nimport java.math.BigDecimal;\n";
    private static final String classHead = "\npublic class DynamicConstructionClass{\n";
    private static final String constructionMethod = "\npublic DynamicConstructionClass(){}\n";
    private static final String end = "\n}";
    private static final String brackets = "){\n";
    private static final String functionHead = "\npublic Object doCalculation(";

    /**
     * 组装java文件
     *
     * @param codes 方法中的代码字符串
     * @return String[] java文件代码
     */
    public static String[] structureJavaFile(String codes){
        StringBuilder sb = new StringBuilder();
        sb.append(packagePath);
        sb.append(importBigDecimal);
        sb.append(classHead);
        sb.append(constructionMethod);
        sb.append(codes);
        sb.append(end);
        String[] c = new String[2];
        c[0] = className;
        c[1] = sb.toString();
        System.out.println(c[1]);
        return c;
    }

    /**
     * 根据替换后的代码和参数，组成方法体
     *
     * @return
     */
    public static String structureFunction(ParamsListVO paramsListVO){
        String methodBody = functionHead;
        List<ParamsVO> list = null;
        String code = "";
        if(paramsListVO != null){
            list = paramsListVO.getList();
            code = paramsListVO.getCode();
        }
        if(!CollectionUtils.isEmpty(list)){
            for(ParamsVO paramsVO : list){
                methodBody = methodBody + paramsVO.getParamType() + " " + paramsVO.getParamName() + ",";
            }
            methodBody = methodBody.substring(0, methodBody.length() - 1);
        }
        return methodBody + brackets + code + end;
    }
}
