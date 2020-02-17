package forLeetcode.leetcode_0144_binary_tree_preorder_traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        helperPre(root, list);

        return list;
    }

    private void helperPre(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        helperPre(root.left, list);
        helperPre(root.right, list);
    }


    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();


        if (root != null) {

            Stack<TreeNode> stack = new Stack<>();
            stack.add(root);
            while (root != null) {
                root = stack.pop();
                list.add(root.val);
                if (root.right != null) {
                    stack.push(root.right);
                }
                if (root.left != null) {
                    stack.push(root.left);
                }
            }
        }


        return list;
    }


    //中序遍历
    public List<Integer> preorderTraversal3(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        if (root != null) {
            Stack<TreeNode> stack = new Stack<>();
            while (!stack.isEmpty() || root != null) {
                if (root != null) {
                    stack.push(root);
                    root = root.left;
                } else {
                    root = stack.pop();
                    list.add(root.val);
                    root = root.right;
                }
            }
        }

        return list;
    }


}
