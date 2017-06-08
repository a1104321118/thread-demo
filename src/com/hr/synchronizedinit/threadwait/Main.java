package com.hr.synchronizedinit.threadwait;

/**
 * Created by Administrator on 2017/6/6 0006.
 */
public class Main {

    public static void main(String[] args) {
        MyThread m = new MyThread();
        Thread t = new Thread(m);
        System.out.println("main begin");
        t.start();//线程放到这里，虽然该线程在sleep，但是不影响主线程继续走下去

        for (int i = 0; i < 100; i++) {
            System.out.println(i);
        }
        System.out.println("main end"); //会在 thread end 之前先输出
    }
}
