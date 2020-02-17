package forLeetcode.leetcode_0199_binary_tree_right_side_view;


// https://leetcode-cn.com/problems/binary-tree-right-side-view/

import java.util.ArrayList;
import java.util.List;

/*

二叉树的右视图

给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。

示例:

输入: [1,2,3,null,5,null,4]
输出: [1, 3, 4]
解释:

   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---


 */
class Solution {

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(5);
        TreeNode t5 = new TreeNode(4);

        t1.left = t2;
        t1.right = t3;
        t2.right = t4;
        t3.right = t5;
        rightSideView(t1);

    }

    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        public TreeNode(int val) {
            this.val = val;
        }
    }


    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(root, list, 1);
        return list;

    }

    public static void dfs(TreeNode root, List<Integer> list, int level) {

        if (root == null) {
            return;
        }
        if (list.size() < level) {//必须加这个判断，因为每一层只选择最右边的一个值。
            list.add(root.val);
        }
        dfs(root.right, list, level + 1);
        dfs(root.left, list, level + 1);

    }

}