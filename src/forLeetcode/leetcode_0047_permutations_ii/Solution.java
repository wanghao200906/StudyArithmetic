package forLeetcode.leetcode_0047_permutations_ii;
/// 47  Source : https://leetcode-cn.com/problems/permutations-ii/


/*

全排列 II

给定一个可包含重复数字的序列，返回所有不重复的全排列。

示例:

输入: [1,1,2]
输出:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]


*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        permuteUnique(new int[]{1, 2, 3});
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        int[] visited = new int[nums.length];

        if (nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);

        backtrack(res, nums, new ArrayList<>(), visited);
        return res;

    }

    private static void backtrack(List<List<Integer>> res, int[] nums, ArrayList<Integer> tmp, int[] visited) {
        if (tmp.size() == nums.length) {
            res.add(new ArrayList<>(tmp));
            return;
        }
//        这里进行for循环操作。注意到。每次回调都会进行for循环。进行nums.length次操作
//        通过visited来判断这 nums.length次操作中。的数是否已经存过了。
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == 1) continue;

            //因为排序以后重复的数一定不会出现在开始，故 i > 0
            // 和之前的数相等，并且之前的数还未使用过，只有出现这种情况，才会出现相同分支
            // 这种情况跳过即可

            if (i > 0 && nums[i] == nums[i - 1] && visited[i - 1] != 1) {
                continue;
            }
            visited[i] = 1;
            tmp.add(nums[i]);
            backtrack(res, nums, tmp, visited);
            visited[i] = 0;
            tmp.remove(tmp.size() - 1);
        }
    }

}