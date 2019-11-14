package cn.panjin.shenxianbms.model.adapter;

/**
 * <p>
 * 面向对象数据线适配器:为了解决类适配器只是适配单一类的这个问题，就又出现了对象适配器模式，
 * 对象适配器，是将适合类的对象注入到适配器中，然后达到适配的作用。
 *
 *
 * </p>
 *
 * @Anthor panjin
 * @Description
 * @Date 2019/7/31 0031 18:56
 * @Version 1.0
 */
public class CableAdapterOrientedObject implements CableInterface{

    private HuaWeiTool huaWeiTool;

    private String phoneType = "安卓";

    public CableAdapterOrientedObject(){

    }

    public CableAdapterOrientedObject(String phoneType){
        this.phoneType = phoneType;
    }

    public CableAdapterOrientedObject(HuaWeiTool huaWeiTool, String phoneType){
        this.huaWeiTool = huaWeiTool;
        this.phoneType = phoneType;
    }

    /**
     * 安卓通用数据线实现充电
     * @return
     */
    @Override
    public void microUSBCable() {
        System.out.println("叮叮叮，你的安卓手机已经开始充电");
    }

    /**
     * 苹果手机数据线实现充电
     * @return
     */
    @Override
    public void lightingCable() {
        System.out.println("嘟嘟嘟，你的苹果手机已经开始充电");
    }

    /**
     * 连接手机方法
     */
    public void connectionPhone(){
        if("苹果".equals(phoneType)){
            this.lightingCable();
        }
        else if ("安卓".equals(phoneType)){
            this.microUSBCable();
        }
        else if("华为".equals(phoneType)){
            huaWeiTool.TypeCUSBCable();
        }
        else {
            System.out.println("没有适配的数据线");
        }
    }
}
