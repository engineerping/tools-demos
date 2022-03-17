知识点：
无论
继承Thread 类、
实现 Runnable、
实现 Callable。
底层都是一样的：
构造一个Thread类的对象，重写了run 方法，调用start 方法启动线程。