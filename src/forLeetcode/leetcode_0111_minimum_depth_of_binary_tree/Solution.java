package forLeetcode.leetcode_0111_minimum_depth_of_binary_tree;

// 111 https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/

/*

二叉树的最小深度

给定一个二叉树，找出其最小深度。

最小深度是从根节点到最近叶子节点的最短路径上的节点数量。

说明: 叶子节点是指没有子节点的节点。

示例:

给定二叉树 [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回它的最小深度  2.

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
        System.out.println(getMax(t1));
        System.out.println(minDepth(t1));
    }

    static class TreeNode {
        public TreeNode(int val) {
            this.val = val;
        }

        int val;
        TreeNode left;
        TreeNode right;
    }


    public static int getMax(TreeNode tree) {
        if (tree == null) {
            return 0;
        } else {
            int left = getMax(tree.left);
            int right = getMax(tree.right);
            return Math.max(left, right) + 1;
        }
    }

    public static int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }


}