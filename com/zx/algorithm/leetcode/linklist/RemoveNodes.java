package com.zx.algorithm.leetcode.linklist;

import com.zx.algorithm.ListNode;

/**
 * 2487. 从链表中移除节点
 * 给你一个链表的头节点 head 。移除每个右侧有一个更大数值的节点。返回修改后链表的头节点 head 。
 * <p>
 * 示例：
 * 输入：head = [5,2,13,3,8]
 * 输出：[13,8]
 * 解释：需要移除的节点是 5 ，2 和 3 。
 * 节点 13 在节点 5 右侧。
 * 节点 13 在节点 2 右侧。
 * 节点 8 在节点 3 右侧。
 */
public class RemoveNodes {

    public static void main(String[] args) {

    }

    public static ListNode removeNodes(ListNode head) {
        head = reverse(head);
        ListNode cur = head;
        while (cur.next != null) {
            if (cur.val > cur.next.val) cur.next = cur.next.next;
            else cur = cur.next;
        }
        return reverse(head);
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
