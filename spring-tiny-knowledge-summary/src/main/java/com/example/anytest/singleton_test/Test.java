package com.example.anytest.singleton_test;

import lombok.Data;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author gongchengship@163.com
 */

public class Test{
//    @PostConstruct
//    public void fun() {
//        System.out.println("###");
//    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
//        OneClass oc = (OneClass) context.getBean("oneClass");
//        OneClass oc1 = (OneClass) context.getBean("oneClass1");
//
//        System.out.println(oc.hashCode() == oc1.hashCode());
//
//        OneClass s = context.getBean(OneClass.class);
//        System.out.println(s.hashCode());
//
//        System.out.println(oc.hashCode());
//        System.out.println(oc1.hashCode());

        System.out.println(context.getBean("oneClass"));
        System.out.println(context.getBean("oneClass1"));
        System.out.println(context.getBean("oneClass2"));
    }
}
