package com.hxh.queue;

/**
 * @author huangxunhui
 * Date: Created in 18/10/7 下午12:59
 * Utils: Intellij Idea
 * Description: 队列
 */
public interface Queue<E> {

    /**
     * 获取队列的长度
     * @return 长度
     */
    int getSize();

    /**
     * 是否为空
     * @return true 或者 false
     */
    boolean isEmpty();

    /**
     * 入队
     * @param e 数据
     */
    void enqueue(E e);

    /**
     * 出队
     * @return E
     */
    E dequeue();

    /**
     * 获取队列首数据
     * @return E
     */
    E getFront();
}
