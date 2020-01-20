package com.zx.algorithm.other;

/**
 * @author zhangxin82@jd.com
 * @create 2019/11/28 12:05 下午
 * @description 单链表反转
 */

public class ReverseLinkedList {

    private class Node {
        private String data;//数据域
        private Node next;//指针域

        public Node(String data) {
            this.data = data;
        }

        public Node(String data, Node next) {
            this.data = data;
            this.next = next;
        }

        public Object getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    public static Node reverseListNode(Node head) {

        if (head == null || head.getNext() == null) {
            return head;
        }

        Node pre = null;
        Node cur = head;
        Node next = null;

        while (cur != null) {
            next = cur.getNext();
            cur.setNext(pre);
            pre = cur;
            cur = next;
        }

        return pre;
    }
}