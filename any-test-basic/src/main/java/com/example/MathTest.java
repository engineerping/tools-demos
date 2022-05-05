package com.example;

/**
 * <p>TIPS: Character set of current file is "UTF-8",just in case of Chinese characters displays in garbled</p>
 * 描述:
 */
public class MathTest {
    public static void main(String[] args) {
        int i = 1537351;
        int j = i / 1000;
        float k = i / 1000;
        System.out.println(j);
        System.out.println(k);
        System.out.println("-----");

        int l = i % 10;
        float m = i % 10;
        int n = i % 100_000_000;
        float o = i % 100_000_000;
        float p = 3 % 5;
        int p0 = 3 % 5;
        int p1 = 5 % 3;
        float q = 4 % 2;
        int r = 4 % 2;
        System.out.println(l);
        System.out.println(m);
        System.out.println(n);
        System.out.println(o);
        System.out.println("int 3 % 5 = " + p0);
        System.out.println("3 % 5 = " + p);
        System.out.println("5 % 3 = " + p1);
        System.out.println(q);
        System.out.println(r);
        System.out.println("-----");

        int f = 5 / 3;
        float g = 5 / 3;
        double h = 5 /3;
        System.out.println(f);
        System.out.println(g);
        System.out.println(h);
        System.out.println("-----");

        int f1 = 3 / 5;
        float g1 = 3 / 5;
        double h1 = 3 /5;
        System.out.println(f1);
        System.out.println(g1);
        System.out.println(h1);
        System.out.println("-----");


    }
}
