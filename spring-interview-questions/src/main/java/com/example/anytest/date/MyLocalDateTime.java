package com.example.anytest.date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @author gongchengship@163.com
 */
public class MyLocalDateTime {
    public static void main(String[] args) {
        // now()方法 获取当前时间
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();

        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localDateTime);

        // of()方法, 创建自定义时间
        LocalDate localDate1 = LocalDate.of(2020, 1, 1);
        LocalTime localTime1 = LocalTime.of(12, 12, 12);
        LocalDateTime localDateTime1 = LocalDateTime.of(localDate1, localTime1);
        LocalDateTime localDateTime2 = LocalDateTime.of(2020, 1, 1, 12, 12, 12);

        System.out.println(localDate1);
        System.out.println(localTime1);
        System.out.println(localDateTime1);
        System.out.println(localDateTime2);
        System.out.println(localDateTime2.toLocalDate());
        System.out.println(localDateTime2.toLocalTime());

        // getXxx()方法 获取 年 \月 \日 \时 \分 \秒

        // withXxx()方法 返回一个全新的对象, 也体现了 LocalDateTime 对象的 不可变性

        // plusXxx()方法

    }
}
