package cn.panjin.shenxianbms.model.adapter;

/**
 * <p>
 * 数据线接口
 * </p>
 *
 * @Anthor panjin
 * @Description
 * @Date 2019/7/31 0031 16:57
 * @Version 1.0
 */
public interface CableInterface {

    /**
     * 安卓操作系统通用数据线
     */
    void microUSBCable();

    /**
     * 苹果操作系统数据线
     */
    void lightingCable();
}
