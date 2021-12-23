package com.zx.algorithm.leetcode;

import com.zx.algorithm.TreeNode;

/**
 * Created by zhangxin on 2021/12/16.
 * Time : 13:17
 * 找出路径和等于给定数值的路径总数。路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 */
public class BinaryTreePathSum3 {

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

        System.out.println(pathSum(root, 8));
    }

    // 除了root节点 还要考虑左右节点为起点的情况
    private static int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        return dfs(root, sum) + pathSum(root.getLeft(), sum) + pathSum(root.getRight(), sum);
    }

    // 以root为根，到任意一点的路径和为sum
    private static int dfs(TreeNode root, int sum) {
        if (root == null) return 0;
        int res = 0;
        if (root.getVal() == sum) res++;
        res += dfs(root.getLeft(), sum - root.getVal());
        res += dfs(root.getRight(), sum - root.getVal());
        return res;
    }
}
