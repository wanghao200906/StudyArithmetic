package forOffer;

/**
 * 题目：
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 * <p>
 * 思路：
 * 先前序遍历这棵树的每个结点，如果遍历到的结点有子结点，就交换它的两个子结点。
 * 当交换完所有非叶子结点的左右子结点之后，就得到了树的镜像。
 * <p>
 */
public class Test_18 {
    public static void main(String[] args) {


    }
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    public void Mirror(TreeNode root) {

        help(root);
    }

    public TreeNode help(TreeNode root){
        if(root==null){
            return  root;
        }
        TreeNode left=help(root.left);
        TreeNode right=help(root.right);
        root.left=right;
        root.right=left;
        return root;
    }

}


