package com.hxh.tree;

import com.hxh.queue.LinkedListQueue;
import com.hxh.stack.LinkedListStack;

import java.util.ArrayList;

/**
 * @author huangxunhui
 * Date: Created in 18/10/12 下午1:56
 * Utils: Intellij Idea
 * Description: 二分搜索树
 */
public class AVLTree<E extends Comparable <E> > {

    private class Node {

        public E e;

        public Node left;

        public Node right;

        public int height;

        public Node(E e) {
            this.e = e;
            this.left = null;
            this.right = null;
            height = 1;
        }
    }

    private Node root;

    private int size;

    public AVLTree() {
        root = null;
        size = 0;
    }

    // 获取节点的高度
    private int getHeight(Node node){
        if(node == null){
            return 0;
        }else{
            return node.height;
        }
    }

    private int getBalanceFactor(Node node){
        if(node == null){
            return 0;
        }else{
            return getHeight(node.left) - getHeight(node.right);
        }
    }

    //判断当前二叉树是否是一颗二分搜索树
    public boolean isBST(){
        ArrayList<E> arrayList = new ArrayList<>();
        inOrder(root,arrayList);
        for (int i = 1; i < arrayList.size(); i++) {
            if(arrayList.get(i-1).compareTo(arrayList.get(i))>0){
                return false;
            }
        }
        return true;
    }

    public boolean isBalanced(){
        return isBalanced(root);
    }

    public boolean isBalanced(Node node){
        if(node == null){
            return true;
        }else{
            int balanceFactor = getBalanceFactor(node);
            if(Math.abs(balanceFactor) > 1){
                return false;
            }
        }
        return isBalanced(node.left) && isBalanced(node.right);
    }


    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    private Node rightRotate(Node y){
        Node x = y.left;
        Node t3 = x.right;

        x.right = y;
        y.left = t3;

        // 更新height
        y.height = 1 + Math.max(getHeight(y.left),getHeight(y.right));
        x.height = 1 + Math.max(getHeight(x.left),getHeight(x.right));
        return x;
    }

    private Node leftRotate(Node y){

        Node x = y.right;
        Node t3 = x.left;

        x.left = y;
        y.right = t3;

        // 更新height
        y.height = 1 + Math.max(getHeight(y.left),getHeight(y.right));
        x.height = 1 + Math.max(getHeight(x.left),getHeight(x.right));
        return x;
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

        //计算当前节点的高度
        node.height = 1 + Math.max(getHeight(node.left),getHeight(node.right));

        //计算平衡因子
        int balanceFactor = getBalanceFactor(node);

        if(Math.abs(balanceFactor) > 1){
            System.out.println(" unbalance " + balanceFactor);
        }

        // LL
        if(balanceFactor > 1 && getBalanceFactor(node.left) >= 0){
            return rightRotate(node);
        }

        // RR
        if(balanceFactor < -1 && getBalanceFactor(node.right) <= 0){
            return leftRotate(node);
        }

        // LR
        if(balanceFactor > 1 && getBalanceFactor(node.left) < 0){
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // RL
        if(balanceFactor < -1 && getBalanceFactor(node.right) > 0){
            node.right = rightRotate(node.right);
            return leftRotate(node);
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

    // 前序遍历
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

    // 中序遍历
    private void inOrder(Node node ,ArrayList<E> arrayList) {
        if (node == null) {
            return;
        }
        inOrder(node.left , arrayList);
        arrayList.add(node.e);
        inOrder(node.right , arrayList);
    }


    private void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    //后续遍历
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

}
