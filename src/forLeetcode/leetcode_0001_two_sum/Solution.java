package forLeetcode.leetcode_0001_two_sum;

/// 1
/// https://leetcode-cn.com/problems/two-sum/



/*

两数之和


给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。

你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。

示例:

给定 nums = [2, 7, 11, 15], target = 9

因为 nums[0] + nums[1] = 2 + 7 = 9
所以返回 [0, 1]



用的就是查找表。做减法，得到的值然后去 表中找，看看是否能找得到
*/

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {

        int[] arr={2, 7, 11, 15};
        int[] ints = twoSum(arr, 9);
        for (int i = 0; i < ints.length; i++) {

            System.out.println(arr[i]);
        }
    }

    public static int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complete = target - nums[i];
            if (map.containsKey(complete)) {
                return new int[]{map.get(complete), i};
            } else {
                map.put(nums[i], i);
            }
        }

        throw new IllegalArgumentException("No two sum solution");
    }
}