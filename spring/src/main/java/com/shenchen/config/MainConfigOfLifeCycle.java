package com.shenchen.config;

import com.shenchen.bean.Car;
import org.springframework.context.annotation.*;

/**
 * 生命周期配置类
 *
 *
 *
 *
 * @author 沈陈
 * @date 2021/03/26
 **/
@ComponentScan(basePackages = "com.shenchen.bean")
@Configuration
@EnableAspectJAutoProxy
public class MainConfigOfLifeCycle {

    @Bean(initMethod = "init",destroyMethod = "destroy1")
    public Car car(){
        return new Car();
    }
}
