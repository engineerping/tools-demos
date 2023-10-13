package com.example.practice2;

import java.util.Scanner;

/**
 * 经典的鸡兔同笼问题 (注意这不是百钱买鸡问题),
 * 和
 * 百钱买鸡问题
 */
public class III_ChickensRabbitsInOneCage {
    public static void main(String[] args) {

        scanCoupleIntFromKeyboard();

        ////鸡兔同笼问题(10 只鸡, 1 只兔 共 11 个 头, 24 个脚)
        //chickensRabbitsInOneCage(11, 24);

        //System.out.println("-------------------------");

        ////百钱买鸡问题
        //dollar100BuyChicken();
    }

    public static void scanCoupleIntFromKeyboard() {
        System.out.println("请在键盘上输入两个整数, 用英文逗号隔开~~:");
        Scanner scanner = new Scanner(System.in);
        String inputStr = "0 , 0";
        while(scanner.hasNextLine()) {
            inputStr = scanner.nextLine();
            int[] intArray = parseIntValue(inputStr);
            ////business start
            chickensRabbitsInOneCage(intArray[0], intArray[1]);
            ////business end
            System.out.println("再来一遍, 请在键盘上输入两个整数, 用英文逗号隔开~~:");

        }
        scanner.close();
    }

    public static int[] parseIntValue(String coupleValue) {
        String[] coupleValues = coupleValue.split(",");

        int[] coupleIntValues = new int[coupleValues.length];
        for (int i = 0; i < coupleValues.length; i++) {
            coupleIntValues[i] = Integer.parseInt(coupleValues[i]);
        }
        return coupleIntValues;
    }

    /**
     * 鸡兔同笼问题,在程序中直接写一元二次方程组 的表达式即可 (注意这不是百钱买鸡问题)
     * 其二元一次方程组表示为
     * heads = chicken + rabbit
     * foots = 2chicken + 4rabbit;
     * 代入消元法解为:
     * rabbit = (foot - 2 * head) / 2 ;
     * chicken = head - rabbit;
     * 直接将求解表达式写在程序中即可
     *
     * @param head
     * @param foot
     */
    public static void chickensRabbitsInOneCage(final int head, final int foot) {
        int chicken = 0;
        int rabbit = 0;

        rabbit = (foot - 2 * head) / 2 ;
        chicken = head - rabbit;

        System.out.println("鸡有:" + chicken + "只");
        System.out.println("兔有:" + rabbit + "只");

    }

    /**
     * 百钱买鸡问题:
     * 有公鸡5元一只,母鸡3元一只,小鸡1元三只,用100元买百鸡,问公鸡、母鸡、小鸡各可买多少只?
     *
     * 注意,百鸡问题是利用了计算机善于计算重复问题的 穷举法:
     * 程序中的 22, 33 这 2 个数字分别指不买其他鸡的情况下,最多能买 22 只公鸡, 33 只母鸡, 小鸡数量则由总数减去公鸡数量和母鸡数量得出
     */
    public static void dollar100BuyChicken() {
        for (int x = 0; x <= 20; x++) {
            for (int y = 0; y <= 33; y++) {
                int z = 100 - x - y;
                if (5 * x + 3 * y + z / 3 == 100) {
                    System.out.println("公鸡:" + x + "只");
                    System.out.println("母鸡:" + y + "只");
                    System.out.println("小鸡:" + z + "只");
                }
            }
        }
    }

}
