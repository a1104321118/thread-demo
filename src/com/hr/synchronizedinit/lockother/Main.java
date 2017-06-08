package com.hr.synchronizedinit.lockother;

/**
 * Created by Administrator on 2017/6/6 0006.
 */
public class Main {

    public static void main(String[] args) {
        Task task = new Task();

        Thread t1 = new Thread(new MyT1(task));
        Thread t11 = new Thread(new MyT1(task));

        Thread t2 = new Thread(new MyT2(task));

        t1.start();
        t11.start();
        t2.start();
    }

    //这种锁 非 this 对象的操作 可以避免 在 lockthis 包中的情况，对于不同的 synchronized方法 不会阻塞
    //但是对于同一个  synchronize 方法还是会阻塞（因为锁的是用一个对象），这样就保证了同步，又可以提高效率
}
