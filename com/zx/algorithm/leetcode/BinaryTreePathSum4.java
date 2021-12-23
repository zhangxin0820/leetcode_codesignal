package com.zx.algorithm.leetcode;

import com.zx.algorithm.TreeNode;

/**
 * Created by zhangxin on 2021/12/21.
 * Time : 22:41
 * 给定一个非空二叉树，返回其最大路径和。本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
 */
public class BinaryTreePathSum4 {

    private static int max = Integer.MIN_VALUE;

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

        System.out.println(pathSum(root));
    }

    private static int pathSum(TreeNode root) {
        if (root == null) return 0;
        dfs(root);
        return max;
    }

    private static int dfs(TreeNode root) {
        if (root == null) return 0;
        int left = Math.max(dfs(root.getLeft()), 0);
        int right = Math.max(dfs(root.getRight()), 0);
        int curMax = root.getVal() + left + right;
        max = Math.max(max, curMax);
        return root.getVal() + Math.max(left, right);
    }
}
