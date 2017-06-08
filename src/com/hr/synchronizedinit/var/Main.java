package com.hr.synchronizedinit.var;

/**
 * Created by Administrator on 2017/6/6 0006.
 */
public class Main {

    public static void main(String[] args) {
        Var var = new Var();
        ThreadA ta = new ThreadA(var);
        ThreadB tb = new ThreadB(var);
        ta.start();
        tb.start();
        //result
        //username:b;num:200;num2:200
        //username:a;num:200;num2:100
        //因为变量num是在方法外面的,线程不安全，除非方法上加上 synchornized，
        //而变量num2 是在方法里面的，相当于两个线程各自的变量一样，所以是线程安全的
        //synchornized需要等待锁的释放，比较耗时间
    }
}
