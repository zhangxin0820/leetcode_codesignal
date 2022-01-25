package com.zx.algorithm;

/**
 * Created by zhangxin on 2022/01/21.
 * Time : 21:57
 */
public class DoubleNode {

    public int val;
    public DoubleNode left;
    public DoubleNode right;

    public DoubleNode() {
    }

    public DoubleNode(int _val) {
        val = _val;
    }

    public DoubleNode(int _val, DoubleNode _left, DoubleNode _right) {
        val = _val;
        left = _left;
        right = _right;
    }
}
