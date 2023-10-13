package com.example.practice3;
/**
 * 判断素数
 * 总结: 素数的概念很重要,
 */
public class I_JudgePrime {
    /**
     * 如果N不能被2 ~ sqrt(N) 闭区间之间任一整数整除，那么N必定是素数
     * @param num
     * @return
     */
    public static boolean isPrime(int num) {
        boolean flag = false;
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) { //如果N不能被2 ~ sqrt(N) 之间任一整数整除，那么N必定是素数
                return false;
            }
        }
        return true;
    }
    /**
     * main方法, 从命令行接收参数
     * @param args
     */
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("请从命令行传入一个正整数作为参数:");
            return;
        }
        int n = 0;
        try {
            n = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            System.out.println("输入参数不合法, JVM 退出");
            return;
        }
        if (isPrime(n)) {
            System.out.println(n + " is prime number");
        } else {
            System.out.println(n + " is not prime number");
        }
    }
}
