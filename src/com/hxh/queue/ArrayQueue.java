package com.hxh.queue;

import com.hxh.array.Array;

/**
 * @author huangxunhui
 * Date: Created in 18/10/7 下午1:01
 * Utils: Intellij Idea
 * Description: 队列
 */
public class ArrayQueue<E> implements Queue<E> {

    private Array<E> array;

    /**
     * 初始化
     */
    public ArrayQueue(){
        array = new Array<>();
    }

    public ArrayQueue(int capacity){
        array = new Array<>(capacity);
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }

    @Override
    public E dequeue() {
       return array.removeFirst();
    }

    @Override
    public E getFront() {
        return array.getFirst();
    }

    public int getCapacity(){
        return array.getCapacity();
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("Queue : ");
        res.append("front [");
        for (int i = 0; i < array.getSize() ; i++) {
            res.append(array.get(i));
            if(i != array.getSize() - 1 ){
                res.append(",");
            }
        }
        res.append("] tail");
        return res.toString();
    }

}
