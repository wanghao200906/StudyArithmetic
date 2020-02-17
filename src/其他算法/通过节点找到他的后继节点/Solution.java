package 其他算法.通过节点找到他的后继节点;

/// 1
/// https://leetcode-cn.com/problems/two-sum/



/*

在二叉树中找到一个节点的后继节点
【题目】 现在有一种新的二叉树节点类型如下:

public class Node {
public int value;
 public Node left;
 public Node right;
 public Node parent;

public Node(int data) {
        this.value = data;
        }
}

 该结构比普通二叉树节点结构多了一个指向父节点的parent指针。
 假设有一 棵Node类型的节点组成的二叉树，树中每个节点的parent指针 都正确地指向 自己的父节点，
 头节点的parent指向null。

 只给一个在二叉树中的某个节点 node，请实现返回node的后继节点的函数。
 在二叉树的中序遍历的序列中，node的下一个节点叫作node的后继节点。

 思路：使用中序排列。
        如果一个节点有右子树，那么这个节点的后继节点 就是 他右子树的最左节点
        如果一个节点没有右子树，那么就找这个节点的父节点。当父节点是 右子树那么继续想上遍历。当父节点是左子树，则后继节点就是这个父节点（这个父节点是一个左子树）的父节点
*/

public class Solution {


    public static class Node {
        public int value;
        public Node left;
        public Node right;
        public Node parent;

        public Node(int data) {
            this.value = data;
        }
    }

    public static Node getSuccessorNode(Node node) {
        if (node == null) {
            return node;
        }
        if (node.right != null) {
            return getLeftMost(node.right);
        } else {
            Node parent = node.parent;
            while (parent != null && parent.left != node) {
                node = parent;
                parent = node.parent;
            }
            return parent;
        }
    }

    public static Node getLeftMost(Node node) {
        if (node == null) {
            return node;
        }
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

}