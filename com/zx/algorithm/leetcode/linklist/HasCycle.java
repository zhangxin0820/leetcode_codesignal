package com.zx.algorithm.leetcode.linklist;

import com.zx.algorithm.ListNode;

/**
 * Created by zhangxin on 2022/01/13.
 * Time : 10:11
 * 判断链表是否有环
 */
public class HasCycle {

    public static void main(String[] args) {

    }

    private static boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }
}
