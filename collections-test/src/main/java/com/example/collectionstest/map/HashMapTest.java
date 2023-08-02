package com.example.collectionstest.map;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>TIPS: Character set of current file is "UTF-8",just in case of Chinese characters displays in garbled</p>
 * 描述:
 */
public class HashMapTest {
    public static void main(String[] args) {
        Map mp = new HashMap();
//        Map mp = new HashMap(16);
        Object obj = new Object();
        mp.put(1, obj);
        mp.put(new Object(), obj);
        mp.put(null, obj);
        mp.put(null, obj);

        mp.keySet().stream().forEach(System.out::println);
    }
}
