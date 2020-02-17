package forOffer;

/**
 * 题目：
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则返回true。否则返回false。假设输入的数组的任意
 * 两个数字都互不相同。
 * <p>
 * 思路：
 * 二叉搜索树的概念就是:根节点的值大于左孩子，小于右孩子
 * 在后序遍历得到的序列中， 最后一个数字是树的根结点的值,最后一个
 * 数组中前面的数字可以分为两部分：
 * 第一部分是左子树结点的值，它们都比根结点的值小：
 * 第二部分是右子树结点的值，它们都比根结点的值大。
 *
 *
 * <p>
 */
public class Test_23 {
    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};

        VerifySquenceOfBST(arr);
    }

    public static boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence.length == 0) {
            return false;
        }
        if (sequence.length == 1) {
            return true;
        }
        return judge(sequence, 0, sequence.length - 1);
    }

    private static boolean judge(int[] sequence, int start, int end) {
        //递归的停止条件
        if (start >= end) {
            return true;
        }
        //从后往前找到第一个比end小的数
        int i = end - 1;
        while (i > start && sequence[i] > sequence[end]) {
            i--;
        }
        //0-i都应该是左子树，所以值必须都比root小，有一个大则false
        for (int j = 0; j < i; j++) {
            if (sequence[j] > sequence[end]) {
                return false;
            }
        }

        //对左右子树再做递归判断
        return judge(sequence, 0, i) && judge(sequence, i, end - 1);
    }
}


