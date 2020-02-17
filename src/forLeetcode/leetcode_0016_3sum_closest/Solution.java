package forLeetcode.leetcode_0016_3sum_closest;

/// 16
// https://leetcode-cn.com/problems/3sum-closest/



/*
最接近的三数之和

给定一个包括 n 个整数的数组 nums 和 一个目标值 target。
找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。

例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.

与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).

*/

import DataStructure.DS_02_Stack.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {

    }

    public int threeSumClosest(int[] nums, int target) {
        if (nums == null && nums.length < 3) {
            throw new IllegalArgumentException("invalid inputs");
        }

        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.length; i++) {
            int l = i + 1, r = nums.length - 1;


            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (Math.abs(target - sum) < Math.abs(target - res)) {
                    res = sum;
                }
                if (sum > target) {
                    r--;
                } else if (sum < target) {
                    l++;
                } else {
                    return res;
                }
            }
        }
        return res;

    }


}