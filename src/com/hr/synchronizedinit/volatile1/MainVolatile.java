package com.hr.synchronizedinit.volatile1;

/**
 * Created by Administrator on 2017/6/6 0006.
 */
public class MainVolatile {

    public static void main(String[] args) throws InterruptedException {
        Task task = new Task();
        task.setContinue(true);
        Thread thread = new Thread(task);
        thread.start();
        Thread.sleep(1000);
        task.setContinue(false);

        //volatile 保证了不同线程之间的数据可见性。
        //一般线程会从私有共享池中取值，而外部更新的时候更新的是公共共享池
        //这样线程拿到的一直是私有共享池中原来的值，而volatile 的作用就是同步 公共共享池和私有共享池

    }
}
