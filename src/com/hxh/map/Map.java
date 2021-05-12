package com.hxh.map;

/**
 * @author huangxunhui
 * Date: Created in 18/10/17 下午3:02
 * Utils: Intellij Idea
 * Description: 映射
 */
public interface Map<K ,V> {

    /**
     * 向map中添加数据
     * @param k 键
     * @param v 值
     */
    void add (K k , V v);

    /**
     * 移除map中的数据
     * @param k 键
     * @return 删除的值
     */
    V remove(K k);

    /**
     * 判断map是否包含某个元素
     * @param k 键
     * @return 返回true 或者 false
     */
    boolean contains(K k);

    /**
     * 获取K 对应的V
     * @param k 键
     * @return 返回V
     */
    V get(K k);

    /**
     * 更新
     * @param k 键
     * @param v 值
     */
    void set(K k , V v);

    /**
     * 获取size
     * @return 返回size
     */
    int getSize();

    /**
     * 判断是否为空
     * @return 返回ture 或者 false
     */
    boolean isEmpty();

}
