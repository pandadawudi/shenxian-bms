package cn.panjin.shenxianbms.model.adapter;

/**
 * <p>
 * 适配器测试类
 * </p>
 *
 * 在开发过程中，使用一个已经存在的类，而他的接口不符合我们的需求。这个时候我们本着开闭原则，
 * 要创建一个既符合我们需求又实现了已存在的接口的类，这个类可以把其他不相关或不可预见的类协
 * 同起来一起工作。我们创建的这个类就是适配器类，起到了一个转换的作用。
 *
 * 适配器模式有类型的适配器模式和对象适配器模式两种实现方式。
 *
 * 面向类的适配器模式
 * 面向类的适配器实现起来并不复杂，主要的思想就是靠继承来实现适配。举个🌰，如果我们在调用
 * 一个接口的时候，发现这个接口中没有能实现我们需求的方法，然后发现这个接口旁边的一个类中
 * 有我们想要的方法，这个时候我们就可以创建一个适配器类，来继承接口旁边的这个类，并实现调
 * 用接口。这样就满足了我们既没有改变调用方式又实现了功能需求。
 *
 * @Anthor panjin
 * @Description
 * @Date 2019/7/31 0031 17:51
 * @Version 1.0
 */
public class AdapterTest {


    public static void main(String[] args){
        //面向类适配器
        CableAdapterOrientedClass cableAdapterOrientedClass = new CableAdapterOrientedClass("小米");
        cableAdapterOrientedClass.connectionPhone();

        //面向对象适配器
        CableAdapterOrientedObject cableAdapterOrientedObject1 = new CableAdapterOrientedObject();
        cableAdapterOrientedObject1.connectionPhone();

        CableAdapterOrientedObject cableAdapterOrientedObject2 = new CableAdapterOrientedObject("苹果");
        cableAdapterOrientedObject2.connectionPhone();

        HuaWeiTool huaWeiTool = new HuaWeiTool();
        CableAdapterOrientedObject cableAdapterOrientedObject3 = new CableAdapterOrientedObject(huaWeiTool,"华为");
        cableAdapterOrientedObject3.connectionPhone();
    }
}
