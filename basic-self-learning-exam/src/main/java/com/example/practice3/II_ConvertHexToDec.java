package com.example.practice3;
/**
 * 通过命令行,接收 16 进制数,不使用库函数,将 16 进制数转换成 10 进制,并输出
 */
public class II_ConvertHexToDec {
    /**
     * 将 16 进制数转换成 10 进制数
     * @param arg
     */
    public static void convert16To10(String arg) {
        double int10 = 0D;
        char[] chars = arg.toCharArray();
        int k = 1; //万一输入是负数
        for (int i = 0; i < chars.length; i++) {
            char unit = chars[i];
            if ('-' == unit) {
                k = -1;
            } else if (unit >= '0' && unit <= '9') {
                unit = (char) (unit - '0');
            } else if (unit >= 'A' && unit <= 'F') {
                unit = (char) (10 + unit - 'A');
            } else {
                System.out.println("您所输入的 " + arg + " 并不是一个合法的十六进制数, JVM 退出");
                System.exit(0);
            }

            int10 = (unit * Math.pow(16, chars.length - i - 1)) + int10;
            int10 = k * int10;
        }
        System.out.println("输入的十六进制数是 " + arg.toUpperCase() + ", 转换成的十进制数是 " + int10);
    }
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("请从键盘输入一个十六进制数");
            return;
        }
        String str = args[0].toUpperCase();
        convert16To10(str);
    }
}
