# 知识点：
无论 . 
1. 继承Thread 类、  
2. 实现 Runnable、  
3. 实现 Callable。  
底层都是一样:  
**构造一个Thread类的对象，重写了run 方法，调用start 方法启动线程。**