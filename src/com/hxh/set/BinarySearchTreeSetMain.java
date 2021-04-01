package com.hxh.set;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author huangxunhui
 * Date: Created in 18/10/17 上午10:38
 * Utils: Intellij Idea
 * Description: 测试基于二分搜索树的集合
 */
public class BinarySearchTreeSetMain {

    public static void main(String[] args) {
        BinarySearchTreeSet<Integer> treeSet = new BinarySearchTreeSet<>();
        Random random = new Random();
        List<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 100000 ; i++) {
            arrayList.add(random.nextInt(100000));
        }

        System.out.println(arrayList.size());
        arrayList.forEach(num ->{
            treeSet.add(num);
        });

        System.out.println(treeSet.getSize());

    }

}
