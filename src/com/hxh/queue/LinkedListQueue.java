package com.hxh.queue;

/**
 * @author huangxunhui
 * Date: Created in 18/10/8 下午5:16
 * Utils: Intellij Idea
 * Description:基于链表队列
 */
public class LinkedListQueue<E> implements Queue<E>{


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
     * 头节点
     */
    private Node head;

    /**
     * 尾部
     */
    private Node tail;

    /**
     * 长度
     */
    private int size;

    /**
     * 初始化
     */
    public LinkedListQueue(){
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 入队
     * 先判断tail是否为空，如果为空，在尾部添加节点， 这时候头结点和为节点相同
     * 所以需要维护头结点
     * @param e 数据
     */
    @Override
    public void enqueue(E e) {

        if(tail == null){
            tail = new Node(e);
            head = tail;
        }else{
            tail.next = new Node(e);
            tail = tail.next;
        }
        size ++ ;
    }

    /**
     * 出队
     * @return 返回数据
     */
    @Override
    public E dequeue() {

        if(isEmpty()){
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        }

        Node retNode = head;
        head = head.next;
        retNode.next = null;
        if(head == null){
            tail = null;
        }

        size --;
        return retNode.e;
    }

    /**
     * 获取头部数据
     * @return 返回数据
     */
    @Override
    public E getFront() {
        if(isEmpty()){
            throw new IllegalArgumentException("Queue is empty");
        }
        return head.e;
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("Queue : front ");
        Node cur = head;
        while (cur != null){
            res.append(cur + "->");
            cur = cur.next;
        }
        res.append("NULL tail");
        return res.toString();
    }

}
