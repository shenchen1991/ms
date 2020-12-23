package com.sc.ms.demo.jvm;


import lombok.SneakyThrows;

import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;

/**
 * WeakHashMap
 *
 * @author 沈陈
 * @date 2020/12/23
 */
public class WeakHashMapDemo {

    public static void main(String[] args) {
        myHashMap();
        System.out.println("+++++++++++++++++++++++");
        myWeakHashMap();
    }

    @SneakyThrows
    private static void myWeakHashMap() {
        Map<Integer, String> hashMap = new WeakHashMap<>();
        Integer key = new Integer(1);
        String value = "hash";
        hashMap.put(key, value);
        key = null;
        System.out.println(hashMap);
        System.gc();
        System.out.println(hashMap);
    }

    private static void myHashMap() {
        Map<Integer, String> hashMap = new HashMap<>();
        Integer key = new Integer(1);
        String value = "hash";
        hashMap.put(key, value);
        key = null;
        System.out.println(hashMap);
        System.gc();
        System.out.println(hashMap);

    }
}
