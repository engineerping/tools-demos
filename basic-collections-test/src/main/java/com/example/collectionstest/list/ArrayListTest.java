package com.example.collectionstest.list;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>TIPS: Character set of current file is "UTF-8",just in case of Chinese characters displays in garbled</p>
 * 描述:
 */
public class ArrayListTest {
    public static void main(String[] args) {
        List lst = new ArrayList();
//        List lst = new ArrayList(10);
        lst.add(1);
        lst.add(new Object().hashCode());
        lst.add(null);

        lst.forEach(System.out::println);

    }

}
