package com.example.collectionstest.iterator;

import java.util.ArrayList;
import java.util.List;

public class TestIterator {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        for (int i = list.size(); i > 0; i--) {
            list.remove(i);
        }

        System.out.println(list);
    }
}
