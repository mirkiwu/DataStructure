package com.hxh.stack;

import com.hxh.linkedlist.LinkedList;

import java.util.Random;

/**
 * @author huangxunhui
 * Date: Created in 18/10/7 上午11:25
 * Utils: Intellij Idea
 * Description: 栈
 */
public class StackMain {

    private static double testStack(Stack<Integer> stack, int opCount){
        long startTime = System.nanoTime();

        Random random = new Random();

        for (int i = 0; i < opCount; i++) {
            stack.push(random.nextInt(Integer.MAX_VALUE));
        }

        for (int i = 0; i < opCount; i++) {
            stack.pop();
        }

        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }


    public static void main(String[] args) {

        int opCount = 10000000;

        ArrayStack<Integer> arrayStack  = new ArrayStack<>();

        LinkedListStack<Integer> linkedListStack  = new LinkedListStack<>();

        System.out.println("arrayStack Consumption Time: " + testStack(arrayStack, opCount) + "s");

        System.out.println("linkedListStack Consumption Time: " + testStack(linkedListStack, opCount) + "s");
    }

}

