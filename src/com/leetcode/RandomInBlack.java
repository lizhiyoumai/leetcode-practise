package com.leetcode;

/**
 * 710. 黑名单中的随机数
 * 给定一个包含 [0，n) 中不重复整数的黑名单 blacklist ，写一个函数从 [0, n) 中返回一个不在 blacklist 中的随机整数。
 *
 * 对它进行优化使其尽量少调用系统方法 Math.random() 。
 *
 * 提示:
 *
 * 1 <= n <= 1000000000
 * 0 <= blacklist.length < min(100000, N)
 * [0, n)不包含 n ，详细参见interval notation。
 * 示例 1：
 *
 * 输入：
 * ["Solution","pick","pick","pick"]
 * [[1,[]],[],[],[]]
 * 输出：[null,0,0,0]
 * 示例 2：
 *
 * 输入：
 * ["Solution","pick","pick","pick"]
 * [[2,[]],[],[],[]]
 * 输出：[null,1,1,1]
 * 示例 3：
 *
 * 输入：
 * ["Solution","pick","pick","pick"]
 * [[3,[1]],[],[],[]]
 * 输出：[null,0,0,2]
 * 示例 4：
 *
 * 输入： 
 * ["Solution","pick","pick","pick"]
 * [[4,[2]],[],[],[]]
 * 输出：[null,1,3,1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/random-pick-with-blacklist
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RandomInBlack {

    public RandomInBlack(int n, int[] blacklist) {

    }

    public int pick() {
        return 0;
    }
}
