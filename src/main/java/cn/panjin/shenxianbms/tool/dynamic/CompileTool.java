package cn.panjin.shenxianbms.tool.dynamic;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.net.URISyntaxException;
import java.util.Arrays;

/**
 * <p>
 * 动态编译工具类
 * </p>
 */
public class CompileTool {


    /**
     * 装载字符串成为java可执行文件
     *
     * @param className class文件名称
     * @param javaCodes 需要编译的字符串
     * @return 是否编译成功
     */
    public static boolean compiledDynamic(String className, String javaCodes) {
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
        return task.call();
    }
}
