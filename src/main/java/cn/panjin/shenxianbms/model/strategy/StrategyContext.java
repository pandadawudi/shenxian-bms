package cn.panjin.shenxianbms.model.strategy;

/**
 * <p>
 * 策略模式上下文
 * </p>
 *
 */
public class StrategyContext {

    private StrategyInterface strategyInterface;

    public StrategyContext(StrategyInterface strategyInterface){
        this.strategyInterface = strategyInterface;
    }

    public int calc(int par1, int par2){
        return strategyInterface.getResult(par1, par2);
    }
}
