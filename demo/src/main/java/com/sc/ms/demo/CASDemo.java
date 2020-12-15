package com.sc.ms.demo;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * casdemo
 *
 * @author 沈陈
 * @date 2020/11/30
 */
public class CASDemo {

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(5);
        System.out.println(atomicInteger.compareAndSet(5, 2019) + "\t current data:" + atomicInteger.get());
        System.out.println(atomicInteger.compareAndSet(5, 3333) + "\t current data:" + atomicInteger.get());
        atomicInteger.getAndIncrement();
    }
}
