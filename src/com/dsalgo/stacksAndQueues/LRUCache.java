package com.dsalgo.stacksAndQueues;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/lru-cache/
public class LRUCache {

    static Node head, tail;
    static int capacity, cnt;
    static Map<Integer, Node> hsMap = new HashMap<>();

    LRUCache(int cap) {
        hsMap = new HashMap<>();
        this.capacity = cap;
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        head.pre = null;
        tail.next = null;
        tail.pre = head;
        cnt = 0;
    }

    public int get(int key) {
        if (hsMap.containsKey(key)) {
            Node node = hsMap.get(key);
            int tmp = node.value;
            deleteNode(node);
            addNodeToHead(node);
            return tmp;
        } else {
            return -1;
        }
    }

    public void add(int key, int value) {
        if (hsMap.containsKey(key)) {
            Node node = hsMap.get(key);
            node.value = value;
            deleteNode(node);
            addNodeToHead(node);
        } else {
            Node node = new Node(key, value);
            hsMap.put(key, node);
            if (cnt < capacity) {
                addNodeToHead(node);
                cnt++;
            } else {
                hsMap.remove(tail.pre.key);
                deleteNode(tail.pre);
                addNodeToHead(node);
            }
        }
    }

    private static void addNodeToHead(Node node) {
        node.next = head.next;
        node.next.pre = node;
        node.pre = head;
        head.next = node;
    }

    private static void deleteNode(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    public static void main(String[] args) {

        LRUCache cache = new LRUCache(2);
        cache.add(1, 3);
        cache.add(2, 4);
        System.out.println(cache.get(2));
        cache.add(4, 6);
        System.out.println(cache.get(1));

    }

    static class Node {

        int key, value;
        Node pre, next;

        Node(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }

    }
}
