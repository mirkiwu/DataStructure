package com.hxh.union_find;

/**
 * @author huangxunhui
 * Date: Created in 2018/12/1 下午4:23
 * Utils: Intellij Idea
 * Version:
 * Description: 使用树结构
 */
public class UnionFind2  implements UF {

    private int[] parent;

    public UnionFind2(int size){
        parent = new int[size];

        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
    }


    @Override
    public int getSize() {
        return parent.length;
    }

    // 查找过程，查找元素P所对应的集合编号
    //O(h)复杂度,h为树的深度
    private int find(int p){
        if(p < 0 || p > parent.length){
            throw new IllegalArgumentException("p is out of bound.");
        }
        while(p != parent[p]){
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public void unionElements(int p, int q) {
        int qRoot = find(q);
        int pRoot = find(p);
        if(pRoot == qRoot){
            return;
        }
        parent[pRoot] = parent[qRoot];
    }

}
