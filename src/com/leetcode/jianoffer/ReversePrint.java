package com.leetcode.jianoffer;

import java.util.Arrays;
import java.util.LinkedList;

/**
 *
 */
public class ReversePrint {
    public int[] reversePrint(ListNode head) {
        if (head == null) {
            return new int[]{};
        }
        //定义一个栈
        LinkedList<Integer> stack = new LinkedList<>();
        while (head != null) {
            stack.addLast(head.val);
            head = head.next;
        }
        //定义返回数组
        int size = stack.size();
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = stack.removeLast();
        }
        return result;
    }

    private static class ListNode {
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        ReversePrint reversePrint = new ReversePrint();
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        head.next = node1;
        node1.next = node2;
        System.out.println(Arrays.toString(reversePrint.reversePrint(head)));
    }
}
