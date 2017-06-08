package com.hr.synchronizedinit.lockother;

/**
 * Created by Administrator on 2017/6/6 0006.
 */
public class Task {

    //一般不建议把String 对象作为锁对象，因为JVM 有缓存String，导致相同的String 看作是同一个对象，那么就会一直占用锁
    private String lockObj1 = new String(); //必须初始化才能锁
    private String lockObj2 = new String();

    public void m1() throws InterruptedException {

        synchronized (lockObj1) {
            System.out.println("m1");
            Thread.sleep(1000);
        }
    }

    public void m2() throws InterruptedException {

        synchronized (lockObj2) {
            System.out.println("m2");
            Thread.sleep(1000);
        }
    }

    //这种锁 非 this 对象的操作 可以避免 在 lockthis 包中的情况，对于不同的 synchronized方法 不会阻塞

}