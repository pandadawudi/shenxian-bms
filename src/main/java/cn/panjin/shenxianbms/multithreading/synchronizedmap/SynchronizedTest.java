package cn.panjin.shenxianbms.multithreading.synchronizedmap;

import org.springframework.stereotype.Component;

/**
 * <p>
 * synchronized关键字验证
 * </p>
 *
 * @Anthor panjin
 * @Description
 * @Date 2019/11/19 0019 9:23
 * @Version 1.0
 */
public class SynchronizedTest implements Runnable{


    /**
     *
     *在多线程环境中，存在着共同操作访问一个对象类数据的情况，难免有数据不同步的情况出现。synchronized就是java内置修饰符专门来处理同步的。
     *
     * 对一个类、实例加锁，所有操作必须获取到锁才能进行。保证数据的同步。
     *
     * 使用场景大概分为四个：静态代码块、静态方法、非静态代码块、非静态方法。
     *
     * 其中，非静态方法锁定的是实例对象，在synchronized修饰的方法间是相斥的，调用时都要先获取到对象锁。
     * 非静态代码块跟非静态方法一致。多了一点是，可以指定锁定的对象为非当前类实例对象。
     * 非静态方法只有同一个实例的同一个synchronized或者不同的synchronized方法之间存在着同步关系。
     *
     * 静态方法锁定的是类，在所有synchronized修饰的静态方法间是相斥的。
     * 静态代码块跟静态方法一致。多了的就是，锁定的类可以为任意指定类（静态方法只能锁定当前类）。
     *
     */


    /**
     * run方法
     */
    public void run(){
        additionNumber();
    }
    /**
     * 非静态方法：锁当前类SynchronizedTest
     */
    public synchronized void test1() {
        //获取当前线程名称
        String name = Thread.currentThread().getName();
        System.out.println("线程[" + name + "]获得锁，运行");
    }

    public void test2(){
        System.out.println("执行test2方法了");
    }


    private static Integer sum = 1;

    public void additionNumber(){
        String name = Thread.currentThread().getName();
        System.out.println("[" + name + "]运行,sum++的值：" + sum++);
    }

}
