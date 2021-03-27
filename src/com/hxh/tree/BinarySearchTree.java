package com.hxh.tree;

/**
 * @author huangxunhui
 * Date: Created in 18/10/12 下午1:56
 * Utils: Intellij Idea
 * Description: 二分搜索树
 */
public class BinarySearchTree<E extends Comparable <E> > {

    private class Node {

        public E e;

        public Node left;

        public Node right;

        public Node(E e) {
            this.e = e;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;

    private int size;

    public BinarySearchTree() {
        root = null;
        size = 0;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * 向二分搜索树中添加新的元素
     * @param e e
     */
    public void add(E e){
        root = add(root , e);
    }

    private Node add(Node node , E e){
        if(node == null){
            size++;
            return new Node(e);
        }
        if(e.compareTo(node.e) < 0 ){
            node.left = add(node.left,e);
        }else if(e.compareTo(node.e) > 0){
            node.right = add(node.right,e);
        }
        return node;
    }

    public boolean contains(E e){
        return search(root , e);
    }

    private boolean search(Node node , E e) {
        if(node == null){
            return false;
        }
        if(node.e.compareTo(e) == 0){
            return true;
        }
        else if(e.compareTo(node.e) < 0) {
            return search(node.left, e);
        }else if(e.compareTo(node.e) > 0) {
            return search(node.right, e);
        }
        return true;
    }
}
