package forLeetcode.leetcode_0113_path_sum_ii;

// 113 https://leetcode-cn.com/problems/path-sum-ii/

import java.util.ArrayList;
import java.util.List;

/*

路径总和 II

给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。

说明: 叶子节点是指没有子节点的节点。

示例:
给定如下二叉树，以及目标和 sum = 22，

              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
返回:

[
   [5,4,11,2],
   [5,8,4,5]
]



回溯法
 */
class Solution {


    public static void main(String[] args) {

    }

    static class TreeNode {
        public TreeNode(int val) {
            this.val = val;
        }

        int val;
        TreeNode left;
        TreeNode right;
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        helper(root, sum, res, new ArrayList<Integer>());
        return res;
    }

    private void helper(TreeNode root, int sum, List<List<Integer>> res, ArrayList<Integer> tmp) {
        if (root == null) return;
        tmp.add(root.val);
        if (root.left == null && root.right == null && sum - root.val == 0) res.add(new ArrayList<>(tmp));
        helper(root.left, sum - root.val, res, tmp);
        helper(root.right, sum - root.val, res, tmp);
//        这里就是典型的回溯
        tmp.remove(tmp.size() - 1);
    }

}