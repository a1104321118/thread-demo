package com.hr.lock.reentrant.lock;

/**
 * Created by Administrator on 2017/6/7 0007.
 */
public class Main {

    public static void main(String[] args) {
        Task task = new Task();
        Thread t1 = new Thread(new T1(task),"t1");
        Thread t2 = new Thread(new T1(task),"t2");
        t1.start();
        t2.start();
    }
}
