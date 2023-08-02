package com.example.two_big_dicinmal_sum;

/**
 * Hello world!
 * 题：计算 2 个大数相加
 * https://www.nowcoder.com/practice/11ae12e8c6fe48f883cad618c2e81475?tpId=295&tqId=1061819&ru=
 * /exam/oj&qru=/ta/format-top101/question-ranking&sourceUrl=%2Fexam%2Foj
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s= "777";
        String t= "333";
        System.out.println(solution.solve(s, t));
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 计算两个数之和
     * @param s string字符串 表示第一个整数
     * @param t string字符串 表示第二个整数
     * @return string字符串
     */

    public String solve (String s, String t) {
        // write code here
        //比较输入的 2 个数组获取两个数组中最长的一个的 length + 1, 暂时 hardcode
        int largerLength = s.length() - t.length() > 0 ? s.length() : t.length();
        int length = largerLength + 1; //加 1位 用于存储最高位的进位信息。

        //注意Java中 char 占用 2 Byte; Java中int占用 4 Byte 。
        //而尽管物理上能存下，但是还得新定义 int[] 数组，否则语法上过不去。
        char[] charArrayS = s.toCharArray();
        char[] charArrayT = t.toCharArray();

        int[] arrayS = charArray2IntArray(charArrayS);
        int[] arrayT = charArray2IntArray(charArrayT);


        int[][] temp = new int[length][3]; //用 二维数组中子数组的尾部存放每一位的进位信息

        for (int i = 0; i < length; i++) {
            if(arrayS.length - i > 0) {
                temp[i][0] = arrayS[arrayS.length -1 - i];
            }

            if(arrayT.length - i >0) {
                temp[i][1] = arrayT[arrayT.length -1 - i];
            }

            int unit = temp[i][0] + temp[i][1] + temp[i][2];

            if(unit > 9) { //进位
                temp[i][2] = unit - 10;
                temp[i+1][2] = 1; //两个数相加temp[i][2]只可能是 0 或者 1
            } else {
                temp[i][2] = unit;
            }

        }
        int result = 0;
        StringBuilder stringBuilder = new StringBuilder();
        if (temp[temp.length - 1][2] != 0) {
            stringBuilder.append(temp[temp.length - 1][2]);
        }

        for (int j = temp.length - 2; j >= 0; j--) { //从最高位的下一位开始循环
            stringBuilder.append(temp[j][2]);
        }
        return stringBuilder.toString();
    }
    private int[] charArray2IntArray(char[] charArray) throws RuntimeException {
        int[] intArray = new int[charArray.length];
        for (int i = 0; i < charArray.length; i++) {
            intArray[i] = charArray[i] - '0'; // 利用这种简易的方式将 char 的字面量（并非 ACSII值）转换成 int
        }
        return intArray;
    }
}
