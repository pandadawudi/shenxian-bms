package cn.panjin.shenxianbms.javabasic.transformation.upwardtransformation;

/**
 * <p>
 * 父亲类
 * </p>
 *
 * @Anthor panjin
 * @Description
 * @Date 2020/1/15 0015 10:20
 * @Version 1.0
 */
public class Father extends Grandpa{

    /**
     * 爷爷的基因方法
     */
    public void gene(){
        System.out.println("父亲有头发黑的基因");
    }

    /**
     * 父亲的独有优势方法
     */
    public void fatherAdvantage(){
        System.out.println("父亲的独有优势是学历高");
    }
}
