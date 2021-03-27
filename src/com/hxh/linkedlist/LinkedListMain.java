package com.hxh.linkedlist;

/**
 * @author huangxunhui
 * Date: Created in 18/10/8 下午3:55
 * Utils: Intellij Idea
 * Description: 链表测试类
 */
public class LinkedListMain {


    public int delRecursive(LinkedList<Integer> linkedList , int delKey , int index){
        if(index == linkedList.getSize()){
            return -1;
        }
        if(linkedList.get(index).equals(delKey)){
            linkedList.remove(index);
        }
        index ++;
        return delRecursive(linkedList , delKey ,index);
    }

    public int delNumOfLinkedList(LinkedList<Integer> linkedList , int delKey){
        return delRecursive(linkedList , delKey , 0);
    }


    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 10 ; i++) {
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }
        linkedList.add(0 ,666);

        linkedList.add(2 , 666);
        System.out.println(linkedList);

        linkedList.add(5 , 666);
        System.out.println(linkedList);

        LinkedListMain listMain = new LinkedListMain();
        listMain.delNumOfLinkedList(linkedList , 666);
        System.out.println(linkedList);

//        linkedList.remove(2);
//        System.out.println(linkedList);
//
//        linkedList.removeFirst();
//        System.out.println(linkedList);
//
//        linkedList.removeLast();
//        System.out.println(linkedList);
    }

}
