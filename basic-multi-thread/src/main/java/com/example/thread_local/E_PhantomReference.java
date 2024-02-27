package com.example.thread_local;

/**
 * @author gongchengship@163.com
 * 虚引用，的用途就是帮助 JVM 通知操作系统，去回收 本地内存(本地内存由 MetaSpace + 用来提高 IO 效率的直接内存组成) 中的 直接内存的，
 * 为此马士兵展示了一个 sun.misc.Cleaner       extends       PhantomReference<Object> 的类
 * https://www.bilibili.com/video/BV1ZY4y1P799?p=6&vd_source=296138b5b3cfb93c548e36d81436eceb 第 10 分钟处
 */
public class E_PhantomReference {
}
