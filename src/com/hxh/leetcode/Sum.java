package com.hxh.leetcode;

/**
 * @author huangxunhui
 * Date: Created in 18/10/9 下午3:13
 * Utils: Intellij Idea
 * Description: 递归算法
 */
public class Sum {

    private int sum = 0;

    private static int sum(int[] arr){
        return sum(arr  , 0);
    }

    /**
     * 计算arr[l --- n]这个区间内所有的数字
     */
    private static int sum(int[] arr , int l){
        if(l == arr.length){
            return 0;
        }
        return arr[l] + sum(arr , l + 1);
    }

    public static void main(String[] args) {
        int[] nums = {1 , 2  ,3 , 4 };
        System.out.println(sum(nums));
    }
}
