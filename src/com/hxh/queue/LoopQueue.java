package com.hxh.queue;

import java.util.Arrays;

/**
 * @author huangxunhui
 * Date: Created in 18/10/8 上午10:01
 * Utils: Intellij Idea
 * Description: 循环队列
 */
public class LoopQueue<E> implements Queue<E> {

    private E[] data;

    /**
     * 队首
     */
    private int front;

    /**
     * 队尾
     */
    private int tail;

    /**
     * 队列长度
     */
    private int size;
    //TODO 去除size 变量使用 front 和 tail 进行计算

    /**
     * 初始化队列
     */

    public LoopQueue(int capacity){
        data =  (E[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue(){
        this(10);
    }

    /**
     * 获取队列的容量
     * @return 返回容量
     */
    public int getCapacity(){
        return data.length - 1;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public void enqueue(E e) {
        if((tail + 1 ) % data.length == front){
            resize(getCapacity()*2);
        }
        data[tail] = e;
        tail = (tail+1) % data.length;
        size++;
    }

    @Override
    public E dequeue() {
        if(isEmpty()){
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        }
        E ret = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        if(size == data.length / 4 && data.length / 2 != 0){
            resize(getCapacity() / 2);
        }
        return ret;
    }

    @Override
    public E getFront() {
        if(isEmpty()){
            throw new IllegalArgumentException("queue is empty.");
        }
        return data[front];
    }

    private void resize(int newCapacity){
        E[] newData = (E[]) new Object[newCapacity + 1];
        for (int i = 0; i < size ; i++) {
            newData[i] = data[(i + front)%data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size = %d , capacity = %d",size , getCapacity()));
        res.append("\n");
        res.append("front [");
        for (int i = front; i != tail ; i = (i+1)%data.length) {
            res.append(data[i]);
            if((i+1)%data.length != tail){
                res.append(", ");
            }
        }
        res.append("] tail");
        return res.toString();
    }
}
