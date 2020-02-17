package forOffer;

import 算法的总结.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 题目：
 * 从上往下打印出二叉树的每个结点，同一层的结点按照从左向右的顺序打印。
 * <p>
 * 思路：
 * 这道题实质是考查树的遍历算法。从上到下打印二叉树的规律：每一次打印一个结点的时候，如果该结点有子结点，
 * 则把该结点的子结点放到一个队列的末尾。接下来到队列的头部取出最早进入队列的结点，
 * 重复前面的打印操作，直至队列中所有的结点都被打印出来为止。
 * <p>
 */
public class Test_22 {
    public static void main(String[] args) {

        BinaryTreeNode node1 = new BinaryTreeNode(8);
        BinaryTreeNode node2 = new BinaryTreeNode(6);
        BinaryTreeNode node3 = new BinaryTreeNode(10);
        BinaryTreeNode node4 = new BinaryTreeNode(5);
        BinaryTreeNode node5 = new BinaryTreeNode(7);
        BinaryTreeNode node6 = new BinaryTreeNode(9);
        BinaryTreeNode node7 = new BinaryTreeNode(11);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;


        ArrayList<Integer> integers = printFromToBottom(node1);
        System.out.println(integers);
    }

    /**
     * 二叉树的树结点
     */
    public static class BinaryTreeNode {
        public BinaryTreeNode() {
        }

        public BinaryTreeNode(int value) {
            this.value = value;
        }

        int value;
        BinaryTreeNode left;
        BinaryTreeNode right;
    }

    /**
     * 从上往下打印出二叉树的每个结点，向一层的结点按照从左往右的顺序打印。
     * 例如下的二叉树，
     * 8
     * /    \
     * 6     10
     * /  \   / \
     * 5   7  9  11
     * 则依次打印出8、6、10、5、7 、9、11.
     *
     * @param root 树的结点
     */
    public static ArrayList<Integer> printFromToBottom(BinaryTreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();

        // 当结点非空时才进行操作
        if (root != null) {
            // 用于存放还未遍历的元素
            Queue<BinaryTreeNode> list = new LinkedList<>();
            // 将根结点入队
            list.add(root);
            // 队列非空则进行处理
            while (!list.isEmpty()) {
                // 删除队首元素
                BinaryTreeNode curNode = list.remove();
                result.add(curNode.value);
                // 输出队首元素的值
                System.out.print(curNode.value + " ");
                // 如果左子结点不为空，则左子结点入队
                if (curNode.left != null) {
                    list.add(curNode.left);
                }
                // 如果右子结点不为空，则左子结点入队
                if (curNode.right != null) {
                    list.add(curNode.right);
                }
            }
        }
        return result;
    }

    class TreeNode {
        TreeNode left;
        TreeNode right;
        TreeNode parent;
        int val;

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode() {
        }
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        levelOrderBottomHelper(root, list, 0);
        return list;
    }

    private void levelOrderBottomHelper(TreeNode root, List<List<Integer>> list, int level) {
        if (root == null) {
            return;
        }
        if (list.size() <= level) {
            list.add(0, new ArrayList<>());
        }
        list.get(list.size() - 1 - level).add(root.val);
        levelOrderBottomHelper(root.left, list, level + 1);
        levelOrderBottomHelper(root.right, list, level + 1);
    }
}


