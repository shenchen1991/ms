package com.sc.ms.demo.jvm.outofmemory;

import java.util.concurrent.TimeUnit;

/**
 * 创建过多的线程
 *
 * @author 沈陈
 * @date 2020/12/25
 **/
public class UnableCreatNewThreadDemo {
    public static void main(String[] args) {
       for(int i = 1;;i++){
           System.out.println("**********************i："+ i);
           new Thread(()->{
               try {
                   TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }).start();

       }
    }
}
