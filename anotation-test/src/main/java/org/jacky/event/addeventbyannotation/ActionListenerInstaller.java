package org.jacky.event.addeventbyannotation;

import java.awt.event.ActionListener;
import java.lang.reflect.*;

public class ActionListenerInstaller {
    /**
     * 传入一个对象，
     * 查找对象所属的类中标注了@ActionListenerFor的方法，并取出@ActionListenerFor注解的属性值。
     *
     *
     * @param obj
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     */
    public static void processAnnotation(Object obj) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class clazz = obj.getClass();
        Method[] methods = clazz.getDeclaredMethods();
        for (Method mt : methods) {
            ActionListenerFor al = mt.getAnnotation(ActionListenerFor.class);
            if (al != null) { //获取带有@ActionListenerFor注解的方法
                Field field = clazz.getDeclaredField(al.source()); //！！！根据field名称获取类中的某个field！！！
                field.setAccessible(true);
                Object fieldValue = field.get(obj); //！！！获取obj 对象的 该field 的值。！！！
                System.out.println(field.get(obj).getClass());
                System.out.println(field.get(obj).getClass().getSuperclass());
                Class[] interfaces = field.get(obj).getClass().getInterfaces();
                System.out.println("interfaces length: " + interfaces.length);
                for (Class c : interfaces) {
                    int i = 0;
                    System.out.println(String.format("%s %d is %s", c, i++, c.getName()));
                }
                addListener(fieldValue, obj, mt);
                String source = al.source();

            }
        }
    }

    /**
     *  
     * @param source
     * @param obj
     * @param m
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public static void addListener(Object source, final Object obj, final Method m) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        //这句话是为了让JDK所生成的class文件被保存下来，让程序员可读。
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        System.out.println("mark-1");

        InvocationHandler handler = new InvocationHandler() { //handler是匿名内部类(实现了InvocationHandler接口)的对象
            @Override
            //定义被代理类所要做的工作
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("The proxy is: " + proxy.getClass());
                System.out.println("The proxy's superClass is: " + proxy.getClass().getSuperclass());
                Class[] interfaces = proxy.getClass().getInterfaces();
                System.out.println("interfaces length: " + interfaces.length);
                for (Class c : interfaces) {
                    int i = 0;
                    System.out.println(String.format("interface %s %d is %s", c, i, c.getName()));
                }
                // 这里表示: 当某个（这里的某个最终是指ActionListener.class接口）接口中任意方法被调用的时候，
                // ！！！忽略方法本身，！！！
                // 而是执行addListener方法中所传入的 方法m(这里指ButtonFrameAnnotation类的renderGroundToYellow()方法)param 与 m

                 m.invoke(obj); //

                return null;
            }
        };

        //listener 是代理对象
        Object listener = Proxy.newProxyInstance(null, new Class[]{ActionListener.class}, handler); //null代表使用BootStrapClassLoader加载ActionListener.class类

        //相当于执行以下三行代码
        /**
         //yellowButton.addActionListener(yellowAction);
         //blueButton.addActionListener(blueAction);
         //redButton.addActionListener(redAction);
         */
        //获取source对象(yellowButton)所属的类,也就是JButton，进而获取yellowButton的类中指定的方法,方法名为addActionListener，参数列表为ActionListener.class，
        Method adder = source.getClass().getMethod("addActionListener", ActionListener.class);
        //执行source对象的javax.swing.AbstractButton.addActionListener(java.awt.event.ActionListener)方法
        adder.invoke(source, listener);
    }
}
