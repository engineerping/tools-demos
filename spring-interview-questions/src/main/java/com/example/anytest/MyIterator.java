package com.example.anytest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author gongchengship@163.com
 */
public class MyIterator {
    public static void main(String[] args) {
        List<Integer> myList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            myList.add(i);
        }

//        1.for i 一遍遍历,一边删除, 单线程-居然没问题
//        listByFori();

//      2.for-each 一边遍历,一边删除, 抛出 java.util.ConcurrentModificationException
//        listByForEach();

        iteratorByForEach();

    }

    public static void listByFori() {
        List<Integer> myList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            myList.add(i);
        }

        for (int i = 0; i < myList.size(); i++) {
            if (myList.get(i) % 2 == 0) {
                myList.remove(i);
            }
            System.out.println(myList.get(i));
        }
    }


    public static void listByForEach() {
        List<Integer> myList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            myList.add(i);
        }

        for (Integer item : myList) {
            if (item % 2 == 0) {
                myList.remove(item);
            }
            System.out.println(item);
        }
    }

    public static void iteratorByForEach() {
        List<Integer> myList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            myList.add(i);
        }

        Iterator<Integer> iterator =myList.iterator();

        while(iterator.hasNext()) {
            Integer item = iterator.next();
            if (item % 2 == 0) {
//            if (item == 5) {
                iterator.remove();
            }
        }

        System.out.println(myList);
    }
}
