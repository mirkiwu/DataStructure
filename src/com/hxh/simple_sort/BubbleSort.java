package com.hxh.simple_sort;



/**
 * @author huangxunhui
 * Date: Created in 18/10/12 下午2:33
 * Utils: Intellij Idea
 * Description:冒泡排序
 */
public class BubbleSort {

    private static int count;

    /**
     * 非递归实现冒泡排序
     * @param arr 数组
     * @return 返回排序后的数组
     */
    private int[] sort(int arr[]){
        for (int i = arr.length ; i > 0; i--) {
            for (int j = 0; j < i - 1 ; j++) {
                if(arr[j] > arr[j + 1]){
                    Utils.swap(arr, i , i+1);
                }
            }
        }
        return arr;
    }


    private int[] sortByRecursive(int[] arr){
        return recursive(arr.length, arr);
    }

    private int[] recursive( int end , int[] arr){
        //终止条件
        if(end == 1 ){
            return arr;
        }
        for (int i = 0; i < end - 1; i++) {
            if(arr[i] > arr[i+1]){
                Utils.swap(arr, i , i+1);
            }
        }
        return recursive(end-1 ,arr);
    }



    public static void main(String[] args) {
        int[] nums = new int[10];
        for (int i = 0; i < 10; i++) {
//            nums[i] = new Random().nextInt(1000);
            nums[i] = 20 - i;
        }

        BubbleSort bubbleSort = new BubbleSort();

        System.out.println("原始数据：" + Utils.print(nums));

//        System.out.println("非递归冒泡排序：" + bubbleSort.print(bubbleSort.sort(nums)));

        System.out.println("递归冒泡排序：" + Utils.print(bubbleSort.sortByRecursive(nums)));


    }



}
