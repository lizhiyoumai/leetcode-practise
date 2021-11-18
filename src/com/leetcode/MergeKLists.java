package com.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 给你一个链表数组，每个链表都已经按升序排列。
 *
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 *
 *
 *
 * 示例 1：
 *
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 * 示例 2：
 *
 * 输入：lists = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：lists = [[]]
 * 输出：[]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MergeKLists {
    //两两合并
    public ListNode mergeKLists1(ListNode[] lists) {
        ListNode res = null;
        for (ListNode listNode : lists) {
            res = mergeTwoLists(res, listNode);
        }
        return res;
    }

    private ListNode mergeTwoLists(ListNode listNode1, ListNode listNode2) {
        if (listNode1 == null) {
            return listNode2;
        }
        if (listNode2 == null) {
            return listNode1;
        }
        if (listNode1.val < listNode2.val) {
            listNode1.next = mergeTwoLists(listNode1.next, listNode2);
            return listNode1;
        } else {
            listNode2.next = mergeTwoLists(listNode2.next, listNode1);
            return listNode2;
        }
    }


    //最小堆
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        PriorityQueue<ListNode> queue = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);
        for (ListNode listNode : lists) {
            if (listNode != null) {
                queue.offer(listNode);
            }
        }
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            head.next = node;
            head = head.next;
            if (node.next != null) {
                queue.offer(node.next);
            }
        }
        return dummy.next;
    }

    private static class ListNode {
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        ListNode[] list = new ListNode[3];
        list[0] = new ListNode(1);
        list[0].next = new ListNode(4);
        list[0].next.next = new ListNode(5);
        list[1] = new ListNode(1);
        list[1].next = new ListNode(3);
        list[1].next.next = new ListNode(4);
        list[2] = new ListNode(2);
        list[2].next = new ListNode(6);

        MergeKLists m = new MergeKLists();
        ListNode node = m.mergeKLists1(list);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}
