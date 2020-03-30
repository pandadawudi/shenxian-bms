package cn.panjin.shenxianbms.model.strategy;

/**
 * <p>
 *  第一个实现策略模式接口的类
 * </p>
 *
 */
public class StrategyImplementationClassOne implements StrategyInterface{

    @Override
    public int getResult(int par1, int par2) {
        return par1 + par2;
    }
}
