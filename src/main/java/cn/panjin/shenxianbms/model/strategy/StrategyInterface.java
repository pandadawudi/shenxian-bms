package cn.panjin.shenxianbms.model.strategy;

/**
 * <p>
 * 策略模式接口
 * </p>
 *
 */
public interface StrategyInterface {

    /**
     * 获取结果方法
     * @param par1
     * @param par2
     * @return
     */
    int getResult(int par1, int par2);
}
