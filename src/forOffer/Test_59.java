package forOffer;

import java.util.ArrayList;

/**
 * 题目：
 * 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，
 * 即第一行按照从左到右的顺序打印，第二层按照从右到左顺序打印，第三行再按照从左到右的顺序打印，其他以此类推。
 * 思路：
 * 按之字形顺序打印二叉树需要两个栈。我们在打印某一行结点时，把下一层的子结点保存到相应的栈里。
 * 如果当前打印的是奇数层，则先保存左子结点再保存右子结点到一个栈里；
 * 如果当前打印的是偶数层，则先保存右子结点再保存左子结点到第二个栈里。
 */

public class Test_59 {

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(8);
        TreeNode n9 = new TreeNode(9);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        n4.left = n8;
        n4.right = n9;
    }

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();

        help(pRoot, list, 0);

        return list;
    }

    public static void help(TreeNode node, ArrayList<ArrayList<Integer>> list, int level) {
        if (node == null) {
            return;
        }
        if (list.size() == level) {
            list.add(new ArrayList<Integer>());
        }
        if (level % 2 == 0) {
            list.get(level).add(node.val);
        } else {
            list.get(level).add(0, node.val);
        }
        help(node.left, list, level + 1);
        help(node.right, list, level + 1);
    }
}

