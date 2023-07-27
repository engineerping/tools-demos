package com.example.class_loader_flow;

/**
 *
 *文字描述:
 * XXX.class 文件存在某个地方,(不管它是javac 编译产生的,还是直接手写的二进制文件;也不管这个文件存在在本地磁盘,还是在网络上。
 *
 * java XXX.class,等主动使用类的行为会出发类被初始化,初始化前需要加载类。
 *
 * 类的加载分为3大步骤:
 * 	1.加载Loading: 找到class字节码文件,将class文件的二进制内容加载到JVM指定的的内存中。
 *      体而言,就是调用findClass(final String name)方法找到class文件的位置,
 *      用BateArrayStream存放数据
 * 		调用defineClass()执行必要步骤
 * 		调用super.()返回class文件
 * 	2.连接Linking:
 * 		2.1.验证Verification: 验证class文件中的内容是否符合规范,例如是否以二进制
 *     1100 1010 1111 1110 1011 1010 1011 1110    开头(即十六进制CAFEBABE)
 * 		2.2.准备preparation: 给cLass文件中的static 变量赋默认值。
 * 		    例如: 将
 * 			     pubic static int myNumber;
 * 		             public static String myStr;
 * 			     赋值成
 * 			     pubic static int myNumber = 0;
 * 		             public static String myStr = null;
 * 		    注意:正因如此,所以在调用类的静态变量时,不会出发类的初始化initializing
 * 		2.3.解析resolution: 将class文件中的常量池用到的符号引用替换为可访问的内存地址
 * 		    注意:解析resolution步骤会先于初始化initializing开始,但接下可能会与初始化initializing步骤交替进行。
 * 			  正因如此,多态(运行时绑定)的语法才能得到支持.多态不就是在运行时决定一个引用实际应该指向哪个类的对象吗!!!
 * 	3.初始化initializing
 * 		开始执行static 语句,或者static代码块,给static 变量赋程序员指定的值。
 * 		具体来说:
 * 		执行类的初始化器<clinit>()方法【注意不是类的构造器constructor方法】的过程.类的初始化器<clinit>()方法是有编译期间自动收集类中所有的类变量的赋值动作与静态代码块中的语句合理合并产生的。
 * 		当初始化一个类的时候，如果发现其父类还没有进行初始化，则需要先出发其父类的初始化。
 * 		虚拟机会保证一个类的<clinit>()方法在多线程环境中被正确枷锁和同步。
 * 	4.类加载的产品是:
 * 		1.方法区的class类的对象(注意class类的对象是存在方法区而不是堆区,方法区落地对于JDK8而言是元数据区meta-space,对于JDK7而言是永久代Permanent generation ),
 * 		class类的对象是class的二进制文件内容的访问接口
 *
 * 2.JVM内存中的class的二进制文件内容
 *
 */
public class CLassLoadingFlow {

    static {
        System.out.println("静态代码(块) 链接阶段 的准备子阶段 分配内存,设置JVM 规定的默认初始值");
        num = 300;
    }

    static int num = 100;
    int i = 20;
    static {
        int i = 500;
    }
    public CLassLoadingFlow() {
        System.out.println("类的无参构造器 ");
    }
}

class Test {
    public static void main(String[] args) {
//        CLassLoadingFlow cLassLoadingFlow = new CLassLoadingFlow();
//        System.out.println(cLassLoadingFlow.i);
//        System.out.println(cLassLoadingFlow.num);
        String s = "ABC";
        String[] sa = s.split(".");
        System.out.println(sa);

    }
}
