package com.hxh.leetcode;

/**
 * @author huangxunhui
 * Date: Created in 18/10/9 上午11:48
 * Utils: Intellij Idea
 * Description:
 */
public class DelRepeatNumOfLinkedList2 {

    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head ;
        ListNode prev = dummyHead;
        while (prev.next != null) {
            if (prev.next.val == val) {
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        int[] nums = {1 , 2 , 6 ,3 ,4 ,6};
        ListNode listNode = new ListNode(nums);
        System.out.println(new DelRepeatNumOfLinkedList2().removeElements(listNode,6));
    }
}

