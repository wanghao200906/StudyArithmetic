package forOffer;

/**
 * 题目：
 * 给定一棵二叉树和其中的一个结点，如何找出中序遍历顺序的下一个结点？
 * 树中的结点除了有两个分别指向左右子结点的指针以外，还有一个指向父节点的指针。
 * 思路：
 * <p>
 * 如果一个结点有右子树，那么它的下一个结点就是它的右子树中的左子结点。
 * 也就是说右子结点出发一直沿着指向左子结点的指针，我们就能找到它的下一个结点。
 * <p>
 * 接着我们分析一个结点没有右子树的情形。
 * 如果结点是它父节点的左子结点，那么它的下一个结点就是它的父结点。
 * <p>
 * 如果一个结点既没有右子树，并且它还是它父结点的右子结点，这种情形就比较复杂。
 * 我们可以沿着指向父节点的指针一直向上遍历，直到找到一个节点的父节点的左子节点为该节点，
 * 如果这样的结点存在，那么这个结点的父结点就是我们要找的下一个结点。
 */

public class Test_57 {

    public static void main(String[] args) {

    }


    private static class BinaryTreeNode {
        private int val;
        private BinaryTreeNode left;
        private BinaryTreeNode right;
        private BinaryTreeNode parent;

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

    public static BinaryTreeNode getNext(BinaryTreeNode node) {
        if (node == null) {
            return null;
        }

        // 保存要查找的下一个节点
        BinaryTreeNode target = null;

        if (node.right != null) {
            target = node.right;
            while (target.left != null) {
                target = target.left;
            }

            return target;
        } else if (node.parent != null) {
            target = node.parent;
            BinaryTreeNode cur = node;
            // 如果父新结点不为空，并且，子结点不是父结点的左孩子
            while (target != null && target.left != cur) {
                cur = target;
                target = target.parent;

            }

            return target;
        }

        return null;
    }
}

