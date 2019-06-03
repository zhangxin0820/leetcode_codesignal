package com.zx.algorithm.leetcode;


/**
 * @author zhangxin82@jd.com
 * @create 2018-12-19 16:41
 * @description
 */

public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if (l1.val == 0 && l1.next == null) {
            return l2;
        }

        if (l2.val == 0 && l2.next == null) {
            return l1;
        }

        ListNode node1 = l1;
        ListNode node2 = l2;

        ListNode sumList = new ListNode(0);
        ListNode curr = sumList;

        int carryFlag = 0;

        while (node1 != null || node2 != null) {

            int x = 0, y = 0;

            if (node1 != null) {
                x = node1.val;
            }

            if (node2 != null) {
                y = node2.val;
            }

            int tmpSum = x + y + carryFlag;
            carryFlag = tmpSum / 10;

            curr.next = new ListNode(tmpSum % 10);
            curr = curr.next;

            if (node1 != null) {
                node1 = node1.next;
            }

            if (node2 != null) {
                node2 = node2.next;
            }
        }

        if (carryFlag > 0) {
            curr.next = new ListNode(carryFlag);
        }

        return sumList.next;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
