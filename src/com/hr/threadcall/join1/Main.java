package com.hr.threadcall.join1;

/**
 * Created by Administrator on 2017/6/7 0007.
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new Task());
        t.start();
        t.join();//使用join 会使当前线程（main）无限期阻塞，直到使用join方法的线程 销毁
        //t.join(2000); //这样使用，main 线程只等 2s
        Thread.sleep(2000);//相同的效果，但是 thread 并不释放锁
        System.out.println("main end");
    }

    // join 源码是使用 wait() 方法进行的,所以 join 会释放锁
}
