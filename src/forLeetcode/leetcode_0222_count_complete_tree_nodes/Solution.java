package forLeetcode.leetcode_0222_count_complete_tree_nodes;
/// 222 https://leetcode-cn.com/problems/count-complete-tree-nodes/


/*

题目：完全二叉树的节点个数

给出一个完全二叉树，求出该树的节点个数。

说明：

完全二叉树的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，
并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2h 个节点。

示例:

输入:
    1
   / \
  2   3
 / \  /
4  5 6

输出: 6



*/

public class Solution {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int countNodes(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left = countLevel(root.left);
        int right = countLevel(root.right);
        if(left == right){
            // 1<<left 比如left是3. 就是根节点的左子树有三层。 那么左子树的节点就是 2^3-1 个 再加上根节点就是2^3也就是1<<left
            return countNodes(root.right) + (1<<left);
        }else{
//            如果左右层级不一样。那就说明。右子树是一个满二叉树。
//            1<<right 就是根节点加上右子树的所有节点
            return countNodes(root.left) + (1<<right);
        }
    }
//    计算出二叉树有多少层。计算左子树。
    private int countLevel(TreeNode root){
        int level = 0;
        while(root != null){
            level++;
            root = root.left;
        }
        return level;
    }


}