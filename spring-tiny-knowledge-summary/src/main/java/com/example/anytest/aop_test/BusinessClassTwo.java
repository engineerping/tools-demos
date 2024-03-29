package com.example.anytest.aop_test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author gongchengship@163.com
 */

@Component
public class BusinessClassTwo {

    //@Autowired 要标注在set方法上 才会引起set方法被执行,否则spring会通过反射直接注入
    private BusinessClassThree businessClassThree;

    public BusinessClassTwo() {
        System.out.println("BusinessClassTwo 的空构造器 执行 ...");
        Thread.dumpStack();
        System.out.println("BusinessClassTwo 构造器 end");
    }

    public BusinessClassThree getBusinessClassThree() {
        return businessClassThree;
    }

    @Autowired
    public void setBusinessClassThree(BusinessClassThree businessClassThree) {
        System.out.println("setBusinessClassTwo.setBusinessClassThree() 执行 ...");
        Thread.dumpStack();
        this.businessClassThree = businessClassThree;
    }
}
