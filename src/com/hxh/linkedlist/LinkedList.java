package com.hxh.linkedlist;

import java.util.UUID;

/**
 * @author huangxunhui
 * Date: Created in 18/10/8 上午11:48
 * Utils: Intellij Idea
 * Description: 链表
 */
public class LinkedList<E> {

    /**
     * node作为内部类，只能在链表内部访问无法在外部访问
     * 对外部的用户屏蔽程序内部实现的细节
     */
    private class  Node{

        public E e;

        public Node next;

        public Node(E e , Node next){
            this.e = e;
            this.next = next;
        }

        public Node(E e){
            this(e , null);
        }

        public Node(){
            this(null ,null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    /**
     * 链表头
     */
    private Node dummyHead;

    /**
     * 链表的长度
     */
    private int size;

    /**
     * 初始化链表
     */
    public LinkedList(){
        dummyHead = new Node(null,null);
        size = 0;
    }

    /**
     * 获取链表中的元素个数
     * @return 元素个数
     */
    public int getSize(){
        return size;
    }

    /**
     * 判断链表是否为空
     * @return 返回true 或者 false
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * 在链表的index(0 - based)位置添加新的元素e
     * 实现原理：
     * node:需要插入的节点
     * prev:插入位置的前一个节点
     * 1，先把需要插入的node.next 指向prev.next
     * 2，再prev.next指向node
     * 执行顺序不能进行改变
     * 在链表中不是一个常用的操作。练习用
     */
    public void add(int index , E e){

        if(index < 0 || index > size){
            throw new IllegalArgumentException("Add failed , Illegal index.");
        }

        Node prev = dummyHead ;
        //移动链表进行查找
        for (int i = 0; i < index ; i++) {
            prev = prev.next;
        }
        //Node node = new Node(e);
        //node.next = prev.next;
        //prev.next = node;
        prev.next = new Node(e , prev.next);
        size++;
    }

    /**
     * 在链表头添加数据
     * 实现原理： 先把新的node.next 指向 原来的head 再把新的node 当做为head
     * @param e 数据
     */
    public void addFirst(E e){
        add(0,e);
    }

    /**
     * 在添加链表后面添加元素
     * @param e 数据
     */
    public void addLast(E e) {
        add(size , e);
    }

    /**
     * 获取链表的第index（0-based）个位置的元素
     * 在链表中不是一个常用的操作，练习用；
     * @param index 查询次数
     * @return 返回数据
     */
    public E get(int index){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("Get failed , Illegal index.");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index ; i++) {
            cur = cur.next;
        }
        return cur.e;
    }

    /**
     * 获得链表的第一个元素
     * @return 数据
     */
    public E getFirst(){
        return get(0);
    }

    /**
     * 获取链表的最后一个元素
     * @return 数据
     */
    public E getLast(){
        return get(size - 1);
    }

    /**
     * 修改链表的第index(0 - based )的元素e
     * @param index 查询次数
     * @param e 数据
     */
    public void set(int index, E e){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("Update failed , Illegal index.");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index ; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }

    /**
     * 查询链表中是否包含元素
     * @param e 数据
     * @return true or false
     */
    public boolean contains(E e){
        Node cur = dummyHead.next;

        //使用for循环遍历链表
        /*for (int i = 0; i < size - 1; i++) {
            if(cur.e.equals(e)){
                return true;
            }
            cur = cur.next;
        }
        return false;
        */

        //使用while遍历链表
        while(cur != null){
            if(cur.e.equals(e)){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        //使用while循环遍历

        Node cur = dummyHead.next;
        while (cur != null){
            res.append(cur + "->");
            cur = cur.next;
        }

        //for (Node cur = dummyHead.next ; cur != null ; cur = cur.next){
        //    res.append(cur + "->");
        //}
        res.append("NULL");
        return res.toString();
    }

    public E remove(int index){

        if(index < 0 || index > size){
            throw new IllegalArgumentException("Delete failed , Illegal index.");
        }

        Node prev = dummyHead;

        //移动链表进行查找
        for (int i = 0; i < index ; i++) {
            prev = prev.next;
        }
        Node retNode = prev.next;
        prev.next = retNode.next;
        retNode.next = null;
        size --;
        return retNode.e;
    }

    public E removeFirst(){
        return remove(0);
    }

    public E removeLast(){
        return remove(size - 1);
    }
}
