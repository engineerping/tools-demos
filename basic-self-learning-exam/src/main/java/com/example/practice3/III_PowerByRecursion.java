package com.example.practice3;
/**
 * 用递归的方式计算 X 的 n 次方
 */
public class III_PowerByRecursion {
    /**
     * 用递归的方式计算 X 的 n 次方
     * @param x
     * @param n
     * @return
     */
    public static double pow(int x, int n) {
        if (n == 0) { //递归结束条件
            return 1D;
        }
        if (n > 0) {
            return x * pow(x, n - 1); //递归调用
        }
        if (n < 0) {
            System.out.println("本程序暂未支持 负数作为 幂 的计算, JVM 退出");
            System.exit(0);
        }
        System.out.println("n 值不合法");
        System.exit(0); //退出程序, 不再执行后续的代码
        return 0D;
    }

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("当前输入参数不合法, JVM 退出, 请从命令行传入两个整数作为参数");
            return; //退出程序
        }
        int[] intArray = new int[2];
        for (int i = 0; i < 2; i++) {
            try {
                intArray[i] = Integer.parseInt(args[i]);
            } catch (NumberFormatException e) {
                System.out.println("输入参数不合法, JVM 退出");
                return;
            }
        }
        System.out.println(pow(intArray[0],intArray[1]));
    }
}
