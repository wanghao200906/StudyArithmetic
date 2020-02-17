package forLeetcode.leetcode_0167_two_sum_ii_input_array_is_sorted;

// Leetcode 167
// https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/



/*

两数之和 II - 输入有序数组


给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。

函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。

说明:

返回的下标值（index1 和 index2）不是从零开始的。
你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
示例:

输入: numbers = [2, 7, 11, 15], target = 9
输出: [1,2]
解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。


可以数组两段索引相互碰撞。
 */


public class Solution {

    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15};
        int[] ints = twoSum(arr, 18);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }

    public static int[] twoSum(int[] numbers, int target) {

        return sumHelper(numbers, 0, numbers.length - 1, target);

    }

    private static int[] sumHelper(int[] numbers, int l, int r, int target) {
        while (l < r) {

            if (numbers[l] + numbers[r] == target) {
                return new int[]{l + 1, r + 1};
            } else if (numbers[l] + numbers[r] < target) {
                l++;
            } else {
                r--;
            }

        }
        throw new IllegalArgumentException("no solution");
    }

}