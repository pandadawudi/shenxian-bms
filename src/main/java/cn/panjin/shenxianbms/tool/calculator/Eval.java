package cn.panjin.shenxianbms.tool.calculator;

import cn.panjin.shenxianbms.base.compiler.entity.ParamsListVO;
import cn.panjin.shenxianbms.base.compiler.entity.ParamsVO;
import cn.panjin.shenxianbms.tool.web.WebResult;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.lang.reflect.Method;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

@Component
public class Eval {

    /**
     * 根据替换后的代码和参数，组成方法体
     */
    public String structureFunction(ParamsListVO paramsListVO){
        String head = "public String doCalculation(";
        List<ParamsVO> list = null;
        String code = "";
        if(paramsListVO != null){
            list = paramsListVO.getList();
            code = paramsListVO.getCode();
        }
        if(!CollectionUtils.isEmpty(list)){
            for(ParamsVO paramsVO : list){
                head = head + paramsVO.getParamType() + " " + paramsVO.getParamName();
            }
        }
        return head + "){" + code + "}";
    }


    /**
     * 组装java文件
     *
     * @param codes
     * @return String[]
     */
    public static String[] structureClass(String codes) {
        String className = "cn.panjin.shenxianbms.tool.calculator.MyTest";
        StringBuilder sb = new StringBuilder();
        sb.append("package cn.panjin.shenxianbms.tool.calculator;");
        sb.append("\n public class MyTest{\n ");
        sb.append(codes);
        sb.append("\n}");
        String[] c = new String[2];
        c[0] = className;
        c[1] = sb.toString();
        return c;
    }

    /**
     * 根据数据类型获取该类型的class
     */
    public Class getDateTypeClass(String dataType){
        Class c = null;
        try {
            if("BigDecimal".equals(dataType)){
                c = Class.forName("java.math." + dataType);
            }else{
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
     * @param args 参数类型class数组
     * @param params 参数值数组
     * @return
     */
    public WebResult run(String method, Class[] args, Object[] params, String[] c) {
        WebResult webResult = null;
        Class<?> clazz = compile(c[0], c[1]);
        Object invoke = null;
        try {
            // 生成对象
            Object obj = clazz.newInstance();
            // 调用方法
            Method m = clazz.getDeclaredMethod(method, args);
            invoke = m.invoke(obj, params);
            webResult = new WebResult(200, "计算成功", invoke);
        } catch (Exception e) {
            e.printStackTrace();
            webResult = new WebResult(200, "计算出错，信息：" + e.getMessage(), null);
        }
        return webResult;
    }


    /**
     * 装载字符串成为java可执行文件
     *
     * @param className className
     * @param javaCodes javaCodes
     * @return Class
     */
    public Class<?> compile(String className, String javaCodes) {
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null,
                null);
        JavaSourceFromCodeString srcObject = new JavaSourceFromCodeString(className, javaCodes);
        Iterable<? extends JavaFileObject> fileObjects = Arrays.asList(srcObject);
        String flag = "-d";
        String outDir = "";
        try {
            File classPath = new File(Thread.currentThread().getContextClassLoader().getResource("").toURI());
            outDir = classPath.getAbsolutePath() + File.separator;
        } catch (URISyntaxException e1) {
            e1.printStackTrace();
        }
        Iterable<String> options = Arrays.asList(flag, outDir);
        JavaCompiler.CompilationTask task = compiler.getTask(null, fileManager, null, options,
                null, fileObjects);
        boolean result = task.call();
        if (result == true) {
            try {
                return Class.forName(className);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
