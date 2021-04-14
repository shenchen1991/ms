package com.shenchen.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * @author 沈陈
 * @date 2021/03/26
 **/
public class Car implements InitializingBean, DisposableBean {
    public Car() {
        System.out.println("Car constructor...");
    }

    public void init() {
        System.out.println("car ---init");
    }

    public void destroy1() {
        System.out.println("car destroy1.....");
    }

    @Override
    public void afterPropertiesSet() throws Exception {

        System.out.println("afterPropertiesSet.....");

    }

    @Override
    public void destroy() throws Exception {
        System.out.println("destroy.....");
    }
}
