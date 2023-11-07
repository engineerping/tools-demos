package com.example.extendstest;

public class Test {
    public static void main(String[] args) {
        Clothes clothes = new Clothes(9);
        Cat cat = new Cat(clothes); // 这里专门给 2 个 cat set 了 同一个 clothes 对象,以模拟与 clone 方法相同的内存状态
        Cat cat1 = new Cat(clothes);

        int catClothesColor;
        int catClothesColor1;
        cat1.getClothes().setColor(1); //给被 clone 的猫的衣服涂上新颜色. 注意这里没有 setClothes, 即没有给猫换另一件衣服
        catClothesColor = cat.getClothes().getColor();
        catClothesColor1 = cat1.getClothes().getColor();

        System.out.println(cat.getClothes().hashCode()); //检查 2 个猫的衣服 的 hashcode
        System.out.println(cat1.getClothes().hashCode());
        System.out.println(catClothesColor); //打印 2 个猫的衣服的颜色
        System.out.println(catClothesColor1);
        System.out.println(catClothesColor1 == catClothesColor); //检查 2 个猫的衣服的颜色是否一致
        // 以上这一点测试,以 clone方法(浅 copy 的结果一致)

        Cat cat2 = new Cat(new Clothes(9));
        Cat cat3 = new Cat();
        System.out.println(cat2.getClothes().hashCode()); //检查 2 个猫的衣服 的 hashcode
        //System.out.println(cat3.getClothes().hashCode()); //这里会因为 cat3 的 getClothes 并没有值, 而报 NullPointerException
        // 可见继承同一个父类的两个子类,其父类中的字段 并不是共享的. 而是每个子类都有自己的.
        //每个子都占用这么大的内存空间 即:"父类对象所需的内存空间大小 + 自身所需的内存空间大小"
    }
}
