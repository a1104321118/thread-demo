/**
 * 线程间通信
 * 主要是使用 wait/notify 机制进行线程的通信
 *
 * wait / notify 是针对 锁而言的，可以看作一个锁拥有很多个线程，
 * 但是这些线程中只有 <=1个 是 running 状态，其它全是wait/runnable状态
 *
 * IllegalMonitorStateException 抛出场景，
 *     1>当前线程不含有当前对象的锁资源的时候，调用obj.wait()方法;
 *     2>当前线程不含有当前对象的锁资源的时候，调用obj.notify()方法。
 *     3>当前线程不含有当前对象的锁资源的时候，调用obj.notifyAll()方法
 * 总而言之，当当前线程没该对象锁的时候，强行调用 wait/notify等方法
 *
 * Created by Administrator on 2017/6/7 0007.
 */
package com.hr.threadcall;