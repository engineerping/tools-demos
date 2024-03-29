package com.example.anytest.aop_test;

import com.example.anytest.SleepHelper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.aop.support.AopUtils;
import org.springframework.stereotype.Component;

import java.sql.Array;
import java.util.Arrays;

/**
 * @author gongchengship@163.com
 *
 * refer: https://www.51cto.com/article/710896.html
 */

@Aspect
@Component
public class MyAspect {

    AopUtils aopUtils;
    @Before(value = "execution(* com.example.anytest.aop_test.BusinessClassOne.doBusinessLogic(..))")
    public void beforeAdviceDemo() throws Throwable
    {
        System.out.println("before advice ...");
    }

    @Around(value = "@annotation(afterAnnotationDemo)")
    public int aroundAdviceDemo(ProceedingJoinPoint pjp , AfterAnnotationDemo afterAnnotationDemo)
    {
        System.out.println("around advice before...");
        SleepHelper.sleepSecond(1);
        try {
            System.out.println(afterAnnotationDemo.value());
            SleepHelper.sleepSecond(1);
            Integer result = (Integer) pjp.proceed(new Object[]{2});
            System.out.println(result);
            return result; //ProceedingJoinPoint is only supported for around advice
        } catch (Throwable e) {
            throw new RuntimeException(e);
        } finally {
            SleepHelper.sleepSecond(1);
            System.out.println("around advice after...");
            System.out.println("around advice finally...");
        }
    }
}
