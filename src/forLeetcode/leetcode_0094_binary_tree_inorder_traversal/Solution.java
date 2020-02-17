package forLeetcode.leetcode_0094_binary_tree_inorder_traversal;
/// Source : https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
/// Time Complexity: O(n)
/// Space Complexity: O(n)


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
    给定一个二叉树，返回它的中序遍历。
    
    输入: [1,null,2,3]
           1
            \
             2
            /
           3
       
        输出: [1,3,2]
*/

public class Solution {


    public static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node(int data) {
            this.val = data;
        }
    }


    public List<Integer> inorderTraversal(Node root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;

    }

    public void helper(Node root, List<Integer> res) {
        if (root != null) {
            if (root.left != null) {
                helper(root.left, res);
            }
            res.add(root.val);
            if (root.right != null) {
                helper(root.right, res);
            }
        }
    }

    public List<Integer> inorderTraversal2(Node root) {
        List<Integer> res = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        Node curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
        }
        return res;
    }


    public static void main(String[] args) {
        Node head = new Node(5);
        head.left = new Node(3);
        head.right = new Node(8);
        head.left.left = new Node(2);
        head.left.right = new Node(4);
        head.left.left.left = new Node(1);
        head.right.left = new Node(7);
        head.right.left.left = new Node(6);
        head.right.right = new Node(10);
        head.right.right.left = new Node(9);
        head.right.right.right = new Node(11);

    }

}