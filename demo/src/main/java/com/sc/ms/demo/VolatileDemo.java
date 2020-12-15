package com.sc.ms.demo;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 */
class MyData {

    volatile int a = 1;

    public void addTo60() {
        this.a = 60;
    }

    public void addPlus() {
        a++;
    }


    AtomicInteger atomicInteger = new AtomicInteger();

    public void addAtomic(){
        atomicInteger.getAndIncrement();
    }
}

/**
 * volatile 演示
 *
 * @author 沈陈
 * @date 2020/11/26
 */
public class VolatileDemo {
    public static void main(String[] args) {

        MyData myData = new MyData();

        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    myData.addPlus();
                    myData.addAtomic();
                }

            }, String.valueOf(i)).start();
        }
        // 等待线程计算完成
        while (Thread.activeCount() > 2) {
            Thread.yield();
        }

        System.out.println(Thread.currentThread().getName() + "\t int type number value :" + myData.a);
        System.out.println(Thread.currentThread().getName() + "\t AtomicInteger type number value :" + myData.atomicInteger);

    }


    /**
     * volatile 可见性
     */
    private static void seeOkVolatile() {
        MyData myData = new MyData();
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t come in");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myData.addTo60();
            System.out.println(Thread.currentThread().getName() + "\t update number value:" + myData.a);
        }, "AAA").start();

        while (myData.a == 0) {
            //TODO
        }

        System.out.println(Thread.currentThread().getName() + "\t mission is over");
    }
}
