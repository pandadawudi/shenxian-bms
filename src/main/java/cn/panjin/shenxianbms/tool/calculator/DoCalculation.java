package cn.panjin.shenxianbms.tool.calculator;

/**
 * <p>
 *
 * </p>
 *
 * @Anthor panjin
 * @Description
 * @Date 2020/2/26 0026 14:19
 * @Version 1.0
 */
public class DoCalculation {


    public String doCalculation(boolean isLizhi, boolean isZhenshi, boolean isQuanqin) {
        System.out.println("进入方法：参数isLizhi=" + isLizhi + ",isZhenshi=" + isZhenshi + ",isQuanqin=" + isQuanqin);
        if (isLizhi) {
            return "0";
        } else {
            if (isZhenshi) {
                if (isQuanqin) {
                    return "199";
                } else {
                    return "0";
                }
            } else {
                return "88";
            }
        }
    }
}
