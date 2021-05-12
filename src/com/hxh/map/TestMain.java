package com.hxh.map;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author huangxunhui
 * Date: Created in 18/10/17 下午5:03
 * Utils: Intellij Idea
 * Description:
 */
public class TestMain {

    public static double testMap(Map<Integer , Integer >  map , List<Integer> list ){
        long startTime = System.nanoTime();

        for (Integer word : list) {
            if(map.contains(word)){
                map.set(word , map.get(word)+1);
            }else{
                map.add(word , 1);
            }
        }

        System.out.println(map.get(10));
        System.out.println(map.get(20));
        System.out.println(map.get(30));
        System.out.println(map.get(40));
        System.out.println(map.get(50));

        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {
        BinarySearchTreeMap<Integer , Integer>  BSTMap = new BinarySearchTreeMap<>();
        LinkedListMap<Integer , Integer>  linkedListMap = new LinkedListMap<>();
        ArrayList<Integer> words = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 1000000; i++) {
            words.add(random.nextInt(1000));
        }
        System.out.println("BSTMap = " + TestMain.testMap(BSTMap , words));

        System.out.println("linkedListMap = " + TestMain.testMap(linkedListMap , words));

    }
}
