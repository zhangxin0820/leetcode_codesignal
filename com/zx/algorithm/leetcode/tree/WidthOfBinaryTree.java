package com.zx.algorithm.leetcode.tree;

import com.zx.algorithm.IndexTreeNode;
import com.zx.algorithm.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by zhangxin on 2022/01/28.
 * Time : 15:34
 * 给定一个二叉树，编写一个函数来获取这个树的最大宽度。树的宽度是所有层中的最大宽度。这个二叉树与满二叉树（full binary tree）结构相同，但一些节点为空。
 *
 * 每一层的宽度被定义为两个端点（该层最左和最右的非空节点，两端点间的null节点也计入长度）之间的长度。
 */
public class WidthOfBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);

        root.setLeft(node1);
        root.setRight(node2);
        node1.setLeft(node3);
        node1.setRight(node4);
        node3.setLeft(node5);
        node3.setRight(node6);
        node6.setLeft(node7);
        node6.setRight(node8);

        System.out.println("二叉树的最大宽度 : ");
        System.out.println(widthOfBinaryTree(root));
    }

    // 二叉树的最大宽度 每一层的宽度被定义为两个端点（该层最左和最右的非空节点，两端点间的null节点也计入长度）之间的长度。
    // 记录每个node的序号 按照left=2*root+1 right=2*root+2
    // 遍历每层 用最后一个node序号-第一个node序号 再+1 得到每一层的最大宽度
    private static int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        Deque<IndexTreeNode> deque = new LinkedList<>();
        deque.offerLast(new IndexTreeNode(root, 0));
        int maxWidth = 1;
        while (!deque.isEmpty()) {
            int size = deque.size();
            maxWidth = Math.max(maxWidth, deque.peekLast().getIndex() - deque.peekFirst().getIndex() + 1);
            for (int i = 0; i < size; i++) {
                IndexTreeNode node = deque.pollFirst();
                TreeNode left = node.getNode().getLeft();
                if (left != null) deque.offerLast(new IndexTreeNode(left, node.getIndex() * 2 + 1));
                TreeNode right = node.getNode().getRight();
                if (right != null) deque.offerLast(new IndexTreeNode(right, node.getIndex() * 2 + 2));
            }
        }
        return maxWidth;
    }
}
