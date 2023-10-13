package com.example.practice3;

/**
 * 二分法查找, 又叫折半查找, 其思想是:
 * 1. 每次与中间元素对比,如果大于中间元素,则搜索右半区,如果小于中间元素,则搜索左半区
 * 2. 这样每次都可以去掉一半的搜索范围
 * 3. 直到找到元素,或者搜索范围为空
 * 时间复杂度O(logn),空间复杂度O(1)。
 */
public class V_BinarySearch {
    public static void main(String[] args) {
        ////注意:二分法查找的前提是针对已排序的序列
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9,10};
        int n = arr.length;
        int x = 5; //要查找的值
        int low = 0;
        int high = n - 1;
        int mid = (low + high) / 2;;
        while (low <= high) { ////循环直到下标相撞
            mid = (low + high) / 2;
            if (arr[mid] == x) {
                System.out.println(mid); //找到了,输出位置
                break;
            } else if (arr[mid] > x) {
                high = mid - 1; //减小搜索范围,搜索左半区
            } else {
                low = mid + 1; //减小搜索范围,搜索右半区
            }
        }
    } //验证:5的位置是4,也就是说,如果key不在数组中,那么就返回-1.
}
