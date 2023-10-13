package com.example.practice2;
import java.util.Scanner;
/**
 * 求 a + aa + aaa + aaaa + aaaaa(n个) 的结果, 其中 a 为 1 - 9 之间的整数,例如当 a = 3, n = 4 时, 求 3 + 33 + 333 + 3333 的和
 */
public class I_SumTest {
    /**
     *  求 a + aa + aaa + aaaa + aaaaa(n个) 的结果, 其中 a 为 1 - 9 之间的整数
     * @param a
     * @param n
     * @return
     */
    public static int sumDuplicatingNumber(int a, int n) {
        //定义一个变量用来存放总和
        int sum = 0;
        //定义一个变量用来存放每个参加运算的数字
        int number = 0;
        for (int i = 0; i < n; i++) {
            //先算出每一个参加运算的数字
            number += Math.pow(10, i) * a; //Math.pow(x, y) 返回x的y次方,
            //再将每个数字相加求和
            sum = number + sum;
        }
        return sum;
    }

    /**
     * main 方法,包含扫描键盘输入的功能
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("请在键盘上输入两个整数, 用英文逗号隔开~~:");
        Scanner scanner = new Scanner(System.in);
        String inputStr = "0 , 0";
        while (scanner.hasNextLine()) { //判断键盘是否有输入enter 键盘
            inputStr = scanner.nextLine(); //读取键盘输入的一行
            int[] intArray = null;
            intArray = parseStringToIntArray(inputStr);

            //业务代码 start
            int summary = sumDuplicatingNumber(intArray[0], intArray[1]);
            if (summary > 1 * 1000000 ) {
                System.out.println("所输入的 a 值是: " + intArray[0] + ", n 值是: " + intArray[1] + ", 结果是: " + summary);
            } else if (summary > 0 && summary <= 1000000){
                System.out.println("!!!总和小于 1,000,000, 不输出");
            } else {
                throw new RuntimeException("请检查错误");
            }
            //业务代码 end

            System.out.println("再来一遍, 请在键盘上输入两个整数, 用英文逗号隔开~~:");
        }
        scanner.close();
    }

    /**
     * 将从键盘上输入的, 含逗号的字符串,转换成 int 类型的数组
     * @param coupleValueStr
     * @return
     */
    public static int[] parseStringToIntArray(String coupleValueStr) {
        String[] coupleValues = coupleValueStr.split(",");

        int[] coupleIntValues = new int[2];
        for (int i = 0; i < coupleValues.length; i++) {
            coupleIntValues[i] = Integer.parseInt(coupleValues[i]);
        }
        //a 取值为 1 - 9, 之间的整数.
        //同时,需要保证程序的正确性, 由于采用 int 类型存储总和，然而:
        //当 a 取最大值 9时, n 如果取 10，则累加和为11,111,111,100,已超过 Integer.MAX_VALUE(2,147,483,647),会造成上溢出；
        //当 a 取最大值 9时, n 如果取 9，则累加和为1,111,111,101, 小于Integer.MAX_VALUE(2,147,483,647),故 n 取值应不大于 9
        if( coupleIntValues[0] > 9 || coupleIntValues[0] < 1
                || coupleIntValues[1] > 9 || coupleIntValues[1] < 1) {
            System.out.println(("您输入的值已超过本程序可计算范围...JVM 退出"));
            System.exit(0);
        }
        return coupleIntValues;
    }
}