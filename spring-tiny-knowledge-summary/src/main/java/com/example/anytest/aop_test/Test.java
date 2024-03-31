package com.example.anytest.aop_test;

import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author gongchengship@163.com
 */
@Component
public class Test implements CommandLineRunner, ApplicationContextAware {

    @Autowired
    private BusinessClassOne businessClassOne;


    ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(AopUtils.isAopProxy(businessClassOne));
        System.out.println(businessClassOne.doBusinessLogic(1, 2));
        BusinessClassOne businessClassOne = applicationContext.getBean(BusinessClassOne.class);
        int mun = businessClassOne.getBusinessClassTwo().getBusinessClassThree().getMun();
        System.out.println(mun);
        System.out.println(businessClassOne.doBusinessLogic2(3));

        // 证明容器中 存在DefaultAdvisorAutoProxyCreator 这种类型的 bean
        try {
            System.out.println(applicationContext.getBean(DefaultAdvisorAutoProxyCreator.class));
        } catch (Exception e) {
            // ignore
        }
        System.out.println(applicationContext.getBean(ApplicationContext.class));
    }

}
