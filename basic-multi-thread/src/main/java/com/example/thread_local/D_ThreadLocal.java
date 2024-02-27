package com.example.thread_local;

import com.example.SleepHelper;

/**
 * @author gongchengship@163.com
 */
public class D_ThreadLocal {
    static ThreadLocal<M> tl = new ThreadLocal<>();
    public static void main(String[] args) {

        new Thread(() -> {
            SleepHelper.sleepSecond(1);
            tl.set(new M()); //一般来说,set 进去的 value 都是在这个括号里 new 的
        });
    }
}
