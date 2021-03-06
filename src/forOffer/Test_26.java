package forOffer;

/**
 * 题目：
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 * <p>
 * 思路：
 * <p>
 * 在二叉树中，每个结点都有两个指向子结点的指针。在双向链表中，每个结点也有两个指针，它们分别指向前一个结点和后一个结点。由
 * 于这两种结点的结构相似，同时二叉搜索树也是一种排序的数据结构，因此在理论上有可能实现二叉搜索树和排序的双向链表的转换。
 * <p>
 * 在搜索二叉树中，左子结点的值总是小于父结点的值，右子结点的值总是大于父结点的值。
 * 因此我们在转换成排序双向链表时，原先指向左子结点的指针调整
 * 为链表中指向前一个结点的指针，原先指向右子结点的指针调整为链表中指向后一个结点指针。接下来我们考虑该如何转换。
 * <p>
 * 由于要求转换之后的链表是排好序的，我们可以中序遍历树中的每一个结点，
 * 这是因为中序遍历算法的特点是按照从小到大的顺序遍历二叉树的每一个结点。
 * 当遍历到根结点的时候，我们把树看成三部分：根结点，左子树，右子树。
 * 根据排序链表的定义，根结点将和它的左子树的最大一个结点链接起来，同时它
 * 还将和右子树最小的结点链接起来。
 * <p>
 * <p>
 * 比如将二元查找树
 *                                              10
 *                                           /      \
 *                                         6        14
 *                                       /   \      /   \
 *                                     4     8      12  16
 * 转换成双向链表
 * 4=6=8=10=12=14=16。
 */
public class Test_26 {
    public static void main(String[] args) {

    }


    /**
     * 二叉树的树结点
     */
    public static class BinaryTreeNode {
        int value;
        BinaryTreeNode left;
        BinaryTreeNode right;
    }

    /**
     * 题目：输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
     * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
     *
     * @param root 二叉树的根结点
     * @return 双向链表的头结点
     */
    public static BinaryTreeNode convert(BinaryTreeNode root) {

        // 用于保存处理过程中的双向链表的尾结点
        BinaryTreeNode[] lastNode = new BinaryTreeNode[1];
        convertNode(root, lastNode);

//        此时head是链表的尾巴节点。
        BinaryTreeNode head = lastNode[0];
        // 找到双向链表的头结点
        while (head != null && head.left != null) {
            head = head.left;
        }
        return head;
    }


    /**
     * 链表表转换操作
     *
     * @param node     当前的根结点
     * @param lastNode 已经处理好的双向链表的尾结点，使用一个长度为1的数组，类似C++中的二级指针
     */
    public static void convertNode(BinaryTreeNode node, BinaryTreeNode[] lastNode) {
        // 结点不为空
        if (node != null) {

            // 如果有左子树就先处理左子树
            if (node.left != null) {
                convertNode(node.left, lastNode);
            }

            // 将当前结点的前驱指向已经处理好的双向链表（由当前结点的左子树构成）的尾结点
            node.left = lastNode[0];

            // 如果左子树转换成的双向链表不为空，设置尾结点的后继
//            这样就形成了双向列表
            if (lastNode[0] != null) {
                lastNode[0].right = node;
            }

            // 记录当前结点为尾结点
//            更新node设置为 新的尾节点，向后移动了一下
            lastNode[0] = node;

            // 处理右子树
            if (node.right != null) {
                convertNode(node.right, lastNode);
            }
        }
    }
}


