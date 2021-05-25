package com.hxh.union_find;

/**
 * @author huangxunhui
 * Date: Created in 2018/12/1 下午3:29
 * Utils: Intellij Idea
 * Version:
 * Description: 并查集接口
 */
public interface UF {

    int getSize();

    boolean isConnected(int p , int q);

    void unionElements(int p , int q);
}
