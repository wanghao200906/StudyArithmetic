package forLeetcode.leetcode_0103_binary_tree_zigzag_level_order_traversal;
/// 103 https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/


/*

题目：二叉树的锯齿形层次遍历

给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。

例如：
给定二叉树 [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回锯齿形层次遍历如下：

[
  [3],
  [20,9],
  [15,7]
]




*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, root, 0);
        return res;

    }

    private void helper(List<List<Integer>> res, TreeNode root, int depth) {
        if (root == null) return;
        if (res.size() == depth) {
            res.add(new LinkedList<>());
        }
        if (depth % 2 == 0) {
            res.get(depth).add(root.val);
        } else {
            res.get(depth).add(0, root.val);
        }
        helper(res, root.left, depth + 1);
        helper(res, root.right, depth + 1);
    }


}