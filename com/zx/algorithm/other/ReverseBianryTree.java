package com.zx.algorithm.other;

import com.zx.algorithm.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by zhangxin on 2021/12/24.
 * Time : 12:55
 * 反转二叉树
 */
public class ReverseBianryTree {

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

//        TreeNode node = reverse(root);
        TreeNode node = reverse_2(root);
        System.out.println(node.getLeft().getVal());
        System.out.println(node.getRight().getVal());
        System.out.println(node.getRight().getLeft().getVal());
        System.out.println(node.getRight().getRight().getVal());
    }

    private static TreeNode reverse(TreeNode root) {
        if (root == null) return null;
        swap(root);
        if (root.getLeft() != null) reverse(root.getLeft());
        if (root.getRight() != null) reverse(root.getRight());
        return root;
    }

    private static TreeNode reverse_2(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            swap(node);
            if (node.getLeft() != null) queue.offer(node.getLeft());
            if (node.getRight() != null) queue.offer(node.getRight());
        }
        return root;
    }

    private static void swap(TreeNode root) {
        TreeNode tmp = root.getLeft();
        root.setLeft(root.getRight());
        root.setRight(tmp);
    }
}
