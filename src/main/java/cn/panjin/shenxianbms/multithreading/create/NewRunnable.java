package cn.panjin.shenxianbms.multithreading.create;

import org.springframework.stereotype.Component;

@Component
public class NewRunnable {

    @Deprecated
    public void testDeprecated(){
        System.out.println("测试加上@Deprecated关键字标记为已过时，不建议使用");
    }


    /**
     * 测试多线程抛出异常在控制台是否能够看到，结果：能
     */
    public void testRunnableThrowException(){
        Thread myThread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("我探马真是草了");
                //查看是否抛出异常
                System.out.println(1 / 0);
            }
        });
        myThread.start();
    }
}
