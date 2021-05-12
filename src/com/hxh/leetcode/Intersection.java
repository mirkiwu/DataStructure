package com.hxh.leetcode;

import java.util.*;

/**
 * @author huangxunhui
 * Date: Created in 18/10/17 下午5:31
 * Utils: Intellij Idea
 * Description:
 */
public class Intersection {
    public static void main(String[] args) {
        IntersectionSolution solution = new IntersectionSolution();
        IntersectionSolution2 solution2 = new IntersectionSolution2();
//        int[] nums1 = {4,9,5};
//        int[] nums2 = {9,4,9,8,4};

        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};

//        int[] intersection = solution.intersection(nums1, nums2);
//        for (int i = 0; i < intersection.length; i++) {
//            System.out.println(intersection[i]);
//        }

        int[] intersection2 = solution2.intersect(nums1, nums2);
        for (int i = 0; i < intersection2.length; i++) {
            System.out.println(intersection2[i]);
        }

    }
}

class IntersectionSolution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        ArrayList<Integer> ret = new ArrayList<>();
        for (int num : nums1) {
            set.add(num);
        }
        for (int num : nums2) {
            if(set.contains(num)){
                ret.add(num);
                set.remove(num);
            }
        }

        int[] result = new int[ret.size()];
        for (int i = 0; i < ret.size() ; i++) {
            result[i] = ret.get(i);
        }
        return result ;
    }
}

class IntersectionSolution2 {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer , Integer> map = new HashMap<>();
        ArrayList<Integer> ret = new ArrayList<>();
        for (int num : nums1) {
            if(!map.containsKey(num)){
                map.put(num , 1);
            }else{
                map.put(num , map.get(num)+1);
            }
        }

        for (int num : nums2) {
            if(map.containsKey(num)){
                ret.add(num);
                map.put(num , map.get(num)-1);
                if(map.get(num) == 0){
                    map.remove(num);
                }
            }
        }

        int[] result = new int[ret.size()];
        for (int i = 0; i < ret.size() ; i++) {
            result[i] = ret.get(i);
        }
        return result ;
    }
}

