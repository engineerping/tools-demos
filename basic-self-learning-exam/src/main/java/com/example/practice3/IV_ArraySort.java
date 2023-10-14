package com.example.practice3;
/**
 * 给数组排序
 */
public class IV_ArraySort {
    /**
     * 冒泡排序的思想是:
     * 1.两两比较相邻元素,如果顺序错误就交换位置
     * 2.一轮下来,最大的一个元素就会沉到最后的位置
     * 3.重复执行,直到排序完成
     * 时间复杂度 O(n^2),空间复杂度 O(1)。
     */
    public static void bubbleSort(int[] intArray) {
        int temp;
        for (int i = 0; i < intArray.length; i++) {
            for (int j = i + 1; j < intArray.length; j++) { //重点 int j = i + 1; j < intArray.length;
                if (intArray[i] > intArray[j]) { //如果前面的数大于后面的数
                    //交换前后两个数 start
                    temp = intArray[i];
                    intArray[i] = intArray[j];
                    intArray[j] = temp;
                    //交换前后两个数 end
                } //否则，不需要交换
            }
        }
        for (int i = 0; i < intArray.length; i++) {
            System.out.print(intArray[i] + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 10, 3, 4, 7, 6, 5, 8, 9, 2};
        bubbleSort(arr);
    }
}
