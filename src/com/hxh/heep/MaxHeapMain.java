package com.hxh.heep;

import java.util.Random;

/**
 * @author huangxunhui
 * Date: Created in 18/10/19 下午6:41
 * Utils: Intellij Idea
 * Description: 最大堆测试
 */
public class MaxHeapMain {

    public static void main(String[] args) {
        MaxHeap<Integer> maxHeep = new MaxHeap<>();
        Random random = new Random();
        int n = 1000000 ;
        for (int i = 0; i < n; i++) {
            maxHeep.add(random.nextInt(Integer.MAX_VALUE));
        }

        int [] arr = new int[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = maxHeep.extractMax();
        }

        for (int i = 1; i < n; i++) {
            if(arr[i-1] < arr[i]){
                throw new IllegalArgumentException("error");
            }
        }
        System.out.println("Test MaxHeap completed");
    }
}
