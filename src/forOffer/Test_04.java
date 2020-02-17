package forOffer;

/**
 * 题目：
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如：前序遍历序列｛ 1, 2, 4, 7, 3, 5, 6, 8｝和中序遍历序列｛4, 7, 2, 1, 5, 3, 8，6}，重建二叉树并输出它的头结点。
 * <p>
 * 思路：
 * 先序遍历的第一个元素为根节点，在中序遍历中找到这个根节点，从而可以将中序遍历分为左右两个部分，
 * 左边部分为左子树的中序遍历，右边部分为右子树的中序遍历，进而也可以将先序遍历除第一个元素以外的剩余部分分为两个部分，
 * 第一个部分为左子树的先序遍历，第二个部分为右子树的先序遍历。
 * 由上述分析结果，可以递归调用构建函数，根据左子树、右子树的先序、中序遍历重建左、右子树。
 * <p>
 * 难点：
 * 难点就是边界问题
 * 为什么 pre的结束位置 是 ps + index - is ： 可以理解为 ps+（index-is）, index-is 的原因是is左边可能还有其他数据。
 * 所以 index-is 可以理解为是一个偏移量 。
 */
public class Test_04 {
    public static void main(String[] args) {
        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] in = {4, 7, 2, 1, 5, 3, 8, 6};
        TreeNode construct = construct(pre, in);
        printlnPre(construct);
    }


    public static void printlnPre(TreeNode head) {
        if (head == null) {
            return;
        }
        System.out.println(head.val);
        printlnPre(head.left);
        printlnPre(head.right);
    }

    /**
     * 二叉树节点类
     */
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    /**
     * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二节树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
     *
     * @param preorder 前序遍历
     * @param inorder  中序遍历
     * @return 树的根结点
     */
    public static TreeNode construct(int[] preorder, int[] inorder) {
        // 输入的合法性判断，两个数组都不能为空，并且都有数据，而且数据的数目相同
        if (preorder == null || inorder == null || preorder.length != inorder.length || inorder.length < 1) {
            return null;
        }

        return construct(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    /**
     * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二节树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
     *
     * @param preorder 前序遍历
     * @param ps       前序遍历的开始位置
     * @param pe       前序遍历的结束位置
     * @param inorder  中序遍历
     * @param is       中序遍历的开始位置
     * @param ie       中序遍历的结束位置
     * @return 树的根结点
     */
    public static TreeNode construct(int[] preorder, int ps, int pe, int[] inorder, int is, int ie) {

        // 开始位置大于结束位置说明已经没有需要处理的元素了
        if (ps > pe) {
            return null;
        }
        // 取前序遍历的第一个数字，就是当前的根结点
        int value = preorder[ps];
        int index = is;
        // 在中序遍历的数组中找根结点的位置
        while (index <= ie && inorder[index] != value) {
            index++;
        }

        // 如果在整个中序遍历的数组中没有找到，说明输入的参数是不合法的，抛出异常
        if (index > ie) {
            throw new RuntimeException("Invalid input");
        }

        // 创建当前的根结点，并且为结点赋值
        TreeNode node = new TreeNode();
        node.val = value;

        // 递归构建当前根结点的左子树，左子树的元素个数：index-is个
        // 左子树对应的前序遍历的位置在[ps+1, ps+index-is]
        // 左子树对应的中序遍历的位置在[is, index-1]
        node.left = construct(preorder, ps + 1, ps + index - is, inorder, is, index - 1);
        // 递归构建当前根结点的右子树，右子树的元素个数：ie-index个
        // 右子树对应的前序遍历的位置在[ps+index-is+1, pe]
        // 右子树对应的中序遍历的位置在[index+1, ie]
        node.right = construct(preorder, ps + index - is + 1, pe, inorder, index + 1, ie);

        // 返回创建的根结点
        return node;
    }

}
