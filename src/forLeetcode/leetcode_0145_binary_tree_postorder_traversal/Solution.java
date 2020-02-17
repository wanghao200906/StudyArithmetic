package forLeetcode.leetcode_0145_binary_tree_postorder_traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
// 145 https://leetcode-cn.com/problems/binary-tree-postorder-traversal/


/*

二叉树的后序遍历

 */
public class Solution {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        helperPre(root, list);

        return list;
    }

    private void helperPre(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        helperPre(root.left, list);
        helperPre(root.right, list);
        list.add(root.val);
    }


    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();


        if (root != null) {

            Stack<TreeNode> stack = new Stack<>();
            Stack<TreeNode> stack2 = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                root = stack.pop();
                stack2.push(root);
                if (root.left != null) {
                    stack.push(root.left);
                }
                if (root.right != null) {
                    stack.push(root.right);
                }
            }

            while (!stack2.isEmpty()) {
                list.add(stack2.pop().val);
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
