package com.example.practice3;

/**
 * 用递归的方式计算 X 的 n 次方
 */
public class III_PowerByRecursion {
    public static void main(String[] args) {

        System.out.println(pow(2,-3));
        Double d  = Math.pow(2, -3);
        System.out.println(d); //验证


    }

    public static double pow(int x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n > 0) {
            return x * pow(x, n - 1);
        }
        if (n < 0) {
            return 1 / x * pow(x, n + 1);
        }

        System.out.println("n 值不合法");
        System.exit(0); //退出程序, 不再执行后续的代码

        return 0;
    }
}
