package com.hxh.stack;

/**
 * @author huangxunhui
 * Date: Created in 18/10/7 上午11:06
 * Utils: Intellij Idea
 * Description: 栈的实现
 */
public interface Stack<E> {

    /**
     * 添加数据
     * @param e 数据
     */
    void push(E e);

    /**
     * 取出数据
     */
    E pop();

    /**
     * 查看栈定的元素
     * @return E
     */
    E peek();

    /**
     * 获取容量
     * @return 容量
     */
    int getSize();

    /**
     * 判断是否为空
     * @return 返回true 或者false
     */
    boolean isEmpty();



}
