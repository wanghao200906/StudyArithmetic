package forOffer;

/**
 * 题目：
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。例如， （5，3，7，2，4，6，8）    中，按结点数值大小顺序第三小结点的值为4。
 * 思路：
 * 如果按照中序遍历的顺序遍历一棵二叉搜索树，遍历序列的数值是递增排序的。
 * 只需要用中序遍历算法遍历一棵二叉搜索树，就很容易找出它的第k大结点。
 */

public class Test_62 {

    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(5);
        BinaryTreeNode node2 = new BinaryTreeNode(3);
        BinaryTreeNode node3 = new BinaryTreeNode(7);
        BinaryTreeNode node4 = new BinaryTreeNode(2);
        BinaryTreeNode node5 = new BinaryTreeNode(4);
        BinaryTreeNode node6 = new BinaryTreeNode(6);
        BinaryTreeNode node7 = new BinaryTreeNode(8);
        root.left = node2;
        root.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node7;
        node3.right = node6;


        System.out.println(kthNode(root, 1));
    }

    private static class BinaryTreeNode {
        private int val;
        private BinaryTreeNode left;
        private BinaryTreeNode right;

        public BinaryTreeNode() {
        }

        public BinaryTreeNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return val + "";
        }
    }

    static int num = 0;

    public static BinaryTreeNode kthNode(BinaryTreeNode root, int k) {
        if (root == null || k < 1) {
            return null;
        }

        num = k;
        return kthNodeCore(root);
    }

    private static BinaryTreeNode kthNodeCore(BinaryTreeNode root) {
        BinaryTreeNode result = null;

        // 先成左子树中找
        if (root.left != null) {
            result = kthNodeCore(root.left);
        }

        // 如果在左子树中没有找到
        if (result == null) {
            // 说明当前的根结点是所要找的结点
            if (num == 1) {
                result = root;
            } else {
                // 当前的根结点不是要找的结点，但是已经找过了，所以计数器减一
                num--;
            }
        }

        // 根结点以及根结点的左子树都没有找到，则找其右子树
        if (result == null && root.right != null) {
            result = kthNodeCore(root.right);
        }

        return result;
    }
}

