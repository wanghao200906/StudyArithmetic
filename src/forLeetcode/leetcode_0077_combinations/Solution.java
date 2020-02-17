package forLeetcode.leetcode_0077_combinations;
/// 77  Source : https://leetcode-cn.com/problems/combinations/


/*

组合



给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。

示例:

输入: n = 4, k = 2
输出:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]

*/

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList<>();


        if (n < 0 || k < 0 || k > n) {
            return list;
        }
        helper(n, k, 0, new ArrayList<>(), list);

        return list;
    }

    private void helper(int n, int k, int index, ArrayList<Integer> temp, List<List<Integer>> list) {

        if (k == temp.size()) {
            list.add(new ArrayList<>(temp));
            return;
        }

        for (int i = index; i < n; i++) {
            temp.add(i);
            helper(n, k, i + 1, temp, list);
            temp.remove(temp.size() - 1);
        }

    }

}