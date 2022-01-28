package com.zx.algorithm.other;

import com.zx.algorithm.IndexTreeNode;
import com.zx.algorithm.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by zhangxin on 2021/12/16.
 * Time : 13:44
 */
public class BinaryTree {

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

        System.out.println("递归前序遍历 : ");
        recursivePreOrder(root);
        System.out.println("\n递归中序遍历 : ");
        recursiveInOrder(root);
        System.out.println("\n递归后序遍历 : ");
        recursivePostOrder(root);
        System.out.println("\n=========================");
        System.out.println("非递归前序遍历 : ");
        iterativePreOrder(root);
        System.out.println("\n非递归前序遍历_2 : ");
        iterativePreOrder_2(root);
        System.out.println("\n非递归中序遍历 : ");
        iterativeInOrder(root);
        System.out.println("\n非递归后序遍历 : ");
        iterativePostOrder(root);
        System.out.println("\n非递归层次遍历 : ");
        iterativeLevelOrder(root);
        System.out.println("二叉树的深度 : ");
        System.out.println(maxDepth(root));
        System.out.println("二叉树的深度(非递归) : ");
        System.out.println(maxDepthLevelOrder(root));
    }

    private static void recursivePreOrder(TreeNode root) {
        if (root == null) return;
        visit(root);
        recursivePreOrder(root.getLeft());
        recursivePreOrder(root.getRight());
    }

    private static void recursiveInOrder(TreeNode root) {
        if (root == null) return;
        recursiveInOrder(root.getLeft());
        visit(root);
        recursiveInOrder(root.getRight());
    }

    private static void recursivePostOrder(TreeNode root) {
        if (root == null) return;
        recursivePostOrder(root.getLeft());
        recursivePostOrder(root.getRight());
        visit(root);
    }

    private static void iterativePreOrder(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                visit(node);
                stack.push(node);
                node = node.getLeft();
            }
            node = stack.pop();
            node = node.getRight();
        }
    }

    // 栈的思路(先进后出) root是第一个打印 然后right进栈 最后left进栈 下一次循环 首先left作为子root会弹出
    private static void iterativePreOrder_2(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        stack.push(node);
        while (!stack.isEmpty()) {
            node = stack.pop();
            visit(node);
            if (node.getRight() != null) stack.push(node.getRight());
            if (node.getLeft() != null) stack.push(node.getLeft());
        }
    }

    private static void iterativeInOrder(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.getLeft();
            }
            node = stack.pop();
            visit(node);
            node = node.getRight();
        }
    }

    // 逆后序遍历为root->right->left 是: 前序遍历交换左右顺序(前序：root->left->right)
    // 具体参考 iterativePreOrder_2() 函数
    private static void iterativePostOrder(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> result = new Stack<>();
        TreeNode node = root;
        stack.push(node);
        while (!stack.isEmpty()) {
            node = stack.pop();
            result.push(node);
            if (node.getLeft() != null) stack.push(node.getLeft());
            if (node.getRight() != null) stack.push(node.getRight());
        }
        while (!result.isEmpty()) {
            visit(result.pop());
        }
    }

    private static void iterativeLevelOrder(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode node = root;
        queue.offer(node);
        while (!queue.isEmpty()) {
            int level = queue.size();
            for (int i = 0; i < level; i++) {
                node = queue.poll();
                visit(node);
                if (node.getLeft() != null) queue.offer(node.getLeft());
                if (node.getRight() != null) queue.offer(node.getRight());
            }
            System.out.println();
        }
    }

    private static int maxDepth(TreeNode root) {
        if (root == null) return 0;
        TreeNode node = root;
        return Math.max(maxDepth(node.getLeft()),maxDepth(node.getRight())) + 1;
    }

    // 层次遍历实现树的最大深度
    private static int maxDepthLevelOrder(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode node = root;
        queue.offer(node);
        int depth = 0;
        while (!queue.isEmpty()) {
            int level = queue.size();
            depth++;
            for (int i = 0; i < level; i++) {
                node = queue.poll();
                if (node.getLeft() != null) queue.offer(node.getLeft());
                if (node.getRight() != null) queue.offer(node.getRight());
            }
        }
        return depth;
    }

    private static void visit(TreeNode node) {
        System.out.print(node.getVal() + " ");
    }
}
