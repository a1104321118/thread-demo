package com.hr.lock.reentrant.readwritelock;

/**
 * Created by Administrator on 2017/6/7 0007.
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        Task task = new Task();

        Thread t1 = new Thread(new T1(task));
        Thread t11 = new Thread(new T1(task));
        Thread t2 = new Thread(new T2(task));
        long start = System.currentTimeMillis();
        t1.start();
        Thread.sleep(1);//确保 t1 先执行
        //t11.start();
        t2.start();
        try {
            t2.join(); //为了计时需要，等t2执行完之后再走下去
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(System.currentTimeMillis()-start);
    }
}
