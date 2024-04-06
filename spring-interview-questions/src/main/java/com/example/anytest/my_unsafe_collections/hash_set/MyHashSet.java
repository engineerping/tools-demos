package com.example.anytest.my_unsafe_collections.hash_set;

import java.util.HashSet;
import java.util.Set;

/**
 * @author gongchengship@163.com
 */
public class MyHashSet {
    public static void main(String[] args) {
        Set<Student> set = new HashSet<>();
        set.add(new Student("Jim", 18));
        set.add(new Student("Jim", 18));
        System.out.println(set.size());  //结果应是 1
    }
}
