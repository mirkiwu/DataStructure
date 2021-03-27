package com.hxh.leetcode;

/**
 * @author huangxunhui
 * Date: Created in 18/10/9 上午11:48
 * Utils: Intellij Idea
 * Description:
 */
public class DelRepeatNumOfLinkedList {

    public ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val) {
            head = head.next;
        }
        if (head == null) {
            return head;
        }
        ListNode prev = head;
        while (prev.next != null) {
            if (prev.next.val == val) {
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }
        return head;
    }

}

