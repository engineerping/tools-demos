package com.example.practice3;
/**
 * 生成1-12之间的随机数,输出对应的月份
 */
public class VI_RandomIntGenerator {
    /**
     * 生成成指定范围内的随机整数
     * @param min
     * @param max
     */
    public static int randomIntGenerator(int min, int max) {
        long now = System.currentTimeMillis();
        //任意一个正整数, 用 x 对其取模, 得到的结果是 [0, x-1] 的范围内的一个随机整数
        int randomNum = (int)((now % (max - min + 1)) + min);

        return randomNum;
    }
    public static void main(String[] args) {
        int monthNumber = randomIntGenerator(1, 12);
        String[] months = {"January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"};

        System.out.println("随机数对饮的月份是: " + months[monthNumber - 1]);
    }
}
