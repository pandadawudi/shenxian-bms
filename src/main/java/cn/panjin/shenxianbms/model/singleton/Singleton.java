package cn.panjin.shenxianbms.model.singleton;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 双重锁单例模式创建实例
 *
 * 线程安全，延迟初始化。这种方式采用双锁机制，安全且在多线程情况下能保持高性能。
 *
 * 双重检查模式，进行了两次的判断，第一次是为了避免不要的实例，第二次是为了进行同步，避免多线程问题。
 * 由于singleton=new Singleton()对象的创建在JVM中可能会进行重排序，在多线程访问下存在风险，
 * 使用volatile修饰singleton实例变量有效，解决该问题。
 * </p>
 *
 * @Anthor panjin
 * @Description
 * @Date 2019/12/30 0030 14:49
 * @Version 1.0
 */
public class Singleton {

    /**
     * 保证了不同线程对这个变量进行操作时的可见性，即一个线程修改了某个变量的值，这新值对其他线程来说是立即可见的。（实现可见性）
     * 禁止进行指令重排序。（实现有序性）
     * volatile 只能保证对单次读/写的原子性。i++ 这种操作不能保证原子性。解释如下：
     *
     * 假如某个时刻变量inc的值为10，线程1对变量进行自增操作，线程1先读取了变量inc的原始值，
     * 然后线程1被阻塞了；然后线程2对变量进行自增操作，线程2也去读取变量inc的原始值，由于
     * 线程1只是对变量inc进行读取操作，而没有对变量进行修改操作，所以不会导致线程2的工作
     * 内存中缓存变量inc的缓存行无效，所以线程2会直接去主存读取inc的值，发现inc的值时10，
     * 然后进行加1操作，并把11写入工作内存，最后写入主存。然后线程1接着进行加1操作，由于
     * 已经读取了inc的值，注意此时在线程1的工作内存中inc的值仍然为10，所以线程1对inc进行
     * 加1操作后inc的值为11，然后将11写入工作内存，最后写入主存。那么两个线程分别进行了
     * 一次自增操作后，inc只增加了1。
     *
     * 有序性：
     * 确保指令重排序时不会将其后面的代码排到内存屏障之前
     * 确保指令重排序时不会将其前面的代码排到内存屏障之后
     * 确保在执行到内存屏障修饰的指令时前面的代码全部执行完成
     * 强制将线程工作内存中值的修改刷新至主内存中
     * 如果是写操作，则会导致其他线程工作内存(CPU Cache)中的缓存数据失效
     *
     * Person p = new Person();那么我们的Jit编译器会怎样操作呢？会分为以下三个子操作，
     * ①.分配Person实例所需要的内存空间;
     * objRef = allocate(Person.class);（推荐大家看一下Java反射机制，很重要的很基础的很...有用的=@=）
     * ②.调用Person的构造方法初始化objRef引用指向一个Person实例;
     * invokeConstructor(objRef);
     * ③.将Person实例引用objRef赋值给实例变量p；
     * p = objRef;
     *
     *
     * 如下是 happens-before 的8条原则，摘自 《深入理解Java虚拟机》。
     * 程序次序规则：一个线程内，按照代码顺序，书写在前面的操作先行发生于书写在后面的操作；
     * 锁定规则：一个 unLock（解锁） 操作先行发生于后面对同一个锁的 lock 操作；
     * volatile 变量规则：对一个变量的写操作先行发生于后面对这个变量的读操作；
     * 传递规则：如果操作A先行发生于操作B，而操作B又先行发生于操作C，则可以得出操作A先行发生于操作C；
     * 线程启动规则：Thread对象的start()方法先行发生于此线程的每个一个动作；
     * 线程中断规则：对线程interrupt()方法的调用先行发生于被中断线程的代码检测到中断事件的发生；
     * 线程终结规则：线程中所有的操作都先行发生于线程的终止检测，我们可以通过Thread.join()方法结束、Thread.isAlive()的返回值手段检测到线程已经终止执行；
     * 对象终结规则：一个对象的初始化完成先行发生于他的 finalize() 方法的开始；
     *
     */
    private volatile static Singleton singleton;

    private Singleton (){

    }

    public static Singleton getSingleton() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    System.out.println("wo de guai guai");
                    singleton = new Singleton();
//                    memory = allocate();  //1. 分配对象的内存空间
//                    ctorInstance(memory); //2. 初始化对象
//                    instance = memory;    //3. 设置 instance 指向对象的内存空间
                }
            }
        }
        return singleton;
    }

}