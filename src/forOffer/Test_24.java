package forOffer;

import java.util.ArrayList;

/**
 * 题目：
 * 输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * (注意: 在返回值的list中，数组长度大的数组靠前)
 *
 *
 * <p>
 * 思路：
 * 就是从根节点一直到叶子节点，所经过的节点 加起来 的值 如果和 输入的整数一样。那么就打印出来这个节点。
 * <p>
 * 由于路径是从根结点出发到叶结点， 也就是说路径总是以根结点为起始点，
 * 因此我们首先需要遍历根结点。在树的前序、中序、后序三种遍历方式中，只有前序遍历是首先访问根结点的。
 * <p>
 * 当用前序遍历的方式访问到某一结点时， 我们把该结点添加到路径上，并累加该结点的值。如果该结点为叶结点并且路径中结点值的和刚好等
 * 于输入的整数， 则当前的路径符合要求，我们把它打印出来。如果当前结点不是叶结点，则继续访问它的子结点。当前结点访问结束后，递归
 * 函数将自动回到它的父结点。因此我们在函数退出之前要在路径上删除当前结点并减去当前结点的值，以确保返回父结点时路径刚好是从根结
 * 点到父结点的路径。
 * <p>
 * 不难看出保存路径的数据结构实际上是一个枝， 因为路径要与递归调用状态一致， 而递归调用的本质就是一个压栈和出栈的过程。
 *
 *
 * <p>
 */
public class Test_24 {
    public static void main(String[] args) {

    }

    /**
     * 二叉树的树结点
     */
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    private ArrayList<ArrayList<Integer>> listAll = new ArrayList<ArrayList<Integer>>();
    private ArrayList<Integer> list = new ArrayList<Integer>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null) return listAll;
        list.add(root.val);
        target -= root.val;
        if (target == 0 && root.left == null && root.right == null)
            listAll.add(new ArrayList<Integer>(list));
        FindPath(root.left, target);
        FindPath(root.right, target);
        list.remove(list.size() - 1);
        return listAll;
    }
}


