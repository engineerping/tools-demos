package com.example.practice3;

import java.util.Arrays;

/**
 * 通过命令行,接收 16 进制数,不使用库函数,编写算法将 16 进制数转换成 10 进制,并输出
 */
public class II_Convert16To10 {
    public static void main(String[] args) {
        //args = Arrays.stream(args).map(String::toUpperCase).toArray(String[]::new);
        convert16To10("F");
    }

    public static void convert16To10(String arg) {
//        int int16 = Integer.parseInt(args[0], 16);
//        int int10 = Integer.parseInt(args[0], 10);

        ////方法二:
        //int int16 = 0x0;
        double int10 = 0D;
        //args = Arrays.stream(args).map(String::toUpperCase).toArray(String[]::new);
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
                System.out.println("Illegal input");
            }

            int10 = (k * (unit * Math.pow(16, chars.length - i - 1)) + int10);
        }
        System.out.println("输入的十六进制数是 " + arg.toUpperCase() + ", 转换成的十进制数是 " + int10);
    }

}
