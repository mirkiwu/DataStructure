package com.hxh.leetcode;


/**
 * @author huangxunhui
 * Date: Created in 18/10/9 上午11:48
 * Utils: Intellij Idea
 * Description:
 */
public class DelRepeatNumOfLinkedList3 {

    private ListNode removeElements(ListNode head, int val) {

        if(head == null){
            return null;
        }
        head.next = removeElements(head.next, val);
        return head.val ==  val ? head.next:head ;
    }

    public static void main(String[] args) {
        int[] nums = {1 , 2 , 6 ,3 ,4 ,6};
        ListNode listNode = new ListNode(nums);
        System.out.println(new DelRepeatNumOfLinkedList3().removeElements(listNode,6));
    }
}

