package com.hxh.simple_sort;

/**
 * @author huangxunhui
 * Date: Created in 18/10/20 下午10:48
 * Utils: Intellij Idea
 * Description:
 */
public class Utils {

    public static void swap(int[] arr , int i , int j ){
            int change = arr[i];
            arr[i] = arr[j];
            arr[j] = change;
    }

    public static String print(int arr[]){
        StringBuilder res = new StringBuilder();
        res.append("[");
        for (int i = 0; i < arr.length; i++) {
            res.append(arr[i]);
            if(i != arr.length - 1 ){
                res.append(", ");
            }
        }
        res.append("]");
        return res.toString();
    }

}
