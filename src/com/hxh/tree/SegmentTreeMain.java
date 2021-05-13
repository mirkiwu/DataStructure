package com.hxh.tree;

/**
 * @author huangxunhui
 * Date: Created in 2018/11/28 上午10:28
 * Utils: Intellij Idea
 * Version: 1.0
 * Description: 线段树测试
 */
public class SegmentTreeMain {
    public static void main(String[] args) {
        String[] nums = {"0","1","2","3","4","5","6","7","8","9"};

        SegmentTree<String> segmentTree = new SegmentTree<>(nums,(a,b)-> a+","+b );
//        System.out.println("segmentTree = " + segmentTree);

        String query = segmentTree.query(0, 2);

        System.out.println("query = " + query);

        segmentTree.set(8 , "10");
        System.out.println("segmentTree = " + segmentTree);

    }

}
