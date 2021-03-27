package com.hxh.array;

import com.hxh.array.Array;

public class ArrayMain {

    public static void main(String[] args) {

       Array<Integer> array = new Array();
        for (int i = 0; i < 10 ; i++) {
            array.addLast(i);
        }
        System.out.println(array);

        array.add(1,100);
        System.out.println("add array = " + array);

        array.addFirst(-1);
        System.out.println("addFirst array = " + array);

        int remove = array.remove(1);
        System.out.println("remove = " + remove);
        System.out.println("delete array = " + array);

        array.removeElement(100);
        System.out.println("delete array = " + array);

    }

}
