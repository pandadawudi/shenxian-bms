package cn.panjin.shenxianbms.javabasic.transformation.upwardtransformation;

/**
 * <p>
 * 测试向上转型的类
 * </p>
 *
 * @Anthor panjin
 * @Description
 * @Date 2020/1/15 0015 10:27
 * @Version 1.0
 */
public class Test {

    public static void main(String[] args) {
        Father son1 = new Son();
        son1.fatherAdvantage();
        son1.gene();
        son1.grandpaAdvantage();


        Son son2 = new Son();
        son2.fatherAdvantage();
        son2.gene();
        son2.grandpaAdvantage();
        son2.sonAdvantage();

        Grandpa son3 = new Son();
        son3.gene();
        son3.grandpaAdvantage();

    }




}
