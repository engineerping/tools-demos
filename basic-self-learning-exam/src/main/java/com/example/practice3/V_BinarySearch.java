package com.example.practice3;

/**
 * 折半查找,又叫二分法查找, 其思想是:
 * 1. 每次与中间元素对比,如果大于中间元素,则搜索右半区,如果小于中间元素,则搜索左半区
 * 2. 这样每次都可以去掉一半的搜索范围
 * 3. 直到找到元素,或者搜索范围为空
 * 时间复杂度O(log N),空间复杂度O(1)。
 */
public class V_BinarySearch {
    /**
     * 二分法查找,返回元素的下标,没有则返回-1,
     * @param arr, 指从该数组中查找
     * @param x, 指要查找的元素的值
     * @return
     */
    public static int binarySearch(int[] arr, int x) {
        //形参 arr, 指从该数组中查找; 形参x, 指要查找的元素的值
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) { //循环直到下标相撞
            int mid = (low + high) / 2; //不能整除的结果会向下取整,例如第一轮搜索时 (0 + 9)/2 = 4
            if (arr[mid] == x) {
                return mid; //找到了,返回位置
            } else if (arr[mid] > x) {
                high = mid - 1; //减小搜索范围,搜索左半区
            } else {
                low = mid + 1; //减小搜索范围,搜索右半区
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        //注意:二分法查找的前提是针对已排序的序列
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9,10};
        int index = binarySearch(arr, 3);
        if (index != -1) {
            System.out.println("找到元素素,下标为: " + index);
        } else {
            System.out.println("未找到元素");
        }
    }
}