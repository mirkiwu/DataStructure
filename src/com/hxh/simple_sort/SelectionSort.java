package com.hxh.simple_sort;

import java.util.Random;

/**
 * @author huangxunhui
 * Date: Created in 18/10/12 下午4:18
 * Utils: Intellij Idea
 * Description: 选择排序
 */
public class SelectionSort {

    public int[] sort(int[] arr){
        for (int i = 0  ; i < arr.length ; i++) {
            int min = i;
            for (int j = i+1; j < arr.length ; j++) {
                if(arr[j] < arr[min]){
                    min = j;
                }
            }
            Utils.swap(arr , i , min);
        }
        return arr;
    }

    public void sortByRecursive(int arr[]){
        recursive(0 ,arr);
    }

    private void recursive(int end , int arr[]){
        if(end == arr.length){
            return;
        }
        int min = end;
        for (int i = end + 1; i < arr.length ; i++) {
            if(arr[i] < arr[min]){
                min = i;
            }
        }
        Utils.swap(arr , end , min);
        recursive(end+1 ,arr);
    }

    public static void main(String[] args) {

        Random random = new Random();

        int[] nums = new int[10];

        for (int i = 0; i < 10; i++) {
            nums[i] = new Random().nextInt(100);
        }

        SelectionSort bubbleSort = new SelectionSort();

        System.out.println("原始数据：" + Utils.print(nums));

//        bubbleSort.sort(nums);

        bubbleSort.sortByRecursive(nums);
        System.out.println("选择排序：" + Utils.print(nums));

    }

}
