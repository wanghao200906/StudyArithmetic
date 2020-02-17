package forLeetcode.leetcode_0107_binary_tree_level_order_traversal_ii;


// https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/*
给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）

例如：
给定二叉树 [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回其自底向上的层次遍历为：

[
  [15,7],
  [9,20],
  [3]
]


 */
class Solution {

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(3);
        TreeNode t2 = new TreeNode(9);
        TreeNode t3 = new TreeNode(20);
        TreeNode t4 = new TreeNode(15);
        TreeNode t5 = new TreeNode(7);

        t1.left = t2;
        t1.right = t3;
        t3.left = t4;
        t3.right = t5;
//        levelOrderBottom(t1);
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ans.add(0,i);
        }

        System.out.println(ans);

    }

    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        DFS(root, 0, ans);
        return ans;
    }

    private static void DFS(TreeNode root, int level, List<List<Integer>> ans) {
        if (root == null) {
            return;
        }
        // 当前层数还没有元素，先 new 一个空的列表
        if (ans.size() <= level) {
            ans.add(0, new ArrayList<>());
        }
        // 当前值加入
        ans.get(ans.size() - 1 - level).add(root.val);

        DFS(root.left, level + 1, ans);
        DFS(root.right, level + 1, ans);
    }


}