package com.hr.threadcall.join1;

/**
 * Created by Administrator on 2017/6/7 0007.
 */
public class Task implements Runnable{

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
            System.out.println("task end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
