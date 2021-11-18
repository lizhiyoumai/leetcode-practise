package com.leetcode;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * 运用你所掌握的数据结构，设计和实现一个 LRU (最近最少使用) 缓存机制 。
 * 实现 LRUCache 类：
 *
 * LRUCache(int capacity) 以正整数作为容量capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value)如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 *
 *
 * 进阶：你是否可以在O(1) 时间复杂度内完成这两种操作？
 *
 *
 *
 * 示例：
 *
 * 输入
 * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
 * 输出
 * [null, null, null, 1, null, -1, null, -1, 3, 4]
 *
 * 解释
 * LRUCache lRUCache = new LRUCache(2);
 * lRUCache.put(1, 1); // 缓存是 {1=1}
 * lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
 * lRUCache.get(1);    // 返回 1
 * lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
 * lRUCache.get(2);    // 返回 -1 (未找到)
 * lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
 * lRUCache.get(1);    // 返回 -1 (未找到)
 * lRUCache.get(3);    // 返回 3
 * lRUCache.get(4);    // 返回 4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lru-cache
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LRUCache {
    // key -> Node(key, val)
    private HashMap<Integer, Node> map;
    // Node(k1, v1) <-> Node(k2, v2)...
    private DoublyLinkedList cache;
    // 最大容量
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        cache = new DoublyLinkedList();
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        int val = map.get(key).val;
        put(key, val);
        return val;
    }

    public void put(int key, int value) {
        Node newNode = new Node(key, value);
        if (!map.containsKey(key)) {
            if (cache.size() == capacity) {
                //删除链表最后一条数据
                Node last = cache.removeLast();
                map.remove(last.key);
            }
            //新数据添加到链表头部
            cache.addFirst(newNode);
            map.put(key, newNode);
        } else {
            //删除链表中的该数据
            cache.remove(map.get(key));
            //将该数据添加到链表头部
            cache.addFirst(newNode);
            //更新map的数据
            map.put(key, newNode);
        }
    }


    class Node {
        private int key;
        private int val;
        private Node pre;
        private Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    class DoublyLinkedList {
        int size;
        Node head;
        Node tail;

        public DoublyLinkedList() {
            size = 0;
            head = new Node(0,0);
            tail = new Node(0,0);
            head.next = tail;
            tail.pre = head;
        }

        //在链表头部添加节点x
        public void addFirst(Node x) {
            Node fist = head.next;
            head.next = x;
            x.next = fist;
            fist.pre = x;
            x.pre = head;
            size ++;
        }

        //删除链表中的x节点（x一定存在）
        public void remove(Node x) {
            Node pre = x.pre;
            Node next = x.next;
            pre.next = next;
            next.pre = pre;
            size --;
        }

        //删除链表中最后一个节点，并返回该节点
        public Node removeLast() {
            Node last = tail.pre;
            Node lastPre = last.pre;
            lastPre.next = tail;
            tail.pre = lastPre;
            size --;
            return last;
        }

        //返回链表长度
        public int size() {
            return size;
        }
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        System.out.println(lruCache.get(1));
        lruCache.put(3, 3);
        System.out.println(lruCache.get(2));
        lruCache.put(4, 4);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));
    }
}
