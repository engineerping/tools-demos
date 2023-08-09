package com.example.dynamic_proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * (面对调用方的调用的)实际执行者
 * 谁调用我,我就操纵谁的调用(让它去调用个替身)
 * @param <T>
 */
public class LoggerProxy<T> implements InvocationHandler {
    private T target;

    public LoggerProxy() {
    }

    public LoggerProxy(T target) {
        this.target = target;
    }

    /**
     * 写代码的时候:相当于一个简单的配置文件,(这是一个模板方法),程序员实现此方法,用以告诉JDK如何去增强原始方法(被代理方法),
     * 运行的时候:当其他方法调用了假对象(代理对象)的方法的时候,会调用到该invoke方法，
     *
     * @param proxy  the proxy instance that the method was invoked on
     * @param method the {@code Method} instance corresponding to
     *               the interface method invoked on the proxy instance.  The declaring
     *               class of the {@code Method} object will be the interface that
     *               the method was declared in, which may be a superinterface of the
     *               proxy interface that the proxy class inherits the method through.
     * @param args   an array of objects containing the values of the
     *               arguments passed in the method invocation on the proxy instance,
     *               or {@code null} if interface method takes no arguments.
     *               Arguments of primitive types are wrapped in instances of the
     *               appropriate primitive wrapper class, such as
     *               {@code java.lang.Integer} or {@code java.lang.Boolean}.
     * @return the value to return from the method invocation on the
     * proxy instance.  If the declared return type of the interface
     * method is a primitive type, then the value returned by
     * this method must be an instance of the corresponding primitive
     * wrapper class; otherwise, it must be a type assignable to the
     * declared return type.  If the value returned by this method is
     * {@code null} and the interface method's return type is
     * primitive, then a {@code NullPointerException} will be
     * thrown by the method invocation on the proxy instance.  If the
     * value returned by this method is otherwise not compatible with
     * the interface method's declared return type as described above,
     * a {@code ClassCastException} will be thrown by the method
     * invocation on the proxy instance.
     * @throws Throwable the exception to throw from the method
     *                   invocation on the proxy instance.  The exception's type must be
     *                   assignable either to any of the exception types declared in the
     *                   {@code throws} clause of the interface method or to the
     *                   unchecked exception types {@code java.lang.RuntimeException}
     *                   or {@code java.lang.Error}.  If a checked exception is
     *                   thrown by this method that is not assignable to any of the
     *                   exception types declared in the {@code throws} clause of
     *                   the interface method, then an
     *                   {@link java.lang.reflect.UndeclaredThrowableException} containing the
     *                   exception that was thrown by this method will be thrown by the
     *                   method invocation on the proxy instance.
     * @see java.lang.reflect.UndeclaredThrowableException
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws InvocationTargetException, IllegalAccessException {
        //System.out.println("The proxy is: " + proxy.getClass());
        System.out.println("Before invoke, input args are[" + args[0] + "," + args[1] + "]");
        Object ret = method.invoke(target, args); // 注意这里的invoke方法是java.lang.reflect.Method.invoke,而不是InvocationHandler.invoke
        System.out.println("After invoke, result value is " + ret);
        return ret;
    }

    /**
     * 调用Proxy类的静态方法newProxyInstance,
     * 该方法会"编写"一个实现了("原始接口的")代理类,
     * 并new 一个代理类的对象
     * 最后返回这个代理对象,
     * 程序员需要手动调用该代理对象的方法(会实际上调到InvocationHandler.invoke方法)
     * 传入:
     *      1.类加载器
     *      2.原始类的接口
     *      3.InvocationHandler的对象(或者叫做具体增强说明)
     *
     * @return 代理类的对象
     */
    public T getProxyInstance() {
        return (T)Proxy.newProxyInstance(
                                        //传入一个类加载器,用以把自动生成的代理类加载到JVM的方法区
                                        Thread.currentThread().getContextClassLoader(),
                                        //传入一个(组)接口,自动生成的代理类需要实现这个(组)接口
                                        target.getClass().getInterfaces(),
                                        //传入 InvocationHandler接口的实例
                                        this);
    }
}
