package com.example.anytest.aop_test;

import com.example.anytest.SleepHelper;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author gongchengship@163.com
 */

@Component
public class BusinessClassOne {

    //@Autowired 要标注在set方法上 才会引起set方法被执行,否则spring会通过反射直接注入
    private BusinessClassTwo businessClassTwo;
    AopUtils aopUtils;

    public BusinessClassOne() {
        System.out.println("BusinessClassOne 这个被代理类中 原始的空构造器会被执行吗?,基于继承的代理会执行; 如果是基于 接口代理呢,会执行吗?");
        Thread.dumpStack();
        System.out.println("BusinessClassOne 构造器 end");
    }
    /**
     * 这个方法被代理了
     * @param a
     * @param b
     * @return
     */
    public int doBusinessLogic(int a, int b) {
        return a + b;
    }

    @AfterAnnotationDemo("Hi")
    public int doBusinessLogic2(int a) {
        return a * 2;
    }
    public BusinessClassTwo getBusinessClassTwo() {
        return businessClassTwo;
    }

    @Autowired
    public void setBusinessClassTwo(BusinessClassTwo businessClassTwo) {
        System.out.println("setBusinessClassOne.setBusinessClassTwo() 执行 ...");
        SleepHelper.sleepSecond(1);
        Thread.dumpStack();
        this.businessClassTwo = businessClassTwo;
    }
}
