package com.example.practice3;

public class IV_ArraySort {
    public static void main(String[] args) {
        int[] arr = {1, 10, 3, 4, 5, 6, 7, 8, 9, 2};
        int temp;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) { //重点 int j = i + 1; j < arr.length;
                if (arr[i] > arr[j]) { //如果前面的数大于后面的数
                    ////交换前后两个数 start
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    ////交换前后两个数 end
                } ////否则，不需要交换
            }
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

}
