package forLeetcode.leetcode_0404_sum_of_left_leaves;
// 404 https://leetcode-cn.com/problems/sum-of-left-leaves/

/*

左叶子之和

计算给定二叉树的所有左叶子之和。

示例：

    3
   / \
  9  20
    /  \
   15   7

在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24


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
    }

    static class TreeNode {
        public TreeNode(int val) {
            this.val = val;
        }

        int val;
        TreeNode left;
        TreeNode right;
    }

    public int sumOfLeftLeaves(TreeNode root) {

        if (root == null) return 0;
        if (root.left == null) return  sumOfLeftLeaves(root.right); //如果左子树为空，那么只需返回右子树的左叶子和
        if (root.left.left == null && root.left.right == null) // 如果左子树为叶子节点，那么需返回右子树的左叶子和 + 左孩子的值
            return sumOfLeftLeaves(root.right) + root.left.val;
        return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right); // 其他情况需返回左右子树的左叶子和之和


    }


}