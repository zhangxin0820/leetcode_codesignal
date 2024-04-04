package com.zx.algorithm.leetcode.linklist;

import com.zx.algorithm.ListNode;

/**
 * 82. 删除排序链表中的重复元素 II
 * 给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
 */
public class DeleteDuplicates2 {

    public static void main(String[] args) {

    }

    public static ListNode deleteDuplicates2(ListNode head) {
        if (head == null) return head;
        ListNode dummy = new ListNode(-1, head);
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                int sameVal = cur.next.val;
                while (cur.next != null && cur.next.val == sameVal) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}
