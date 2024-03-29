package com.example.anytest.aop_test;

import com.example.anytest.SleepHelper;
import org.springframework.stereotype.Component;

/**
 * @author gongchengship@163.com
 */

@Component
public class BusinessClassThree {

    public BusinessClassThree() {
        System.out.println("BusinessClassThree 的空构造器 执行 ....");
        Thread.dumpStack();
        System.out.println("BusinessClassThree 构造器 end");
    }
    private int mun = 1;
    public int getMun() {
        return mun;
    }
}
