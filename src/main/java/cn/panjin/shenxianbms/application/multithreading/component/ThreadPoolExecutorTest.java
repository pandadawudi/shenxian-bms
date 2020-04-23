package cn.panjin.shenxianbms.application.multithreading.component;

import java.util.concurrent.*;

/**
 * <p>
 * 线程池示例
 * </p>
 *
 * @Anthor panjin
 * @Description
 * @Date 2020/4/22 0022 14:25
 * @Version 1.0
 */
public class ThreadPoolExecutorTest {



    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5,8,
                60,TimeUnit.SECONDS,new ArrayBlockingQueue<Runnable>(5));
        for (int i = 0; i < 15; i++){
            Task task = new Task(i);
            threadPoolExecutor.execute(task);
            System.out.println("线程池中线程数目："+threadPoolExecutor.getPoolSize()+"，队列中等待执行的任务数目："+
                    threadPoolExecutor.getQueue().size()+"，已执行玩别的任务数目："+threadPoolExecutor.getCompletedTaskCount());
        }
        threadPoolExecutor.shutdown();


        haveResult();
    }

    /**
     * 线程池返回值
     */
    public static void haveResult(){
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5,5,
                0,TimeUnit.SECONDS,new ArrayBlockingQueue<Runnable>(5));
        Callable callable = new Callable() {
            @Override
            public Object call() throws Exception {
                return "wocao";
            }
        };

        Task task = new Task(1);
        //Future future = threadPoolExecutor.submit(callable);
        Future future = threadPoolExecutor.submit(task, "canshu");
        threadPoolExecutor.shutdown();
        try {
            System.out.println(future.get().toString());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
