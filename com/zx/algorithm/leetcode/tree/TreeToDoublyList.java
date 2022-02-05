package com.zx.algorithm.leetcode.tree;

import com.zx.algorithm.DoubleNode;

/**
 * Created by zhangxin on 2022/01/21.
 * Time : 21:55
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。
 */
public class TreeToDoublyList {

    // pre指针用于保存中序遍历的前一个节点，head指针用于记录排序链表的头节点
    static DoubleNode pre = null, head = null;

    public static void main(String[] args) {

    }

    private static DoubleNode treeToDoublyList(DoubleNode root) {
        if (root == null) return root;
        dfs(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    private static void dfs(DoubleNode root) {
        if (root == null) return;
        dfs(root.left);
        if (pre != null) pre.right = root;
        else head = root; // 此时说明root节点为链表的头结点 也就是最左边的叶子结点
        root.left = pre;
        pre = root;
        dfs(root.right);
    }
}
