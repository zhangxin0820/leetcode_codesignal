package com.zx.algorithm;

/**
 * Created by zhangxin on 2022/01/24.
 * Time : 09:07
 */
public class IndexTreeNode {

    private TreeNode node;
    private int index;

    public IndexTreeNode(TreeNode node, int index) {
        this.node = node;
        this.index = index;
    }

    public TreeNode getNode() {
        return node;
    }

    public void setNode(TreeNode node) {
        this.node = node;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
