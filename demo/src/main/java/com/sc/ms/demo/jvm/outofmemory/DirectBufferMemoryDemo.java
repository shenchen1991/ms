package com.sc.ms.demo.jvm.outofmemory;

import sun.misc.VM;

import java.nio.ByteBuffer;

/**
 * 直接缓冲区内存溢出演示
 *
 * @author 沈陈
 * @date 2020/12/25
 */
public class DirectBufferMemoryDemo {

    public static void main(String[] args) {
        System.out.println("配置的maxDirectMemory：" + VM.maxDirectMemory() / (1024 * 1024) + "MB");
//        long totalMemory = Runtime.getRuntime().totalMemory();// java虚拟机内存总量 默认1/64
//        long maxMemory = Runtime.getRuntime().maxMemory();// jvm 最大内存值 默认1/4
//        System.out.println("total memory =" + totalMemory + "、" + (totalMemory / (1024 * 1024)));
//        System.out.println("max memory =" + maxMemory + "、" + (maxMemory / (1024 * 1024)));

        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(6 * 1024 * 1024);
    }
}
