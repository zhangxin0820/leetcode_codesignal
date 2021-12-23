package com.zx.algorithm.other;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhangxin on 2021/12/21.
 * Time : 21:09
 */
public class LRUCache {

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(3);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(3, 3);
        cache.get(1);
        cache.put(4, 3);
        System.out.println(cache);
    }

    class Node {
        int key;
        int val;
        Node prev;
        Node next;
    }

    private int capacity;
    private Node first;
    private Node last;

    private Map<Integer, Node> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>(capacity);
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.val;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node == null) {
            node = new Node();
            node.key = key;
            node.val = value;
            if (map.size() == capacity) {
                removeLast();
            }
            addToHead(node);
            map.put(key, node);
        } else {
            node.val = value;
            moveToHead(node);
        }
    }

    private void moveToHead(Node node) {
        if (node == first) {
            return;
        } else if (node == last) {
            node.prev.next = null;
            last = last.prev;
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        node.prev = null;
        node.next = first;
        first.prev = node;
        first = node;
    }

    private void addToHead(Node node) {
        if (map.isEmpty()) {
            first = node;
            last = node;
        } else {
            node.next = first;
            first.prev = node;
            first = node;
        }
    }

    private void removeLast() {
        map.remove(last.key);
        Node preNode = last.prev;
        preNode.next = null;
        last = preNode;
    }

    @Override
    public String toString() {
        return map.keySet().toString();
    }
}
