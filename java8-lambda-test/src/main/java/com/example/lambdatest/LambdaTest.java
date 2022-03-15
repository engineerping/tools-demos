package com.example.lambdatest;

import java.util.Arrays;
import java.util.Comparator;

public class LambdaTest {
    private static String[] stringArray = {"LiLei", "Haneimei", "Jim"};

    public static void main(String[] args) {
        testStaticImplementInterface();
    }

    private static void testStaticImplementInterface() {
        class ComparatorImpl implements Comparator<String> {
            @Override
            public int compare(String x, String y) {
                return x.length() - y.length();
            }
        }

        Comparator comparatorImpl = new ComparatorImpl();

        Arrays.sort(stringArray, comparatorImpl);
    }

    private static void testAnonymousInnerClass() {
        Arrays.sort(stringArray, new Comparator<String>() {
            @Override
            public int compare(String first, String second) {
                return first.length() - second.length();
            }
        });
    }

    private static void testLambda() {
        Arrays.sort(stringArray, (first, second) -> first.length() - second.length());
    }

    private static void testMethodReference() {
        Arrays.sort(stringArray, BiFunctionImpl::compare);
    }
}

class BiFunctionImpl {
    public static int compare(String x, String y) {
        return x.length() - y.length();
    }
}
