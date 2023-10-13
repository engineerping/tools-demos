package com.example.practice2;
import java.util.Scanner;
/**
 * 给定一个正整数 m, 判断它的具体位数,分别打印每一位数, 再按照逆序打印各位数字
 * 从键盘上输入正整数m,m的值不应该超过99999，否则给出错误信息
 */
public class II_AnalyseNumber {
    /**
     * 给定一个正整数m，判断它的具体位数，分别打印每一位数，再按照逆序打印各位数字
     * @param originalN
     */
    public static void analyseNumber(final int originalN) {
        int n = originalN; //存储原始数字,当你被更改后,必要时使 n = originalN
        int count = 0;

        //反复给数字除以 10, 直到数字为 0()
        while (n > 0) { //注意 0.1 转换成 int 等于 0 ,所以, 0 > 0 不合适,会导致循环退出, 这里也可以用 while(n >= 1)
            //while(n >= 1) {
            count++;
            n /= 10;
        }
        System.out.println("所输入的数字 " + originalN + " 有 " + count + " 位");

        //通过 % 求模运算, 从个位开始,求出每一位上的数字,存入数组
        int[] arr = new int[count];
        int index = 0;
        n = originalN;
        while (n > 0) {
            arr[index++] = n % 10;
            n /= 10;
        }

        //打印
        System.out.print("正序输出是:" );
        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println();
        System.out.print("逆序输出是: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println();
    }

    /**
     * main 方法,包含扫描键盘输入的功能
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("请在键盘上输入一个正整数~~:");
        Scanner scanner = new Scanner(System.in);
        int inputIntValue = 0;
        while(scanner.hasNextLine()) {
            inputIntValue = scanner.nextInt();
            //业务代码 start
            if (inputIntValue > 99999) {
                System.out.println("!!!输入的数字大于 99999,请重新输入");
                break;
            }
            analyseNumber(inputIntValue);
            //业务代码 end
            System.out.println("再来一遍, 请在键盘上输入一个正整数~~");
        }
        scanner.close();
    }
}
