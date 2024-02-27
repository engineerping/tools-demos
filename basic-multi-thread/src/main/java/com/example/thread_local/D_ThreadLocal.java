package com.example.thread_local;

import com.example.Person;
import com.example.SleepHelper;

/**
 * @author gongchengship@163.com
 */
public class D_ThreadLocal {

    static ThreadLocal<Person> threadLocal_key_1 = new ThreadLocal<>();
    static ThreadLocal<Person> threadLocal_key_2 = new ThreadLocal<>();
    public static void main(String[] args) {

        new Thread(() -> {
            SleepHelper.sleepSecond(2);
            threadLocal_key_1.set(new Person("ZhangSan###"));
            threadLocal_key_2.set(new Person("Lisi!!!"));
            System.out.println("Do something 111");
            //System.out.println(threadLocal_key_1.get());
            //System.out.println(threadLocal_key_2.get());
            threadLocal_key_1.remove(); //防止内存泄漏
            threadLocal_key_2.remove(); //防止内存泄漏
            new Thread(() -> {
                SleepHelper.sleepSecond(1);
                threadLocal_key_1.set(new Person("WangWu$$$"));
                threadLocal_key_2.set(new Person("ZhaoLiu~~~"));
                System.out.println("Do something 222");
                System.out.println(threadLocal_key_1.get());
                System.out.println(threadLocal_key_2.get()); // Debug 在局部变量里可以看见 ThreadLocalMap 中存了 2 个 Person 对象，key 分别是 threadLocal_key_1 和 threadLocal_key_2; value 分别是 "WangWu" 和 "ZhaoLiu"，
                threadLocal_key_1.remove(); //防止内存泄漏
                threadLocal_key_2.remove(); //防止内存泄漏
            }).start();

            SleepHelper.sleepSecond(60 * 60 *12);
        }).start();


    }
}
