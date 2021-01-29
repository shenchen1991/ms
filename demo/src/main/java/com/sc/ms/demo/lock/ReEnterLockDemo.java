package com.sc.ms.demo.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 重入锁
 *
 * @author 沈陈
 * @date 2021/01/09
 **/
public class ReEnterLockDemo {

    static Lock lock = new ReentrantLock();

    public static void main(String[] args) {

        Thread a = new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+" come in");
            LockSupport.park();// 被阻塞 等待通知等待放行，通过需要许可证
            System.out.println(Thread.currentThread().getName()+"被唤醒");
        },"a");
        a.start();

        Thread  b = new Thread(()->{
            LockSupport.unpark(a);
            System.out.println(Thread.currentThread().getName());
        },"b");
        b.start();
    }

}
