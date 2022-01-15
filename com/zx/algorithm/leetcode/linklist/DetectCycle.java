package com.zx.algorithm.leetcode.linklist;

import com.zx.algorithm.ListNode;

/**
 * Created by zhangxin on 2022/01/13.
 * Time : 11:08
 * 找到环形链表的入口节点
 *
 * 证明过程：
 * P1：链表的起点
 * D：链表的环入口（假设链表有环）
 * P2：快慢指针相遇的位置
 * X：链表起点 P1 到环入口 D 的距离
 * Y：链表环入口 D 到相遇节点 P2 的距离
 * Z：快慢指针相遇点 P2 到环入口 D的距离
 * C：链表环的距离，即 y + z
 *
 * 假设快慢指针相遇时，快指针在环内走了m圈，慢指针在环内走了n圈，则有：fast=x + y + m * c slow=x + y + n * c
 * => (x + y + m * c) = 2(x + y + n * c)
 * 又因为 c = z + y
 * => x = (m - 2n - 1) * c + z
 *
 * 假设一个指针point1从起点出发，走了(m-2n-1)*c步到达了P位置。
 * 另外一个指针point2从相遇点P2开始出发，也走了(m-2n-1)*c步，最终还是停留在P2的位置（相当于绕环走了c圈而已）。
 * 这个时候，第一个指针point1距离环入口的距离是z，第二个指针point2距离环入口距离是z，所以两个指针再同时走z步，就会在环入口D处相遇
 */
public class DetectCycle {

    public static void main(String[] args) {

    }

    private static ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                ListNode point1 = head;
                ListNode point2 = fast;
                while (point1 != point2) {
                    point1 = point1.next;
                    point2 = point2.next;
                }
                return point1;
            }
        }
        return null;
    }
}
