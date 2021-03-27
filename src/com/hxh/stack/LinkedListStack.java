package com.hxh.stack;

import com.hxh.array.Array;
import com.hxh.linkedlist.LinkedList;

/**
 * @author huangxunhui
 * Date: Created in 18/10/8 下午4:49
 * Utils: Intellij Idea
 * Description:
 */
public class LinkedListStack<E> implements Stack<E> {

    LinkedList<E> linkedList;

    /**
     * 初始化
     */
    public LinkedListStack(){
        linkedList = new LinkedList<>();
    }

    @Override
    public void push(E e) {
        linkedList.addFirst(e);
    }

    @Override
    public E pop() {
        return linkedList.removeFirst();
    }

    @Override
    public E peek() {
        return linkedList.getFirst();
    }

    @Override
    public int getSize() {
        return linkedList.getSize();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        //使用while循环遍历
        res.append("Stack : top ");
        res.append(linkedList);
        return res.toString();
    }
}
