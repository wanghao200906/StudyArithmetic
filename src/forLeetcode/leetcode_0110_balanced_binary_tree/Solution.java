package forLeetcode.leetcode_0110_balanced_binary_tree;
/// 110 https://leetcode-cn.com/problems/balanced-binary-tree/


/*

题目：平衡二叉树

给定一个二叉树，判断它是否是高度平衡的二叉树。

本题中，一棵高度平衡二叉树定义为：

一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。

示例 1:

给定二叉树 [3,9,20,null,null,15,7]

    3
   / \
  9  20
    /  \
   15   7
返回 true 。

示例 2:

给定二叉树 [1,2,2,3,3,null,null,4,4]

       1
      / \
     2   2
    / \
   3   3
  / \
 4   4
返回 false 。

*/

import java.util.ArrayList;
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

    boolean res = true;

    public boolean isBalanced(TreeNode root) {
        depth(root);
        return res;
    }

    private int depth(TreeNode root) {
        if (root == null) return 0;
        int left = depth(root.left) + 1;
        int right = depth(root.right) + 1;
        if (Math.abs(left - right) > 1) {
            res = false;
        }

        return Math.max(left, right);
    }


}