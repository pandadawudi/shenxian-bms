package cn.panjin.shenxianbms.multithreading.create;

/**
 * 创建线程
 */
public class NewThread extends Thread{

    public void run(){
        System.out.println("wo cao");
    }


    public static void main(String args[]){
        NewThread newThread = new NewThread();
        newThread.start();
    }


}
