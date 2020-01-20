package com.zx.algorithm.other;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author zhangxin82@jd.com
 * @create 2019/12/11 9:16 下午
 * @description 寻找二叉树上从根结点到给定结点的路径
 */

public class SearchBinaryTreeNode {

    public List<Node> searchNode(Node root, Node node) {

        List<Node> result = new ArrayList<>();

        if (root == null || node == null) return result;

        Stack<Node> stack = new Stack<>();

        Node p = root;
        Node pre = null;

        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.push(p);
                if (p.getData().equals(root.getData())) {
                    result.addAll(stack);
                    break;
                }
                p = p.getLeft();
            }
            if (!stack.isEmpty()) {
                p = stack.peek();
                while (p.getRight() == null || (pre != null && pre == p.getRight())) {
                    pre = stack.pop();
                    p = stack.peek();
                }
                p = p.getRight();
            }
        }
        return result;
    }

    private class Node {
        private Integer data;
        private Node left;
        private Node right;

        public Node(Integer data) {
            this.data = data;
        }

        public Node(Integer data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

        public Integer getData() {
            return data;
        }

        public void setData(Integer data) {
            this.data = data;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }
}
