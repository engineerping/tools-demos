package com.example;

/**
 * <p>TIPS: Character set of current file is "UTF-8",just in case of Chinese characters displays in garbled</p>
 * 描述:
 *
 * for语句是循环控制结构中使用最广泛的一种循环控制语句，特别适合已知循环次数的情况。
 * 一般形式如下：
 * for ( [表达式 1]; [表达式 2 ]; [表达式3] )
 * 语句
 * 其中：
 * for语句
 * for语句
 * 表达式1：一般为赋值表达式，给控制变量赋初值；
 * 表达式2：关系表达式或逻辑表达式，循环控制条件；
 * 表达式3：一般为赋值表达式，给控制变量增量或减量；
 * 语句：循环体，当有多条语句时，必须使用复合语句。
 * 其执行过程如下：首先计算表达式1，然后计算表达式 2。若表达式2为真，则执行循环体；否则，退出 for循环，执行for循环后的语句。
 * 如果执行了循环体，则循环体每执行一次，都计算表达式3，然后重新计算表达式2，依此循环，直至表达式 2的值为假，退出循环。
 * for语句的三个表达式都是可以省略的，但分号“;”绝对不能省略。for语句有以下几种格式：
 * （1）for(; ;) 语句;
 * （2）for(;表达式2;表达式3 ) 语句;
 * （3）for(表达式1;表达式2;) 语句;
 * （4）for(i=1,j = n; i < j; i ++,j - - ) 语句;
 *
 */
public class BasicSyntaxTest {
    public static void main(String[] args) {
        for (int k = -5; k == (-1) ; k++) {
            System.out.println("OK");
        }
    }
}
