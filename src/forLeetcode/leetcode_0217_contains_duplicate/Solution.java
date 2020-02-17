package forLeetcode.leetcode_0217_contains_duplicate;

// Leetcode 217.
// https://leetcode-cn.com/problems/contains-duplicate/

/*
存在重复元素


给定一个整数数组，判断是否存在重复元素。

如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。

示例 1:

输入: [1,2,3,1]
输出: true
示例 2:

输入: [1,2,3,4]
输出: false
示例 3:

输入: [1,1,1,3,3,4,3,2,4,2]
输出: true

 */


import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        int[] arr = {1,2,3,1};
//        System.out.println(containsDuplicate(arr));



    }

    public static boolean containsDuplicate(int[] nums) {

        if (nums == null || nums.length < 1) {
            return false;
        }
        Set<Integer> hash = new HashSet<>(nums.length);
        for (int num : nums) {
            if (hash.contains(num)) {
                return true;
            } else {
                hash.add(num);
            }
        }
        return false;

    }


}