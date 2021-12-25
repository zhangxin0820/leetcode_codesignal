package com.zx.algorithm.leetcode;

import com.zx.algorithm.TreeNode;

import java.util.Stack;

/**
 * Created by zhangxin on 2021/12/16.
 * Time : 13:05
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 */
public class BinaryTreePathSum1 {

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

        System.out.println(hasPathSum(root, 2));
        System.out.println(hasPathSum_2(root, 2));
    }

    private static boolean hasPathSum(TreeNode node, int sum) {
        if (node == null) return false;

        if (node.getLeft() == null && node.getRight() == null) {
            if (node.getVal() == sum) return true;
        }

        return hasPathSum(node.getLeft(), sum - node.getVal()) || hasPathSum(node.getRight(), sum - node.getVal());
    }

    private static boolean hasPathSum_2(TreeNode node, int sum) {
        if (node == null) return false;
        Stack<TreeNode> tree = new Stack<>();
        Stack<Integer> value = new Stack<>();
        tree.push(node);
        value.push(node.getVal());
        while (!tree.isEmpty()) {
            TreeNode p = tree.pop();
            int v = value.pop();
            if (p.getLeft() == null && p.getRight() == null && sum == v) return true;
            if (p.getRight() != null) {
                tree.push(p.getRight());
                value.push(p.getRight().getVal() + v);
            }

            if (p.getLeft() != null) {
                tree.push(p.getLeft());
                value.push(p.getLeft().getVal() + v);
            }
        }
        return false;
    }
}
