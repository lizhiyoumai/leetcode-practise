package com.leetcode;

import java.util.*;

public class LevelOrderN {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        if (root != null) {
            queue.offer(root);
        }
        while (!queue.isEmpty()) {
            List<Integer> curr = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                curr.add(node.val);
                if (node.children != null && node.children.size() > 0) {
                    for (int j = 0; j < node.children.size(); j++) {
                        queue.offer(node.children.get(j));
                    }
                }
            }
            res.add(curr);
        }
        return res;
    }

    private static class Node {
        public int val;
        public List<Node> children;
        public Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        Node n1 = new Node(3);
        Node n2 = new Node(2);
        Node n3 = new Node(4);
        Node n4 = new Node(5);
        Node n5 = new Node(6);
        List<Node> childs = new ArrayList<>();
        childs.add(n1);
        childs.add(n2);
        childs.add(n3);
        root.children = childs;
        List<Node> childs1 = new ArrayList<>();
        childs1.add(n4);
        childs1.add(n5);
        n1.children = childs1;
        System.out.println(new LevelOrderN().levelOrder(root));
    }
}
