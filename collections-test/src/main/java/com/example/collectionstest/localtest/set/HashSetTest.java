package com.example.collectionstest.localtest.set;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>TIPS: Character set of current file is "UTF-8",just in case of Chinese characters displays in garbled</p>
 * 描述:
 */
public class HashSetTest {
    public static void main(String[] args) {
        Set st = new HashSet(16);
        st.add(1);
        st.add(new Object());
        st.add(null);

        st.forEach(System.out::println);

    }

}
