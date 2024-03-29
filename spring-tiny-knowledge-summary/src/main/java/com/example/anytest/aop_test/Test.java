package com.example.anytest.aop_test;

import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @author gongchengship@163.com
 */
@Component
public class Test implements CommandLineRunner {

    @Autowired
    private BusinessClassOne businessClassOne;

    @Autowired
    ApplicationContext applicationContext;
    @Override
    public void run(String... args) throws Exception {
        System.out.println(AopUtils.isAopProxy(businessClassOne));
        System.out.println(businessClassOne.doBusinessLogic(1, 2));
        BusinessClassOne businessClassOne = applicationContext.getBean(BusinessClassOne.class);
        int mun = businessClassOne.getBusinessClassTwo().getBusinessClassThree().getMun();
        System.out.println(mun);
        System.out.println(businessClassOne.doBusinessLogic2(3));
    }
}
