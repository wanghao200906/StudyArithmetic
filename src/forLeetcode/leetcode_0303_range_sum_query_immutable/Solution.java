package forLeetcode.leetcode_0303_range_sum_query_immutable;

import java.util.Stack;

/*
leetcode 20
https://leetcode-cn.com/problems/range-sum-query-immutable

区域和检索 - 数组不可变


给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。

示例：

给定 nums = [-2, 0, 3, -5, 2, -1]，求和函数为 sumRange()

sumRange(0, 2) -> 1
sumRange(2, 5) -> -1
sumRange(0, 5) -> -3
说明:

你可以假设数组不可变。
会多次调用 sumRange 方法。



 */
public class Solution {

    public static class NumArray {

        private int[] sum;
        // sum[i]存储前i个元素和, sum[0] = 0

        // 即sum[i]存储nums[0...i-1]的和
        // sum(i, j) = sum[j + 1] - sum[i]
//        这里的 sum[j + 1] 就是 0到 j的的数组的和。
//        sum[i] 就是 0到 i-1数组的和
//        sum[j + 1] - sum[i] 就是  i到 j的和。
        public NumArray(int[] nums) {

//            这里的sum是nums.length + 1 之所以要加1 就是因为，
            sum = new int[nums.length + 1];
            sum[0] = 0;
            for (int i = 1; i < sum.length; i++)
                sum[i] = sum[i - 1] + nums[i - 1];
        }

        public int sumRange(int i, int j) {
            return sum[j + 1] - sum[i];
        }

    }

    public static void main(String[] args) {
        int[] arr = {-2, 0, 3, -5, 2, -1};
        NumArray numArray = new NumArray(arr);
        int i = numArray.sumRange(0, 2);
        System.out.println(i);
    }
}
