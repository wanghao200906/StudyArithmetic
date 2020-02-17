package forLeetcode.leetcode_0169_majority_element;

// Leetcode 169
// https://leetcode-cn.com/problems/majority-element/

/*

求众数

给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。

你可以假设数组是非空的，并且给定的数组总是存在众数。

示例 1:

输入: [3,2,3]
输出: 3

示例 2:

输入: [2,2,1,1,1,2,2]
输出: 2

 */


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    //    方法1.先排序，在去中间的元素，因为已经大于一半了
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    //
    public int majorityElement2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        // maxNum 表示元素，maxCount 表示元素出现的次数
        int maxNum = 0, maxCount = 0;
        for (int num : nums) {
            int count = map.getOrDefault(num, 0) + 1;
            map.put(num, count);
            if (count > maxCount) {
                maxCount = count;
                maxNum = num;
            }
        }
        return maxNum;
    }


}