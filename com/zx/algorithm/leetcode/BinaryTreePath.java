package com.zx.algorithm.leetcode;

import com.zx.algorithm.TreeNode;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by zhangxin on 2021/12/16.
 * Time : 12:31
 * 二叉树根节点到指定节点的路径
 */
public class BinaryTreePath {

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

        LinkedList<TreeNode> path = new LinkedList<>();
        boolean hasPath = getPathToRoot(root, node6, path);
        if (hasPath) {
            path.forEach(node -> System.out.print(node.getVal() + " "));
        }

        System.out.println();
        System.out.println("==================");
        Stack<TreeNode> stack = new Stack<>();
        getPathToRoot_2(root, node6, stack);
    }

    private static boolean getPathToRoot(TreeNode node, TreeNode target, LinkedList<TreeNode> path) {
        if (node == null) return false;

        path.push(node);
        if (node == target) return true;

        if (getPathToRoot(node.getLeft(), target, path)) return true;
        if (getPathToRoot(node.getRight(), target, path)) return true;

        path.pop();
        return false;
    }

    private static void getPathToRoot_2(TreeNode root, TreeNode target, Stack<TreeNode> stack) {
        if (root == null || target == null) return;
        TreeNode node = root;
        TreeNode pre = null;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                if (node.getVal() == target.getVal()) {
                    stack.forEach(p -> System.out.print(p.getVal() + " "));
                    return;
                }
                node = node.getLeft();
            }
            if (!stack.isEmpty()) {
                node = stack.peek();
                while (node.getRight() == null || (pre != null && pre == node.getRight())) {
                    pre = stack.pop();
                    node = stack.peek();
                }
                node = node.getRight();
            }
        }
    }
}
