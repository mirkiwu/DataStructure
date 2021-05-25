package com.hxh.tree;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author huangxunhui
 * Date: Created in 18/10/12 下午9:30
 * Utils: Intellij Idea
 * Description: 二分搜索树测试方法
 */
public class BinarySearchTreeMain {

    public static void main(String[] args) {

        AVLTree<Integer> avlTree = new AVLTree<>();
        Random random = new Random();
        for (int i = 0; i < 1000 ; i++) {
            avlTree.add(random.nextInt(10000));
        }

        System.out.println(avlTree.isBST());

        System.out.println(avlTree.isBalanced());

    }
}

/*
    BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
    Random random = new Random();

    ArrayList<Integer> nums = new ArrayList<>();

    for (int i = 0; i < 1000 ; i++) {
        binarySearchTree.add(random.nextInt(10000));
    }

    while (!binarySearchTree.isEmpty()) {
        nums.add(binarySearchTree.removeMin());
    }
*/