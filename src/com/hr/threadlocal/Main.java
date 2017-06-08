package com.hr.threadlocal;

/**
 * Created by Administrator on 2017/6/7 0007.
 */
public class Main {

    public static void main(String[] args) {
        T1 t1 = new T1();
        T2 t2 = new T2();
        t1.start();
        t2.start();
        Tools.threadLocal.set("main");
        System.out.println(Tools.threadLocal.get());

        //threadlocal 存储每一个线程的私有数据
    }
}
