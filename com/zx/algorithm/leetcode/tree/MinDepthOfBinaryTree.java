package com.zx.algorithm.leetcode.tree;

import com.zx.algorithm.TreeNode;

/**
 * Created by zhangxin on 2022/01/28.
 * Time : 16:02
 * 给定一个二叉树，找出其最小深度。
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * 说明：叶子节点是指没有子节点的节点。
 */
public class MinDepthOfBinaryTree {

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

        System.out.println(minDepth(root));
    }

    private static int minDepth(TreeNode root) {
        if (root == null) return 0;
        int left = minDepth(root.getLeft());
        int right = minDepth(root.getRight());
        if (left == 0 || right == 0) return left + right + 1;
        else return Math.min(left, right) + 1;
    }
}
