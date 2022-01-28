package com.zx.algorithm;

/**
 * Created by zhangxin on 2022/01/27.
 * Time : 21:41
 * 前缀树节点
 */
public class TrieNode {

    private TrieNode root;
    public TrieNode[] children;
    public String val;
    public TrieNode() {
        children = new TrieNode[26];
    }

    public void put(String key) {
        root = put(root, key, 0);
    }

    private TrieNode put(TrieNode node, String key, int i) {
        if (node == null) node = new TrieNode();
        if (i == key.length()) {
            node.val = key;
            return node;
        }
        char c = key.charAt(i);
        node.children[c - 'a'] = put(node.children[c - 'a'], key, i + 1);
        return node;
    }

    public String shortestPrefixOf(String query) {
        TrieNode cur = root;
        for (int i = 0; i < query.length(); i++) {
            if (cur == null) return "";
            if (cur.val != null) return query.substring(0, i);
            char c = query.charAt(i);
            cur = cur.children[c - 'a'];
        }
        if (cur != null && cur.val != null) return query;
        return "";
    }
}
