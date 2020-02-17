package forLeetcode.leetcode_0078_hui_su_suan_fa_by_powcai_5;
/// 78  Source : https://leetcode-cn.com/problems/subsets/

/*

子集


给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。

说明：解集不能包含重复的子集。

示例:

输入: nums = [1,2,3]
输出:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]

*/

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {

        System.out.println(  subsets(new int[]{1, 2, 3}));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        helper(nums, 0, res, new ArrayList<Integer>());
        return res;

    }

    private static void helper(int[] nums, int index, List<List<Integer>> res, ArrayList<Integer> temp) {
        res.add(new ArrayList<>(temp));

        for (int i = index; i < nums.length; i++) {
            temp.add(nums[i]);
            helper(nums, i + 1, res, temp);
            temp.remove(temp.size() - 1);

        }

    }


}