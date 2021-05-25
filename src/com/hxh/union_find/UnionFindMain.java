package com.hxh.union_find;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author huangxunhui
 * Date: Created in 2018/12/1 下午5:08
 * Utils: Intellij Idea
 * Version:
 * Description:
 */
public class UnionFindMain {

    private static double testUF(UF uf , int m){
        int size = uf.getSize();
        Random random = new Random();

        long startTime = System.nanoTime();

        for (int i = 0; i < m; i++) {
            int a =random.nextInt(size);
            int b =random.nextInt(size);
            uf.unionElements(a,b);
        }

        for (int i = 0; i < m; i++) {
            int a =random.nextInt(size);
            int b =random.nextInt(size);
            uf.isConnected(a,b);
        }

        long endTime = System.nanoTime();

        return (endTime - startTime ) / 1000000000.0;
    }

    public static void main(String[] args) {
        int size = 10000000;
        int m = 10000000;

        UnionFind1 unionFind1 = new UnionFind1(size);

        UnionFind2 unionFind2 = new UnionFind2(size);

        UnionFind3 unionFind3 = new UnionFind3(size);

        UnionFind4 unionFind4 = new UnionFind4(size);

        UnionFind5 unionFind5 = new UnionFind5(size);

        UnionFind6 unionFind6 = new UnionFind6(size);

//        System.out.println("unionFind1 = " + testUF(unionFind1 , m)+":s");
//
//        System.out.println("unionFind2 = " + testUF(unionFind2 , m)+":s");

        System.out.println("unionFind3 = " + testUF(unionFind3 , m)+":s");

        System.out.println("unionFind4 = " + testUF(unionFind4 , m)+":s");

        System.out.println("unionFind5 = " + testUF(unionFind5 , m)+":s");

        System.out.println("unionFind6 = " + testUF(unionFind6 , m)+":s");

    }

}
