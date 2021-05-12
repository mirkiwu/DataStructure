package com.hxh.map;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author huangxunhui
 * Date: Created in 18/10/17 下午4:24
 * Utils: Intellij Idea
 * Description:
 */
public class BinarySearchTreeMapMain {

    public static void main(String[] args) {

        BinarySearchTreeMap<Integer , Integer>  map = new BinarySearchTreeMap<>();
        ArrayList<Integer> words = new ArrayList<>();
        Random random = new Random();


        for (int i = 0; i < 1000000; i++) {
            words.add(random.nextInt(10));
        }

        for (Integer word : words) {
            if(map.contains(word)){
                map.set(word , map.get(word)+1);
            }else{
                map.add(word , 1);
            }
        }

        System.out.println(map.get(1));
        System.out.println(map.get(2));
        System.out.println(map.get(3));
        System.out.println(map.get(4));
        System.out.println(map.get(5));

    }

}
