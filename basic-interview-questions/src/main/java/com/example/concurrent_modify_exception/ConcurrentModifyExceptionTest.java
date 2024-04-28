package com.example.concurrent_modify_exception;

/**
 * @author gongchengship@163.com
 *
 * 多个线程同时修改 list 等线程不安全的集合时,
 * 会触发 List 的快速失败机制.
 * 多线程同时修改 modCont变量,会触发
 * ConcurrentModifyException
 */
public class ConcurrentModifyExceptionTest {

}
