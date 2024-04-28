package com.example.list_oom_exception;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gongchengship@163.com
 *
 * 问下面的代码会输出啥?
 * Will lead to OOM exception
 */
public class ListOOMExceptionTest {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        for (int i = 0; i < list.size(); i++) {
            list.add(i);
            System.out.println(list.get(i));
        }

    }


}
