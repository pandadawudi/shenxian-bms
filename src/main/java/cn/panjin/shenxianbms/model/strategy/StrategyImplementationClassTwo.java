package cn.panjin.shenxianbms.model.strategy;

/**
 * <p>
 *  第二个实现策略模式的实现类
 * </p>
 *
 */
public class StrategyImplementationClassTwo implements StrategyInterface{
    @Override
    public int getResult(int par1, int par2) {
        return par1 * par2;
    }
}
