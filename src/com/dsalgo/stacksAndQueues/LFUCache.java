package com.dsalgo.stacksAndQueues;

import java.util.HashMap;
import java.util.Map;


//https://leetcode.com/problems/lfu-cache/
public class LFUCache {

    static class DLLNode {

        int key, value, frequency;
        DLLNode prev, next;

        DLLNode(int key, int value) {
            this.key = key;
            this.value = value;
            this.frequency = 1;
        }

    }

    Map<Integer, DLLNode> cache;
    Map<Integer, DoubleLinkedList> frequencyMap;
    DLLNode head, tail;
    int minFrequency, capacity, currCnt;

    LFUCache(int capacity) {
        this.capacity = capacity;
        head = new DLLNode(0, 0);
        tail = new DLLNode(0, 0);
        head.next = tail;
        tail.prev = head;
        cache = new HashMap<>();
        frequencyMap = new HashMap<>();
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            DLLNode node = cache.get(key);
            node.value = value;
            updateNode(node);
        } else {
            currCnt++;
            if (currCnt > capacity) {
                DoubleLinkedList minFreqList = frequencyMap.get(minFrequency);
                cache.remove(minFreqList.tail.prev.key);
                minFreqList.removeNode(minFreqList.tail.prev);
                currCnt--;
            }
            minFrequency = 1;
            DLLNode newNode = new DLLNode(key, value);

            DoubleLinkedList curList = frequencyMap.getOrDefault(1, new DoubleLinkedList());
            curList.addNode(newNode);
            frequencyMap.put(1, curList);
            cache.put(key, newNode);

        }
    }

    public int get(int key) {
        DLLNode curNode = cache.get(key);
        if (curNode == null) {
            return -1;
        }
        updateNode(curNode);
        return curNode.value;
    }

    private void updateNode(DLLNode currNode) {

        int currFrequency = currNode.frequency;
        DoubleLinkedList currList = frequencyMap.get(currFrequency);
        currList.removeNode(currNode);

        if (minFrequency == currFrequency && currList.listSize == 0) {
            minFrequency++;
        }
        currNode.frequency++;
        DoubleLinkedList newList = frequencyMap.getOrDefault(currFrequency, new DoubleLinkedList());
        newList.addNode(currNode);
        frequencyMap.put(currNode.frequency, newList);
    }

    class DoubleLinkedList {
        int listSize;
        DLLNode head;
        DLLNode tail;

        public DoubleLinkedList() {
            this.listSize = 0;
            this.head = new DLLNode(0, 0);
            this.tail = new DLLNode(0, 0);
            head.next = tail;
            tail.prev = head;
        }

        /**
         * add new node into head of list and increase list size by 1
         **/
        public void addNode(DLLNode curNode) {
            DLLNode nextNode = head.next;
            curNode.next = nextNode;
            curNode.prev = head;
            head.next = curNode;
            nextNode.prev = curNode;
            listSize++;
        }

        /**
         * remove input node and decrease list size by 1
         **/
        public void removeNode(DLLNode curNode) {
            DLLNode prevNode = curNode.prev;
            DLLNode nextNode = curNode.next;
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
            listSize--;
        }

    }
}
