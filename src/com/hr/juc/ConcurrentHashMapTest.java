package com.hr.juc;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * concurrentHashMap
 * 是一个线程安全的hashmap，而且效率很高，多线程应用场景中推荐使用
 */
public class ConcurrentHashMapTest {

    public static void main(String[] args) {
        Map<String, Object> test = new ConcurrentHashMap<>();
        test.put("1","222");
        test.put("a","ccc");
        System.out.println(test);
    }
}
