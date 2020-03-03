package cn.panjin.shenxianbms.tool.dynamic;

import java.io.*;

/**
 * <p>
 * 自定义类加载器
 * 1.继承ClassLoader
 * 2.重写findClass()方法
 * 3.调用defineClass()方法
 * </p>
 */
public class CustomClassLoader extends ClassLoader{

    private String path;

    public CustomClassLoader(String classPath){
        this.path = classPath;
    }

    /**
     * 重写findClass方法
     * @param name
     * @return
     * @throws ClassNotFoundException
     */
    @Override
    public Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            byte[] classDate = getDate(name);
            if(classDate != null){
                //defineClass方法将字节码转化为类
                return defineClass(name, classDate,0, classDate.length);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return super.findClass(name);
    }


    /**
     * 返回类的字节码
     * @param className
     * @return
     * @throws IOException
     */
    private byte[] getDate(String className) throws IOException{
        InputStream in = null;
        ByteArrayOutputStream out = null;
        String classPath = path + File.separatorChar + className.replace('.', File.separatorChar) + ".class";
        try {
            in=new FileInputStream(classPath);
            out=new ByteArrayOutputStream();
            byte[] buffer=new byte[2048];
            int len = 0;
            while((len = in.read(buffer)) != -1){
                out.write(buffer,0,len);
            }
            return out.toByteArray();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        finally{
            in.close();
            out.close();
        }
        return null;
    }

}
