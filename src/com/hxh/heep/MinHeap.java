package com.hxh.heep;

import com.hxh.array.Array;

/**
 * @author huangxunhui
 * Date: Created in 18/10/19 下午5:19
 * Utils: Intellij Idea
 * Description: 最小堆
 */
public class MinHeap<E extends Comparable<E>> {

    private Array<E> data;

    public MinHeap(int capacity){
        data = new Array<>(capacity);
    }

    public MinHeap() {
        data = new Array<>();
    }

    public MinHeap(E[] arr){
        data = new Array<>(arr);
        for (int i = parent(arr.length - 1); i >= 0 ; i--) {
            siftDown(i);
        }
    }

    /**
     * 返回堆中的元素个数
     * @return 个数
     */
    public  int size(){
        return data.getSize();
    }

    /**
     * 判断堆是否为空
     * @return 返回true 或者 false
     */
    public boolean isEmpty(){
        return data.isEmpty();
    }

    /**
     * 返回完全二叉树的数组表示中， 一个索引表示的元素的父节点的索引
     * @param index 索引
     * @return 返回父节点的索引
     */
    private int parent(int index){
        if(index == 0 ){
            throw new IllegalArgumentException("index-0 doesn't have parent");
        }
        return (index - 1 ) / 2;
    }

    /**
     * 返回完全二叉树的数组表示中， 一个索引表示的元素的左孩子的索引
     * @param index 索引
     * @return 返回左节点的索引
     */
    private int leftChild(int index){
        return (index * 2) + 1;
    }

    /**
     * 返回完全二叉树的数组表示中， 一个索引表示的元素的右孩子的索引
     * @param index 索引
     * @return 返回右节点的索引
     */
    private int rightChild( int index){
        return (index * 2 ) + 2;
    }

    public void add(E e){
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    private void siftUp(int k){
        while(k > 0 && data.get(k).compareTo(data.get(parent(k))) < 0){
            data.swap(k , parent(k));
            k = parent(k);
        }
    }


    public E findMin(){
        if(data.getSize() == 0){
            throw new IllegalArgumentException("Can not findMax when heap is empty");
        }
        return data.get(0);
    }

    //取出最小的元素
    public E extractMin(){
        E ret = findMin();
        data.swap(0 ,data.getSize() - 1);
        data.removeLast();
        siftDown(0);
        return  ret;
    }

    // TODO 需要修改
    private void siftDown(int k){
        while(leftChild(k) < data.getSize()){
            int j = leftChild(k);
            if(j + 1 < data.getSize() && data.get(j+1).compareTo(data.get(j)) < 0 ){
                j = rightChild(k);
            }

            if(data.get(k).compareTo(data.get(j)) <= 0){
                break;
            }
            data.swap(k , j);
            k = j;
        }
    }

    /**
     * 取出堆中最小的元素。并替换成元素e
     * @param e e
     * @return 返回最小元素
     */
    public  E replace(E e){
        E ret = findMin();
        data.set(0 , e);
        siftDown(0);
        return ret;
    }

    @Override
    public String toString() {
        return "MaxHeap{" +
                "data=" + data +
                '}';
    }
}
