package com.example.collectionstest.list;

import java.util.LinkedList;
import java.util.List;

/**
 * <p>TIPS: Character set of current file is "UTF-8",just in case of Chinese characters displays in garbled</p>
 * 描述:
 */
public class LinkedListTest {
    public static void main(String[] args) {
        List lst = new LinkedList();
        lst.add(1);
        lst.add(new Object().hashCode());
        lst.add(null);

        lst.forEach(System.out::println);
    }
}
