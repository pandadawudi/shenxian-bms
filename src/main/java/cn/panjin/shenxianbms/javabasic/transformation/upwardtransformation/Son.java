package cn.panjin.shenxianbms.javabasic.transformation.upwardtransformation;

/**
 * <p>
 * 儿子类
 * </p>
 *
 * @Anthor panjin
 * @Description
 * @Date 2020/1/15 0015 10:24
 * @Version 1.0
 */
public class Son extends Father{

    /**
     * 儿子的基因方法
     */
    public void gene(){
        System.out.println("儿子有皮肤白的基因");
    }

    /**
     * 儿子的独有优势方法
     */
    public void sonAdvantage(){
        System.out.println("儿子的独有优势年轻无限可能");
    }
}
