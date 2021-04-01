package com.hxh.set;

/**
 * @author huangxunhui
 * Date: Created in 18/10/17 上午10:27
 * Utils: Intellij Idea
 * Description: 集合
 */
public interface Set<E> {

    /**
     * 添加元素
     * @param e 元素
     */
    void add(E e);

    /**
     * 删除元素
     * @param e e
     */
    void remove(E e);

    /**
     * 查看是否相同
     * @param e e
     * @return 返回true 或者 false
     */
    boolean contains(E e);

    /**
     * 获取元素的个数
     * @return 返回个数
     */
    int getSize();

    /**
     * 判断set是否为空
     * @return 返回true 或者 false
     */
    boolean isEmpty();
}
