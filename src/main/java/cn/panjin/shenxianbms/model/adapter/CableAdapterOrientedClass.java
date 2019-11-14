package cn.panjin.shenxianbms.model.adapter;

/**
 * <p>
 * 面向类数据线适配器:由于Java语言的特性，类只能单继承，决定了这个适配器只能用在这个业务当中。如果我们又需要另一个类里面的方法呢？
 * 这个时候就又需要创建一个子类来实现适配，这也是为什么这种方式叫类适配器的原因。
 *
 * 初始化时传入手机类型，使用相应的数据线进行充电
 * </p>
 *
 * @Anthor panjin
 * @Description
 * @Date 2019/7/31 0031 17:09
 * @Version 1.0
 */
public class CableAdapterOrientedClass extends HuaWeiTool implements CableInterface{

    private String phoneType = "安卓";

    /**
     * 无参数构造方法
     */
    public CableAdapterOrientedClass(){

    }

    /**
     * 有参数构造方法
     */
    public CableAdapterOrientedClass(String phoneType){
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
            super.TypeCUSBCable();
        }
        else {
            System.out.println("没有适配的数据线");
        }
    }
}
