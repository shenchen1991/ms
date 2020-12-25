package com.sc.ms.demo.jvm.outofmemory;

import java.util.Random;

/**
 * 内存溢出
 *
 * @author 沈陈
 * @date 2020/12/25
 */
public class JavaHeapSpaceDemo {
    public static void main(String[] args) {
        String str = "test";
        while (true) {
            str = str + (str + new Random().nextInt(1111111111) + new Random().nextInt(222222222));
            str.intern();
        }
    }
}
