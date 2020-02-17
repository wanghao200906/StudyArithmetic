package forLeetcode.leetcode_0209_minimum_size_subarray_sum;

// Leetcode 209
// https://leetcode-cn.com/problems/minimum-size-subarray-sum/



/*
长度最小的子数组

给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组。如果不存在符合条件的连续子数组，返回 0。

示例: 

输入: s = 7, nums = [2,3,1,2,4,3]
输出: 2
解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
进阶:

如果你已经完成了O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。


使用滑动窗口的技术， 在数组中。一个l 一个r.根据情况 向右移动 r 或者l。

 */


public class Solution {

    public static void main(String[] args) {
        int[] arr = {2,3,1,2,4,3};
        System.out.println(minSubArrayLen(7,arr));
    }

    public static int minSubArrayLen(int s, int[] nums) {

        int l = 0, r = -1, sum = 0, res = nums.length + 1;
        while (l < nums.length) {

            if (r + 1 < nums.length && sum < s) {
//                和小于S 就让有边界的r向右移动一位。
                r++;
                sum = sum + nums[r];

            } else {

                sum = sum - nums[l];
                l++;
            }

            if (sum >= s) {
                res = Math.min(res, r - l + 1);
            }

        }


//        这个的作用就是没有合适的答案。 res还是初始化的值。
        if (res == nums.length + 1) {
            return 0;
        }

        return res;
    }

}