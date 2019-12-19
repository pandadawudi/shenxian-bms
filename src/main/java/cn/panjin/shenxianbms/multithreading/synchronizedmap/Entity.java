package cn.panjin.shenxianbms.multithreading.synchronizedmap;

/**
 * <p>
 *
 * </p>
 *
 * @Anthor panjin
 * @Description
 * @Date 2019/11/20 0020 9:28
 * @Version 1.0
 */
public class Entity extends Thread{

    public boolean flag = false;
    @Override
    public void run() {
        System.out.println("run当前线程名字：" + Thread.currentThread().getName());
        System.out.println("start to execute ---");
        while(!flag){
            int j = 1/1;
        }
        System.out.println("finish to execute----");
    }

    public void isRun(boolean flag){
        this.flag = flag;
    }

    public boolean getRun(){
        return flag;
    }


    /**
     * Thread.sleep(300)存在打印：
     * start to execute ---
     * the final value is:true
     * 并且陷入死循环
     *
     * 注释Thread.sleep(300)打印：
     * the final value is:true
     * start to execute ---
     * finish to execute----
     * @param args
     * @throws InterruptedException
     */
    public static void main(String args[]) throws InterruptedException {
        System.out.println("当前线程名字：" + Thread.currentThread().getName());
        Entity entity = new Entity();
        entity.start();
        System.out.println("当前线程名字：" + Thread.currentThread().getName());
        Thread.sleep(300);
        entity.isRun(true);
        System.out.println("the final value is:" + entity.getRun());
    }
}
