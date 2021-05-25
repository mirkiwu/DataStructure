package com.hxh.union_find;

/**
 * @author huangxunhui
 * Date: Created in 2018/12/1 下午3:38
 * Utils: Intellij Idea
 * Version:
 * Description: 使用数组
 */
public class UnionFind1 implements UF {
    private int[] id;

    public UnionFind1(int size){
        id = new int[size];

        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }
    }


    @Override
    public int getSize() {
        return id.length;
    }


    private int find(int p){
        if(p < 0 || p > id.length){
            throw new IllegalArgumentException("p is out of bound.");
        }
        return id[p];
    }

    // 查看元素 p 和 元素 q 是否所属同一个集合
    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public void unionElements(int p, int q) {
        int pId = find(p);

        int qId = find(q);

        if(pId == qId){
            return;
        }

        for (int i = 0; i < id.length; i++) {
             if(id[i] == pId){
                 id[i] = qId;
             }
        }
    }
}
