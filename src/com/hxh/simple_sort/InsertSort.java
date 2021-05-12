package com.hxh.simple_sort;

import java.util.Random;

/**
 * @author huangxunhui
 * Date: Created in 18/10/21 下午1:17
 * Utils: Intellij Idea
 * Description: 插入排序
 */
public class InsertSort {

    public void sort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            int index = i;
            if(arr[i - 1 ]>arr[i]){
//                System.out.println("当前位置是[" + index + "]值为:" + arr[index]);
                while(index > 0 && arr[index] < arr[index-1]){
                    Utils.swap(arr, index , index - 1);
//                    System.out.println("第" + index + "次排序" + Utils.print(arr));
                    index = index - 1 ;
                }
            }
        }
    }

    public static void main(String[] args) {

        Random random = new Random();

//        int[] nums = {66, 9, 51, 16, 4, 70, 16, 46, 53, 17};
        int[] nums = new int[10];

        for (int i = 0; i < 10; i++) {
            nums[i] = new Random().nextInt(100);
        }

        InsertSort insertSort = new InsertSort();

        System.out.println("原始数据：" + Utils.print(nums));

        insertSort.sort(nums);

        System.out.println("插入排序：" + Utils.print(nums));

    }
}
