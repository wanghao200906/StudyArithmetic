package forLeetcode.leetcode_0783_minimum_distance_between_bst_nodes;
/// 783 https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/

/*

题目：二叉搜索树结点最小距离

给定一个二叉搜索树的根结点 root, 返回树中任意两节点的差的最小值。

示例：

输入: root = [4,2,6,1,3,null,null]
输出: 1
解释:
注意，root是树结点对象(TreeNode object)，而不是数组。

给定的树 [4,2,6,1,3,null,null] 可表示为下图:

          4
        /   \
      2      6
     / \
    1   3

最小的差值是 1, 它是节点1和节点2的差值, 也是节点3和节点2的差值。
注意：

二叉树的大小范围在 2 到 100。
二叉树总是有效的，每个节点的值都是整数，且不重复。


二叉搜索树。用中序遍历。获取的 list是从小到大的顺序。

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

    List<Integer> list = new ArrayList<>();

    public int min(TreeNode tree) {

        inOrder(tree);
        int diff = Integer.MAX_VALUE;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i + 1) - list.get(i) < diff) {
                diff = list.get(i + 1) - list.get(i);
            }
        }
        return diff;
    }

    private void inOrder(TreeNode tree) {
        if (tree == null) {
            return;
        }
        inOrder(tree.left);
        list.add(tree.val);
        inOrder(tree.right);
    }

}