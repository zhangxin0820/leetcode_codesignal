package com.zx.algorithm.leetcode.linklist;

import com.zx.algorithm.ListNode;

/**
 * Created by zhangxin on 2022/01/04.
 * Time : 21:48
 * 合并K个链表
 */
public class MergeKList {

    public static void main(String[] args) {

    }

    private static ListNode merge(ListNode[] lists, int left, int right) {
        if (left > right) return null;
        if (left == right) return lists[left];
        int mid = (left + right) / 2;
        ListNode l = merge(lists, left, mid);
        ListNode r = merge(lists, mid + 1, right);
        return mergeTwoList(l, r);
    }

    private static ListNode mergeTwoList(ListNode list1, ListNode list2) {
        ListNode result = new ListNode(-1);
        ListNode pre = result;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                pre.next = list1;
                list1 = list1.next;
            } else {
                pre.next = list2;
                list2 = list2.next;
            }
            pre = pre.next;
        }
        if (list1 != null) pre.next = list1;
        if (list2 != null) pre.next = list2;
        return result.next;
    }
}
