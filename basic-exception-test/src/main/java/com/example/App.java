package com.example;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
        System.out.println(test());
    }

    /**
     * 将会 return 1
     * @return int
     */
    private static int test() {
        int x;
        try {
            x = 1;
            //在return之前,会将x的值作为"returnValue"缓存起来,将finally块中的语句插入到return之前来执行,
            //详细过程可查看字节码指令,或者<<深入理解Java虚拟机>>第三版 237页.
            return x;
        } catch (Exception e) {
            x = 2;
            return x;
        } finally {
            x = 3;
            //return x; // 这里加上一行return,程序将返回3.
        }
    }
}
