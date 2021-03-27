package com.hxh.leetcode;

/**
 * @author huangxunhui
 * Date: Created in 18/10/9 上午11:48
 * Utils: Intellij Idea
 * Description:
 */
public class ListNode {

    int val;

    ListNode next;

    ListNode(int x) { val = x; }


    public ListNode(int[] arr){
        if(arr == null || arr.length == 0){
            throw new IllegalArgumentException("array can not be empty");
        }
        this.val = arr[0];
        ListNode cur = this;
        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
    }


    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        //使用while循环遍历
        ListNode cur = this;
        while (cur != null){
            res.append(cur.val + "->");
            cur = cur.next;
        }
        res.append("NULL");
        return res.toString();
    }
}
