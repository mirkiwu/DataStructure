package com.hxh.tree;


import java.util.Arrays;

/**
 * @author huangxunhui
 * Date: Created in 2018/11/27 下午5:44
 * Utils: Intellij Idea
 * Version:1.0
 * Description: 线段树
 */
public class SegmentTree<E> {

    private E[] tree;

    private E[] data;

    private Merger<E> merger;

    public SegmentTree(E[] arr , Merger<E> merger){
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

        // 为什么当l(左边界) = r(右边界) 是递归终止条件 ？
        // 当左边界和右边界相同时则说明，当前边界只有一个元素了，不能再进行细分成左右边界了
        if(l == r){
            tree[treeIndex] = data[l];
            return;
        }

        // 获取到当前的左孩子对应的下标
        int leftIndex = leftChild(treeIndex);

        // 获取到当前的右孩子对应的下表
        int rightIndex = rightChild(treeIndex);

        // 计算中间条件 
        int mid = l + (r - l) / 2 ;

        //整体构建流程是， 先把最左边的最边上的左孩子构建出来 ，然后构建右孩子，依次往回走
        //先构建左孩子 ，从左孩子开始 构建区间 l(默认是0) mid (中间区间)。
        buildSegmentTree(leftIndex , l , mid);

        //构建右孩子，传入的参数是 构建区间 mid + 1 , r (默认是 data.length - 1)。
        buildSegmentTree(rightIndex , mid + 1 , r );

        // 区间树 父节点，的结果为 左孩子和右孩子，合并的操作，比如求和。
        tree[treeIndex] = merger.merger(tree[leftIndex] , tree[rightIndex]);
    }

    public E query(int queryL , int queryR){
        if(queryL < 0 || queryL >= data.length ||
                queryR < 0 || queryR >= data.length){
            throw new IllegalArgumentException("index is illegal");
        }
        return query(0 , 0 , data.length-1 , queryL ,queryR);
    }

    public E query(int treeIndex , int l , int r , int queryL , int queryR ){

        // 递归终止条件， 当左右边界相同，返回数据
        if(queryL == l && queryR == r ){
            return tree[treeIndex];
        }

        /*
         *  1.计算中间值
         *  2.主要同来查看需要查询的区间，是在左边 还是右边，或者两边都有。
         */
        int mid = l + (r - l) / 2 ;

        /*
         * 计算当前节点的左孩子和右孩子
         * 主要作用：当需要查询的区间，的右边界 queryR 小于或等于 mid，这查询节点从左孩子开始，
         * 代码解析 ：query(leftTreeIndex ,l ,mid , queryL ,queryR );
         * 从左孩子开始查询 ，查询的边界是从 l(默认为0 ) 到 mid(计算出来的) ，queryL 查询左边界 ，queryR 查询右边界。
         */
        int leftTreeIndex = leftChild(treeIndex);

        /*
         * 计算当前节点的右孩子
         * 主要作用：当需要查询的区间，的左边界 queryL 大于或等于 mid，这查询节点从右孩子开始，
         * 代码解析 query(rightTreeIndex ,mid + 1 ,r , queryL ,queryR );
         * 从右孩子开始查询，查询边界是从 mid+1 开始 r (r的默认值是data.length - 1) ，queryL 查询左边界 ，queryR 查询右边界.
         */

        // 为什么会是mid+1
        // 假如区间是0-9 mid = r + (l - r ) / =  4 左区间为 0-4 右区间为5（mid + 1）-9

        int rightTreeIndex = rightChild(treeIndex);

        if(queryR <= mid){
            return query(leftTreeIndex ,l ,mid , queryL ,queryR );
        }else if(queryL >= mid+1){
            return query(rightTreeIndex ,mid + 1 ,r , queryL ,queryR );
        }

        // 如果需要查询的区间，不单独的存在于 左孩子 或者右孩子， 这需要查询出两个区间的数据，进行组合得出
        // 比如需要查询 2（queryL） - 5 (queryR) 区间内的数据，需要查出 2(queryL)- 4(mid)  区间内的数据，和 4(mid) - 5 (queryR)区间内的数据，进行组合


        // 查询在左边界的数据，在左边界内开始查询 ， l（默认是 0 ） ， mid  ，查询的范围是 queryL , mid
        E leftResult = query(leftTreeIndex , l , mid , queryL ,mid);

        // 查询在右边界的数据，在右边界内开始查询 , mid+1 , r (默认是 data.length - 1) 查询的范围是 ，mid+1 , queryR
        E rightResult = query(rightTreeIndex , mid + 1 , r , mid + 1 ,queryR);

        // 将左右的数据组合后返回。
        return merger.merger(leftResult ,rightResult);
    }

    public void set(int index , E e){
        if(index < 0 || index >= data.length){
            throw new IllegalArgumentException("index is illegal");
        }
        data[index] = e;
        set(0 ,0 , data.length - 1 , index , e);
    }

    public void set(int treeIndex , int l , int r , int index , E e ){

        if(r == l ){
            tree[treeIndex] = e;
            return;
        }

        // 获取到当前的左孩子对应的下标 ,
        int leftIndex = leftChild(treeIndex);

        // 获取到当前的右孩子对应的下表
        int rightIndex = rightChild(treeIndex);

        //计算中间变量，作用是判断index的位置是处于左边还是右边。
        int mid = l + (r - l) / 2 ;

        if(index >= mid + 1){
            set(rightIndex , mid+1 , r , index, e);
        }else if(index <= mid){
            set(leftIndex , l , mid , index, e);
        }

        tree[treeIndex] =  merger.merger(tree[leftIndex] ,tree[rightIndex]);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i = 0; i < tree.length; i++) {
            stringBuilder.append(tree[i] + ",");
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
