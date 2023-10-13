package com.example.practice3;

public class I_JudgePrime {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        if (isPrime(n)) {
            System.out.println(n + " is prime number");
        } else {
            System.out.println(n + " is not prime number");
        }
    }

    public static boolean isPrime(int num) {
        boolean flag = false;
        if (num <= 1) {
            return false;
        }

        for (int i = 2; i < num; i++) {
            if (num % i == 0) { //能被除了 1 和 自身之外的任何整数整除的数,就不是素数
                return false;
            }
        }

        ////方法二
        for (int i = 2; i < Math.sqrt(num); i++) {
            if (num % i == 0) { //如果N不能被2 ~ sqrt(N) 之间任一整数整除，那么N必定是素数
                return false;
            }
        }
        return true;
    }
}
