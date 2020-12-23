package com.sc.ms.demo.jvm;

import java.lang.ref.WeakReference;

/**
 * @program: ms
 * @description:
 * @author: 沈陈
 * @create: 2020-12-23 19:14
 **/
public class WeakReferenceDemo {
    public static void main(String[] args) {
        Object o1 = new Object();
        WeakReference<Object> weakReference = new WeakReference<>(o1);
        System.out.println(o1);
        System.out.println(weakReference.get());
        o1 = null;
        System.gc();
        System.out.println(o1);
        System.out.println(weakReference.get());

    }
}
