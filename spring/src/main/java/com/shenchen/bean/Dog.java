package com.shenchen.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author 沈陈
 * @date 2021/03/26
 **/
@Component
public class Dog {
    public Dog() {
        System.out.println("constructor....");
    }

    @PostConstruct
    public void init() {
        System.out.println("Dog ---init");
    }

    @PreDestroy
    public void destroy1() {
        System.out.println("Dog destroy1.....");
    }

}
