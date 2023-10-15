package com.example.practice4;
/**
 * 学校类
 */
public class School{
    /** 学校的录取分数线 */
    private static int scoreLine;

    public static int getScoreLine() {
        return scoreLine;
    }

    public static void setScoreLine(int scoreLine) {
        School.scoreLine = scoreLine;
    }
}
