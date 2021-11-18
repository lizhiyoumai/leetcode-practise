package com.leetcode;

import com.leetcode.jianoffer.ReversePrint;

/**
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 *
 * 进阶：你能尝试使用一趟扫描实现吗？
 *
 * 示例 1：
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * 示例 2：
 *
 * 输入：head = [1], n = 1
 * 输出：[]
 * 示例 3：
 *
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RemoveNthFromEnd {
    //快慢指针法
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return head;
        }
        //定义快慢指针
        ListNode fast = head;
        ListNode slow = head;
        //快指针先移动n步
        while (n > 0) {
            fast = fast.next;
            n --;
        }
        if (fast == null) {
            return head.next;
        }
        //同时移动快慢指针，直到快指针next指向null
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        //删除slow的后继节点
        slow.next = slow.next.next;
        return head;
    }

    private static class ListNode {
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(4);
        ListNode n4 = new ListNode(5);
        head.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        RemoveNthFromEnd r = new RemoveNthFromEnd();
        ListNode node = r.removeNthFromEnd(head, 5);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}
