package com.zx.algorithm.leetcode;

import com.zx.algorithm.ListNode;

/**
 * Created by zhangxin on 2022/01/09.
 * Time : 18:46
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。
 */
public class IntersectionListNode {

    public static void main(String[] args) {

    }

    private static ListNode getIntersectionListNode(ListNode headA, ListNode headB) {

        ListNode curA = headA;
        ListNode curB = headB;

        int lenA = 0, lenB = 0;
        while (curA != null) {
            lenA++;
            curA = curA.next;
        }
        while (curB != null) {
            lenB++;
            curB = curB.next;
        }

        curA = headA;
        curB = headB;
        if (lenB > lenA) {
            int tmpLen = lenA;
            lenA = lenB;
            lenB = tmpLen;

            ListNode tmpNode = curA;
            curA = curB;
            curB = tmpNode;
        }

        int len = lenA - lenB;
        while (len > 0) {
            curA = curA.next;
            len--;
        }

        while (curA != null) {
            if (curA == curB) {
                return curA;
            }
            curA = curA.next;
            curB = curB.next;
        }
        return null;
    }
}
