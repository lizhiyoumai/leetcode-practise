package com.leetcode;

import com.sun.tools.hat.internal.model.Root;

import java.util.LinkedList;

/**
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 *
 * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 *
 * 提示: 输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
 *
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TreeCodec {
    private static final String SPLIT = ",";
    private static final String EMPTY = "null";
    // Encodes a tree to a single string.
    //使用前序遍历
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        encode(root, sb);
        return sb.toString();
    }

    private void encode(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(EMPTY).append(SPLIT);
            return;
        }
        sb.append(root.val).append(SPLIT);
        encode(root.left, sb);
        encode(root.right, sb);
    }

    // Decodes your encoded data to tree.
    //使用前序遍历
    public TreeNode deserialize(String data) {
        LinkedList<String> nodes = new LinkedList<>();
        String[] s = data.split(SPLIT);
        for (String str : s) {
            nodes.add(str);
        }
        return decode(nodes);
    }

    private TreeNode decode(LinkedList<String> nodes) {
        if (nodes.size() == 0) {
            return null;
        }
        String first = nodes.poll();
        if (EMPTY.equals(first)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(first));
        root.left = decode(nodes);
        root.right = decode(nodes);
        return root;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(3);
        TreeNode n3 = new TreeNode(4);
        TreeNode n4 = new TreeNode(5);
        root.left = n1;
        root.right = n2;
        n2.left = n3;
        n2.right = n4;
        TreeCodec treeCodec = new TreeCodec();
        String data = treeCodec.serialize(root);
        System.out.println(data);
        TreeNode node = treeCodec.deserialize(data);
    }
}
