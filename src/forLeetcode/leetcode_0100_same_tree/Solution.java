package forLeetcode.leetcode_0100_same_tree;

// 100 https://leetcode-cn.com/problems/same-tree/

/*
相同的树


给定两个二叉树，编写一个函数来检验它们是否相同。

如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。

示例 1:

输入:       1         1
          / \       / \
         2   3     2   3

        [1,2,3],   [1,2,3]

输出: true
示例 2:

输入:      1          1
          /           \
         2             2

        [1,2],     [1,null,2]

输出: false
示例 3:

输入:       1         1
          / \       / \
         2   1     1   2

        [1,2,1],   [1,1,2]

输出: false


 */
class Solution {


    public static final String mess = "taobao";

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

    public boolean isSame(TreeNode p, TreeNode q) {

        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }

        if (p.val != q.val) {
            return false;
        }
        return isSame(p.left, q.left) && isSame(p.right, q.right);
    }

}