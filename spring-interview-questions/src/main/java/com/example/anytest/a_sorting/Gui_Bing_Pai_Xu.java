package com.example.anytest.a_sorting;

/**
 * @author gongchengship@163.com
 * Input: l1 = [1,2,4], l2 = [1,3,4]
 * Output: [1,1,2,3,4,4]
 */
public class Gui_Bing_Pai_Xu {

    public static void main(String[] args) {
        int[] intArray1 = new int[] {1,4,9};
        int[] intArray2 = new int[] {1,2,3};

        int resultLength = intArray1.length + intArray2.length;
        int[] result = new int[resultLength];

        int i = 0;
        int j = 0;
        int k = 0;

        //先加入数组
        while(i < intArray1.length && j < intArray2.length && k < result.length) {
            int kp = k + 1;
            if (intArray1[i] < intArray2[j]) {
                result[k] = intArray1[i];
                result[kp] = intArray2[j];
            } else if (intArray1[i] > intArray2[j]) {
                result[k] = intArray2[j];
                result[kp] = intArray1[i];
            } else {
                result[k] = intArray1[i];
                result[kp] = intArray2[j];
            }
            System.out.println(result[k]);
            System.out.println(result[kp]);
            i++;
            j++;
            k = k + 2;
        }

        //再冒泡排序一下
        int[] last = maoPao(result);


    }

    /**
     * 冒泡排序
     * @param args
     * @return
     */
    public static int[] maoPao(int[] args) {

        int position = 0;
        while (position < args.length - 1) {
            int jump = args[position];
            if (jump > args[(position)]) {
                int temp = args[(position + 1)];
                args[(position + 1)] = args[position];
                args[position] = temp;
            } else {
                break;
            }
            System.out.println(args[position]);
            position++;
        }
        return args;
    }

}
