package forLeetcode.leetcode_0226_invert_binary_tree;
/// 226 https://leetcode-cn.com/problems/invert-binary-tree/


/*

题目：翻转二叉树

翻转一棵二叉树。

示例：

输入：

     4
   /   \
  2     7
 / \   / \
1   3 6   9
输出：

     4
   /   \
  7     2
 / \   / \
9   6 3   1


*/

import java.util.ArrayList;
import java.util.List;

public class Solution {


    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(4);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(7);
        TreeNode t4 = new TreeNode(1);
        TreeNode t5 = new TreeNode(3);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(9);

        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;
        inv(t1);
    }

    static class TreeNode {
        public TreeNode(int val) {
            this.val = val;
        }

        int val;
        TreeNode left;
        TreeNode right;
    }


    public static TreeNode inv(TreeNode node) {
        if (node == null) {
            return null;
        }
        TreeNode left = inv(node.left);
        TreeNode right = inv(node.right);

        node.left = right;
        node.right = left;
        return node;
    }
}