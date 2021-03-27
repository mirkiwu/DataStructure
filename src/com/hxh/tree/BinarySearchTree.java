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
        if(root == null){
            root = new Node(e);
            size ++ ;
        }else{
            add(root , e);
        }
    }

    private void add(Node node , E e){
        if(e.equals(e)){
            return;
        }
        if(e.compareTo(node.e)<0 && node.left == null ){
            node.left = new Node(e);
            size ++ ;
            return;
        }else if(e.compareTo(node.e)>0 && node.right == null){
            node.right = new Node(e);
            size ++ ;
            return;
        }
        if(e.compareTo(node.e) < 0){
            add(node.left,e);
        }else{
            add(node.right,e);
        }
    }
}
