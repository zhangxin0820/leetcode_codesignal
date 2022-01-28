package com.zx.algorithm.leetcode.linklist;

import com.zx.algorithm.ListNode;

/**
 * @author zhangxin82@jd.com
 * @create 2019/11/28 12:05 下午
 * @description 单链表反转
 */

public class ReverseLinkedList {

    public static void main(String[] args) {

    }

    private static ListNode reverseListNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode pre = null;
        ListNode cur = head;
        ListNode next = null;

        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }
}