package com.example.practice3;

import java.util.Random;

public class VI_RandomNumberCreator {
    /**
     * 生成随机整数
     * @param args
     */
    public static void main(String[] args) {
        int result = 0;
        result = new Random().nextInt(12);
        System.out.println(result);
    }
}
