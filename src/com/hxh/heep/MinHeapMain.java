package com.hxh.heep;

import java.util.Random;

/**
 * @author huangxunhui
 * Date: Created in 18/10/19 下午6:41
 * Utils: Intellij Idea
 * Description: 最大堆测试
 */
public class MinHeapMain {

    public static void main(String[] args) {
        MinHeap<Integer> minHeep = new MinHeap<>();
        Random random = new Random();
        int n = 15 ;
        for (int i = 0; i < n; i++) {
            minHeep.add(random.nextInt(20));
        }

        int [] arr = new int[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = minHeep.extractMin();
            System.out.println("arr = " + arr[i]);
        }

        for (int i = 1; i < n; i++) {
            if(arr[i-1] > arr[i]){
                throw new IllegalArgumentException("error");
            }
        }
        System.out.println("Test MinHeap completed");
    }
}
