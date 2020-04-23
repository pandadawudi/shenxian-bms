package cn.panjin.shenxianbms.application.multithreading.component;

/**
 * <p>
 * 线程池任务
 * </p>
 *
 * @Anthor panjin
 * @Description
 * @Date 2020/4/22 0022 14:32
 * @Version 1.0
 */
public class Task implements Runnable{

    public Task(int count){
        this.count = count;
    }

    private int count;


    @Override
    public void run() {
        System.out.println("第" + count + "个任务开始执行。");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("第" + count + "个任务执行完成。");
    }
}
