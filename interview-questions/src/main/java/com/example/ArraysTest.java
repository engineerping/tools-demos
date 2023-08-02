package com.example;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 给定 String "ABCDBBCDCDD"
 * 要求返回 "DDDDBBBCCCA"
 *
 * 即字符串中的 char 排序：
 * 出现次数最多的排在前面，如果一样多则按 ASCII 码顺序自然递增排列
 */
public class ArraysTest {
    public static void main(String[] args) {
        new ArraysTest().test();
    }

    void test() {
        String str = "ABCDBBCDCDD";
        char[] charArray = str.toCharArray();

        Map<Character, LinkedList<Character>> mapLinkedList = new HashMap<>();

        char base;

        for (int i = 0; i < charArray.length; i++) {
            base = charArray[i];
            mapLinkedList.putIfAbsent(base, new LinkedList<>());  // 如案中不存圤则添加
            mapLinkedList.get(base).add(base);  // 向 Map 中所存储的 LinkedList 中添加元素
        }

        LinkedList<Character> characters = mapLinkedList.values().stream()
                .sorted((v1, v2) -> v2.size() - v1.size()) // 按 Map 中的 List 长度排序
                .sorted((v3, v4) -> v3.get(0) - v4.get(0)) // 再将 List 按照其中所存储的元素排序 的 ASCII 码升序排列
                .flatMap( (l) -> { //将众多的 LinkedList 拼接成一个 LinkedList
                    LinkedList<Character> linkedList = new LinkedList<Character>();
                    linkedList.addAll(l);
                    return linkedList.stream();
                })
                .collect(Collectors.toCollection(() -> new LinkedList<Character>()));

        String resultStr = characters.stream().map(String::valueOf).collect(Collectors.joining());
        System.out.println(resultStr);

    }


}
