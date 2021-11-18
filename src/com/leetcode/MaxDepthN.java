package com.leetcode;

import java.util.List;

public class MaxDepthN {
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        int max = 0;
        for (int i = 0; i < root.children.size(); i++) {
            max = Math.max(max, maxDepth(root.children.get(i)));
        }
        return max;
    }

    private static class Node {
        public int val;
        public List<Node> children;
        public Node(int val) {
            this.val = val;
        }
    }
}
