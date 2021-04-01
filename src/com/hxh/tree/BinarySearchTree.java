package com.hxh.tree;

import com.hxh.queue.LinkedListQueue;
import com.hxh.stack.LinkedListStack;

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

    public void preOrder() {
        traverse(root);
    }

    private void traverse(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.e + " ");
        traverse(node.left);
        traverse(node.right);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0, res);
        return res.toString();
    }

    public void generateBSTString(Node node, int depth, StringBuilder res) {
        if (node == null) {
            res.append(generateDepthString(depth) + "null\n");
            return;
        }
        res.append(generateDepthString(depth) + node.e + "\n");
        generateBSTString(node.left, depth + 1, res);
        generateBSTString(node.right, depth + 1, res);
    }

    private String generateDepthString(int depth) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            res.append("--");
        }
        return res.toString();
    }


    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.e + " ");
    }

    public void preOrderNR() {
        LinkedListStack<Node> stack = new LinkedListStack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node curl = stack.pop();
            System.out.println("stack:" + curl.e);
            if (curl.right != null) {
                stack.push(curl.right);
            }
            if (curl.left != null) {
                stack.push(curl.left);
            }
        }
    }

    public void levelOrder() {
        LinkedListQueue<Node> queue = new LinkedListQueue<>();
        queue.enqueue(root);
        while (!queue.isEmpty()) {
            Node curl = queue.dequeue();
            System.out.println("queue:" + curl.e);
            if (curl.left != null) {
                queue.enqueue(curl.left);
            }
            if (curl.right != null) {
                queue.enqueue(curl.right);
            }
        }
    }

    //寻找最小的元素
    public E minimum() {
        if (size == 0) {
            throw new IllegalArgumentException("BST is empty");
        }
        return minimum(root).e;
    }

    private Node minimum(Node node) {
        if (node.left == null) {
            return node;
        }
        return minimum(node.left);
    }

    //寻找最大的元素
    public E maximum() {
        if (size == 0) {
            throw new IllegalArgumentException("BST is empty");
        }
        return maximum(root).e;
    }

    private Node maximum(Node node) {
        if (node.right == null) {
            return node;
        }
        return maximum(node.right);
    }


    //删除最小的元素
    public E removeMin() {
        E ret = minimum();
        root = removeMin(root);
        return ret;
    }

    private Node removeMin(Node node) {
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }



    //删除最大的元素
    public E removeMax() {
        E ret = maximum();
        root = removeMax(root);
        return ret;
    }

    private Node removeMax(Node node) {
        if (node.right == null) {
            Node rightNode = node.left;
            node.left = null;
            size--;
            return rightNode;
        }
        node.right = removeMax(node.right);
        return node;
    }


    public void remove(E e){
        root = remove(root , e);
    }

    private Node remove(Node node , E e){
        if(node == null){
            return null;
        }

        if(e.compareTo(node.e)<0){
            node.left = remove(node.left , e);
            return node;
        }else if(e.compareTo(node.e)>0){
            node.right = remove(node.right ,e );
            return node;
        }else{ // e == node.e
            //如果待删除节点左子树为空的情况
            if(node .left == null){
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }
            // 如果待删除节点右子树为空的情况
            if(node.right == null){
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }

            /*
             * 待删除节点左右子树均不为空的情况
             * 找到比待删除节大小的节点，即待删除节点右子树最小节点
             * 用这个节点定期待删除节点的位置
             */
            Node successor = minimum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.right;
            node.left = node .right = null;
            return successor;
        }

    }

//    public E delMin() {
//        E ret = minimum();
//        delMin(root, null);
//        return ret;
//    }
//
//    private void delMin(Node node,Node prev){
//        if(node.left == null){
//            prev.left = null;
//            size --;
//            if(node.right != null){
//                prev.left = node.right;
//            }
//            return;
//        }
//        delMin(node.left , node);
//    }

//    public E delMax() {
//        E ret = minimum();
//        delMax(root, root);
//        return ret;
//    }
//
//    private void delMax(Node node ,Node prev){
//        if(node.right == null){
//            prev.right = null;
//            size --;
//            if(node.left != null){
//                prev.right = node.left;
//            }
//            return;
//        }
//        delMax(node.right , node);
//    }


}
