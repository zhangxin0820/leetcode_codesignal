package com.zx.algorithm.leetcode.backtrack;

import com.zx.algorithm.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangxin on 2021/12/16.
 * Time : 13:17
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 */
public class BinaryTreePathSum2 {

    static List<List<Integer>> result = new ArrayList<>();

    public static void main(String[] args) {

        TreeNode root = new TreeNode(5);
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(8);
        TreeNode node3 = new TreeNode(11);
        TreeNode node4 = new TreeNode(13);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(7);
        TreeNode node7 = new TreeNode(2);
        TreeNode node8 = new TreeNode(5);
        TreeNode node9 = new TreeNode(1);

        root.setLeft(node1);
        root.setRight(node2);
        node1.setLeft(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);
        node3.setRight(node7);
        node5.setLeft(node8);
        node5.setRight(node9);

        pathSum(root, 22);
        if (!result.isEmpty()) {
            System.out.println(result);
        }
    }

    private static void pathSum(TreeNode node, int target) {
        if (node == null) return;
        List<Integer> path = new ArrayList<>();
        findPath(node, target, path);
    }

    private static void findPath(TreeNode node, int target, List<Integer> path) {

        path.add(node.getVal());

        if (node.getLeft() == null && node.getRight() == null) {
            if (target == node.getVal()) {
                result.add(new ArrayList<>(path));
            }
        }

        if (node.getLeft() != null) findPath(node.getLeft(), target - node.getVal(), path);
        if (node.getRight() != null) findPath(node.getRight(), target - node.getVal(), path);

        path.remove(path.size() - 1);
    }
}
