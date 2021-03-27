package com.hxh.stack;

import com.hxh.array.Array;

/**
 * @author huangxunhui
 * Date: Created in 18/10/7 上午11:13
 * Utils: Intellij Idea
 * Description: 通过数组实现栈
 */
public class ArrayStack<E> implements Stack<E> {

    Array<E> array;

    /**
     * 初始化
     */
    public ArrayStack(){
        array = new Array<>();
    }

    public ArrayStack(int capacity){
        array = new Array<>(capacity);
    }


    @Override
    public void push(E e) {
        array.addLast(e);
    }

    @Override
    public E pop() {
        return array.removeLast();
    }

    @Override
    public E peek() {
        return array.getLast();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    /**
     * 获取栈的容积
     * @return 返回容积
     */
    public int getCapacity(){
        return array.getCapacity();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Stack : ");
        res.append("[");
        for (int i = 0; i < array.getSize() ; i++) {
            res.append(array.get(i));
            if(i != array.getSize() - 1 ){
                res.append(",");
            }
        }
        res.append("] top");
        return res.toString();
    }
}
