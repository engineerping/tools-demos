package com.example.clonetest;

public class Test {
    public static void main(String[] args) {
        Cat cat = new Cat(5); // age 存储在栈中, 是不共享的
        // clothes的引用存储在栈中 是不共享的,
        // 然而两个 clone 对象的栈中如果存储的引用指向相同,则它们指向同堆内存中的同一个对象所占的内存空间.
        Clothes tshirt = new Clothes(9); //创建一个颜色号为 9 的衣服
        cat.setClothes(tshirt);

        Cat cat1 = cat.clone();


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

        // 可以看到出现了问题:
        // 给一只猫的衣服涂上新颜色, 则另一只猫的衣服的颜色也被修改该了. 因为 clone 方法 是 浅copy
        // 如果想要 深copy, 需要在 `cat1.getClothes().setColor(1);` 这句之前先执行 cat1.setClothes(new Clothes), 但是值能满足一层深 copy
        // java 中彻底实现 深 copy ,要借助 Serializable 接口进行序列化
    }
}
