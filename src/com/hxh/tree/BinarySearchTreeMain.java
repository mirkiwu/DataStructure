package com.hxh.tree;

import java.util.Random;

/**
 * @author huangxunhui
 * Date: Created in 18/10/12 下午9:30
 * Utils: Intellij Idea
 * Description: 二分搜索树测试方法
 */
public class BinarySearchTreeMain {

    public static void main(String[] args) {

        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            binarySearchTree.add(i);
        }
        System.out.println(binarySearchTree.contains(13));
    }
}
