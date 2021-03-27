package com.hxh.queue;

import java.util.Random;

/**
 * @author huangxunhui
 * Date: Created in 18/10/7 下午1:14
 * Utils: Intellij Idea
 * Description:
 */
public class QueueMain{

    private static double testQueue(Queue<Integer> queue, int opCount){
        long startTime = System.nanoTime();

        Random random = new Random();

        for (int i = 0; i < opCount; i++) {
            queue.enqueue(random.nextInt(Integer.MAX_VALUE));
        }

        for (int i = 0; i < opCount; i++) {
            queue.dequeue();
        }

        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {

        //操作总数
        int opCount = 10;

        //数组队列
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();

        //循环队列
        LoopQueue<Integer> loopQueue = new LoopQueue<>();

        //链表队列
        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<>();

        System.out.println("ArrayQueue Consumption Time: " + testQueue(arrayQueue, opCount) + "s");

        System.out.println("LoopQueue Consumption Time: " + testQueue(loopQueue, opCount) + "s");

        System.out.println("linkedListQueue Consumption Time: " + testQueue(linkedListQueue, opCount) + "s");

    }

}


