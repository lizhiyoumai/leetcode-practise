package com.leetcode;

import java.util.*;

/**
 * 给一非空的单词列表，返回前k个出现次数最多的单词。
 *
 * 返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。
 *
 * 示例 1：
 *
 * 输入: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
 * 输出: ["i", "love"]
 * 解析: "i" 和 "love" 为出现次数最多的两个单词，均为2次。
 *     注意，按字母顺序 "i" 在 "love" 之前。
 * 
 *
 * 示例 2：
 *
 * 输入: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
 * 输出: ["the", "is", "sunny", "day"]
 * 解析: "the", "is", "sunny" 和 "day" 是出现次数最多的四个单词，
 *     出现次数依次为 4, 3, 2 和 1 次。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/top-k-frequent-words
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TopKFrequent {
    //使用小顶堆实现
    public List<String> topKFrequent(String[] words, int k) {
        //定义一个map，记录每个单词出现的次数
        Map<String, Integer> map = new HashMap<>(words.length);
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        //定义一个小顶堆，用来存放频次前K高的单词
        PriorityQueue<String> queue = new PriorityQueue<>((o1, o2) -> map.get(o1).equals(map.get(o2)) ? o1.compareTo(o2) : map.get(o2).compareTo(map.get(o1)));
        for (String word : map.keySet()) {
            queue.offer(word);
        }
        List<String> res = new ArrayList<>();
        while (!queue.isEmpty() && res.size() < k) {
            res.add(queue.poll());
        }
        return res;
    }

    public static void main(String[] args) {
        String[] words = new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        int k = 4;
        TopKFrequent tf = new TopKFrequent();
        System.out.println(tf.topKFrequent(words, k));
    }
}
