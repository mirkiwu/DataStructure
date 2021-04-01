package com.hxh.set;

import com.hxh.tree.BinarySearchTree;

/**
 * @author huangxunhui
 * Date: Created in 18/10/17 上午10:30
 * Utils: Intellij Idea
 * Description: 基于 二分搜索树的tree
 */
public class BinarySearchTreeSet<E extends Comparable<E>> implements Set<E>  {

    private BinarySearchTree<E> bst;

    public BinarySearchTreeSet(){
        bst = new BinarySearchTree<>();
    }

    @Override
    public void add(E e) {
        bst.add(e);
    }

    @Override
    public void remove(E e) {
        bst.remove(e);
    }

    @Override
    public boolean contains(E e) {
        return bst.contains(e);
    }

    @Override
    public int getSize() {
        return bst.size();
    }

    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }
}
