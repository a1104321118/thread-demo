package com.hr.juc;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by hr on 2017/08/09.
 */
public class ConcurrentLinkedQueueTest {

    public static void main(String[] args) {
        ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<>();
        queue.offer("123");
        queue.offer("456");
        System.out.println(queue.poll());
    }
}
