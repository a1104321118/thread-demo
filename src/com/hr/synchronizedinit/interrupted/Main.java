package com.hr.synchronizedinit.interrupted;

/**
 * Created by Administrator on 2017/6/6 0006.
 */
public class Main {

    public static void main(String[] args){
        Thread t = new Thread(new MyThread());

        t.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("main");
            e.printStackTrace();
        }
        t.interrupt();
    }
}
