package com.leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.PriorityQueue;

public class SlidingWindow {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        //定义一个大顶堆
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[0] != o2[0] ? o2[0] - o1[0] : o2[1] - o1[1]);
        //初始化k个元素
        for (int i=0; i<k; i++) {
            queue.offer(new int[]{nums[i], i});
        }
        //定义一个ans数据，用来存放结果
        int[] ans = new int[n-k+1];
        ans[0] = queue.peek()[0];
        for (int i=k; i<n; i++) {
            queue.offer(new int[]{nums[i], i});
            while (queue.peek()[1] <= i-k) {
                queue.poll();
            }
            ans[i-k+1] = queue.peek()[0];
        }
        return ans;
    }

    public static int[] maxSlidingWindowDeque(int[] nums, int k) {
        int n = nums.length;
        //定义双端队列(单调队列),存的是元素的下标
        Deque<Integer> deque = new ArrayDeque<>();
        //初始化k个元素
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }
        //定义一个ans数据，用来存放结果
        int[] ans = new int[n-k+1];
        ans[0] = nums[deque.peekFirst()];
        for (int i = k; i < n; i++) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            while (deque.peekFirst() <= i-k) {
                deque.pollFirst();
            }
            ans[i-k+1] = nums[deque.peekFirst()];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,-1,-3,5,3,6,7};
        int k = 3;
//        System.out.println(Arrays.toString(maxSlidingWindow(nums, k)));
        System.out.println(Arrays.toString(maxSlidingWindowDeque(nums, k)));
    }
}
