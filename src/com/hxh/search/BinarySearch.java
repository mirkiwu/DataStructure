package com.hxh.search;

/**
 * @author huangxunhui
 * Date: Created in 18/10/9 下午10:20
 * Utils: Intellij Idea
 * Description: 二分查找
 */
public class BinarySearch {

    /**
     *
     * @param arr
     * @param searchKey
     * @return
     */
    private static int find(int[] arr , int searchKey){

        int lowerBound = 0;

        int upperBound = arr.length - 1;

        while(lowerBound <= upperBound){

            int curl = (lowerBound + upperBound ) / 2 ;

            if(arr[curl] == searchKey){
                return curl;
            }
            if(arr[curl] > searchKey){
                upperBound = curl - 1;
            }
            if(arr[curl] < searchKey){
                lowerBound = curl + 1;
            }
        }

        return -1;
    }


    /**
     * 通过递归实现二分查找
     * @param arr 数组
     * @param searchKey 查找的元素
     * @return true 或者 false
     */
    public static boolean binarySearchByRecursive(int[] arr  , int searchKey){
       return findByRecursive(arr , 0 , arr.length , searchKey);
    }

    private static boolean findByRecursive(int[] arr , int lowerBound , int upperBound , int searchKey){
        int curl = (lowerBound + upperBound ) / 2 ;

        if(arr[curl] == searchKey){
            return true;
        }
        if(arr[curl] > searchKey){
            upperBound = curl - 1;
        }
        if(arr[curl] < searchKey){
            lowerBound = curl + 1;
        }
        if(lowerBound > upperBound){
            return false;
        }
        return findByRecursive(arr , lowerBound ,upperBound , searchKey);
    }



    public static void main(String[] args) {

        int[] nums = new int[100000];

        for (int i = 0; i < 100000; i++) {
            nums[i] = i;
        }
//        int[] nums = {1,2,4,7};

        System.out.println(find(nums, 1000));

//        System.out.println(findByRecursive(nums, 0 , nums.length - 1 ,100));

    }



}
