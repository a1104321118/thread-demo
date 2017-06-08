/**
 * 主要了解 synchronized 关键字的使用，
 *
 * 1.锁对象
 *  1.1 锁 this 对象，不太灵活
 *  1.2 锁 非this 对象，比较灵活，方便控制，可以避免 在 lockthis 情况下，对于不同的 synchronized 的方法，不会阻塞（因为各自占有不同的锁）
 *
 * 2.锁类（当一个类被锁了之后，所有对象的锁都被该段 synchronized 块占有）
 * 3.方法用 synchronized + static 修饰 == 锁类
 *
 * Created by Administrator on 2017/6/7 0007.
 */
package com.hr.synchronizedinit;