package com.zx.algorithm.leetcode.linklist;

import com.zx.algorithm.ListNode;

/**
 * 虚拟节点，反转完K个节点后再挂回原来的节点
 * 需要用4个指针
 * prev : 反转部分的第一个节点前面的1个节点
 * first: 反转部分的第一个节点
 * last : 反转部分的最后一个节点
 * next : last 后面的第一个节点
 *
 * 1. 断开 Last 和 next, 然后从 first 开始进行反转
 * 2. 反转完后 first 变成尾巴，last 变成这部分第一个节点，prev.next 指向第一个节点 last ,first.next 指向 next
 * 3. 指针移动的过程：(1)prev 指向 first (2)first 指向 next (3)last 先指向 first，然后走k-1步 (4)next = last.next
 */
public class ReverseKGroup {

    public static void main(String[] args) {

    }

    private static ListNode reverseKGroup(ListNode head, int k) {
        // 边界条件：链表里面没有节点 或只有一个节点 或k==0和1 不需要交换
        if (head == null || head.next == null || k == 0 || k == 1) return head;

        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        ListNode prev = dummyNode;
        ListNode first = head;
        ListNode last = first;
        while (first != null) {
            for (int i = 0; i < k - 1; i++) {
                last = last.next;
                if (last == null) return dummyNode.next; // 不满k个就不反转 返回头节点 前面是已反转好的
            }
            ListNode next = last.next;
            last.next = null;
            reverse(first);

            prev.next = last;
            first.next = next;

            prev = first;
            first = next;
            last = first;
        }

        return dummyNode.next;
    }

    private static ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
