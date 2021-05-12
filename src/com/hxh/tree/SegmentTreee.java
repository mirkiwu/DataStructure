package com.hxh.tree;

import com.sun.scenario.effect.Merge;

/**
 * @author huangxunhui
 * Date: Created in 2018/11/27 下午5:44
 * Utils: Intellij Idea
 * Version:1.0
 * Description: 线段树
 */
public class SegmentTreee<E> {

    private E[] tree;
    private E[] data;
    private Merge merger;

    public SegmentTreee(E[] arr , Merge merger){
        this.merger = merger;
        data = (E[]) new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }
        tree = (E[]) new Object[4 * arr.length];
        buildSegmentTree(0, 0 ,data.length - 1 );
    }

    public E get(int index){
        if(index < 0 || index > data.length){
            throw new IllegalArgumentException("index is illegal");
        }
        return data[index];
    }

    private int leftChild(int index){
        return index * 2 + 1;
    }

    private int rightChild(int index){
        return index * 2 + 2;
    }

    private void buildSegmentTree(int treeIndex , int l , int r){
        if(l == r){
            tree[treeIndex] = data[r];
        }

        int leftIndex = leftChild(treeIndex);

        int rightIndex = rightChild(treeIndex);

        int mid = l + (r - l) ;

        //构建左孩子
        buildSegmentTree(leftIndex , l , mid);
        //构建右孩子
        buildSegmentTree(rightIndex , mid + 1 , r );

//        tree[treeIndex] = merger.merge();

    }
}
