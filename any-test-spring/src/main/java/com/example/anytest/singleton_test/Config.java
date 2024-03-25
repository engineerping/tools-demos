package com.example.anytest.singleton_test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author gongchengship@163.com
 */
@ComponentScan(basePackages = "com.example.anytest.singleton_test")
public class Config {

    @Bean
    public OneClass oneClass1(){
        return new OneClass();
    }

    @Bean
    public OneClass oneClass2(){
        return new OneClass();
    }

}
