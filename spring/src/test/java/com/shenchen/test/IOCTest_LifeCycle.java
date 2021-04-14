package com.shenchen.test;

import com.shenchen.config.MainConfigOfLifeCycle;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.event.EventListener;

/**
 * 测试类
 *
 * @author 沈陈
 * @date 2021/03/26
 **/
public class IOCTest_LifeCycle {

    @Test
    @EventListener
    public void test() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfLifeCycle.class);
        System.out.println("容器创建完成");
        applicationContext.getBean("dog");
        applicationContext.close();
    }
}
