package forOffer;

/**
 * 题目：
 * 输入一棵二叉树的根结点，求该树的深度。从根结点到叶子点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径
 * 的长度为树的深度。
 * <p>
 * 思路：
 * 如果一棵树只有一个结点，它的深度为1。
 * 如果根结点只有左子树而没有右子树， 那么树的深度应该是其左子树的深度加1，同样如果根结点只有右子树而没有左子树，
 * 那么树的深度应该是其右子树的深度加1. 如果既有右子树又有左子树， 那该树的深度就是其左、右子树深度的较大值再加1
 */
public class Test_38 {

    public static void main(String[] args) {


    }

    public static class BinaryTreeNode {
        BinaryTreeNode left;
        BinaryTreeNode right;
    }

    public static int treeDepth(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = treeDepth(root.left);
        int right = treeDepth(root.right);

        return left > right ? (left + 1) : (right + 1);
    }
}

