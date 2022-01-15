package com.zx.algorithm.leetcode.linklist;

import com.zx.algorithm.ListNode;

/**
 * Created by zhangxin on 2021/12/30.
 * Time : 12:24
 * 合并两个链表
 */
public class MergeTwoList {

    public static void main(String[] args) {

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
