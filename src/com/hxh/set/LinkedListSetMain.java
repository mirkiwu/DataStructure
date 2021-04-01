package com.hxh.set;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author huangxunhui
 * Date: Created in 18/10/17 上午11:03
 * Utils: Intellij Idea
 * Description:测试基于链表的集合
 */
public class LinkedListSetMain {

    public static void main(String[] args) {
        LinkedListSet<Integer> linkedListSet = new LinkedListSet<>();
        Random random = new Random();
        List<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 100000 ; i++) {
            arrayList.add(random.nextInt(100000));
        }

        System.out.println(arrayList.size());
        arrayList.forEach(num ->{
            linkedListSet.add(num);
        });

        System.out.println(linkedListSet.getSize());

    }

}
