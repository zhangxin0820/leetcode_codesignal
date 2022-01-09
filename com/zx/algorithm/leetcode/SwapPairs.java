package com.zx.algorithm.leetcode;

import com.zx.algorithm.ListNode;

/**
 * Created by zhangxin on 2022/01/09.
 * Time : 17:38
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 */
public class SwapPairs {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        ListNode res = swapPairs(head);
        ListNode cur = res;
        while (cur != null) {
            System.out.println(cur.val);
            cur = cur.next;
        }
    }

    private static ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            ListNode tmp = cur.next;
            ListNode tmp1 = cur.next.next.next;

            cur.next = cur.next.next; // 步骤一：让cur.next.next指向2，此时1.next断开，不再指向2。
            cur.next.next = tmp; // 步骤二：让2.next指向1，用tmp已经记录了1，即让cur.next.next指向了tmp。
            cur.next.next.next = tmp1; // 步骤三：让1.next指向3，用tmp1记录了3，即让cur.next.next.next指向了tmp1。

            cur = cur.next.next;
        }
        return dummy.next;
    }
}
