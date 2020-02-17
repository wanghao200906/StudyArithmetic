package 算法的总结;


import java.util.*;

// 前中后序遍历，递归和迭代
// 层序遍历
// 判断这个数是二叉搜索树
// 判断这个数是平衡二叉树。
// 计算 完全二叉树的所有节点  满二叉树的节点个数 是 2^h-1 h是层级高度
// 1,输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表
// 输入一棵二叉树的根节点和一个整数， 打印出二叉树中，结点值的和，为输入整数，的所有路径。从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。  (回溯，注意最后删除节点)
// 请实现一个函数来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
// 输入一棵二叉树的根结点，求该树的深度。从根结点到叶子点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
// 给定两个二叉树，编写一个函数来检验它们是否相同。
// 翻转一棵二叉树。
// 输入两棵二叉树A 和B，判断B 是不是A 的子结构。
// 二叉树的最小深度，给定一个二叉树，找出其最小深度。最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
// 二叉树的右视图，给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
// 二叉树的层次遍历 ,返回list
// 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
// 二叉搜索树的最近公共祖先，给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
//  二叉树的最近公共祖先
//  完全二叉树的节点个数
// 二叉树的所有路径
//    给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
//    计算给定二叉树的所有左叶子之和。
//   输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则返回true。否则返回false。
// 给定一棵二叉搜索树，请找出其中的第k大的结点。
//    二叉搜索树结点最小距离
//请实现两个函数，分别用来序列化和反序列化二叉树
public class Tree {

    static class TreeNode {
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

//    --------------------------------------------------------------

    //    前序遍历
    public void preOrder(TreeNode head) {
        if (head == null) {
            return;
        }
        System.out.println(head.val);
        preOrder(head.left);
        preOrder(head.right);
    }

    public void preOrder2(TreeNode head) {
        if (head == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(head);
        while (!stack.isEmpty()) {
            head = stack.pop();
            System.out.println(head.val);
            if (head.right != null) {
                stack.push(head.right);
            }
            if (head.left != null) {
                stack.push(head.left);
            }
        }
    }

    public void inOrder(TreeNode head) {
        if (head == null) {
            return;
        }
        inOrder(head.left);
        System.out.println(head.val);
        inOrder(head.right);
    }

    public void inOrder2(TreeNode head) {

        Stack<TreeNode> stack = new Stack<>();

        while (!stack.isEmpty() || head != null) {
            if (head != null) {
                stack.push(head);
                head = head.left;
            } else {
                head = stack.pop();
                System.out.println(head.val);
                head = head.right;
            }
        }
    }

    public void postOrder(TreeNode head) {
        if (head == null) {
            return;
        }
        postOrder(head.left);
        postOrder(head.right);
        System.out.println(head.val);
    }

    public void postOrder2(TreeNode head) {

        Stack<TreeNode> stack1 = new Stack<>();

        Stack<TreeNode> stack2 = new Stack<>();

        stack1.push(head);
        while (!stack1.isEmpty()) {
            head = stack1.pop();
            stack2.push(head);
            if (head.left != null) {
                stack1.push(head.left);
            }
            if (head.right != null) {
                stack1.push(head.right);
            }
        }
        while (!stack2.isEmpty()) {
            System.out.println(stack2.pop());
        }

    }

//    --------------------------------------------------------------
//    层序遍历

    public void levelOrder(TreeNode head) {
        if (head == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(head);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.remove();
            System.out.println(cur.val);
            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
        }
    }


//    --------------------------------------------------------------
//    判断这个树是二叉搜索树

    public boolean isBst(TreeNode head) {
        return helper2(head, null, null);
    }

    private boolean helper2(TreeNode head, Integer lower, Integer higher) {

        if (head == null) {
            return true;
        }
        int val = head.val;
        if (lower != null && val <= lower) {
            return false;
        }
        if (higher != null && val >= higher) {
            return false;
        }

        if (!helper2(head.left, lower, val)) {
            return false;
        }
        if (!helper2(head.right, val, higher)) {
            return false;
        }
        return true;
    }
//    --------------------------------------------------------------

//    判断这个数是平衡二叉树。


    boolean res = true;

    public boolean isBalanced(TreeNode root) {
        depth(root);
        return res;
    }

    private int depth(TreeNode root) {
        if (root == null) return 0;
        int left = depth(root.left) + 1;
        int right = depth(root.right) + 1;
        if (Math.abs(left - right) > 1) {
            res = false;
        }

        return Math.max(left, right);
    }


//    --------------------------------------------------------------

//    计算 完全二叉树的所有节点  满二叉树的节点个数 是 2^h-1 h是层级高度

    public int completeTreeCount(TreeNode head) {
        if (head == null) {
            return 0;
        }

        int left = getLevel(head.left);
        int right = getLevel(head.right);
        if (left == right) {
            return completeTreeCount(head.right) + (1 << left);
        } else {
            return completeTreeCount(head.left) + (1 << right);
        }
    }

    //    每次都计算这个节点有几层左孩子
    public int getLevel(TreeNode head) {
        int level = 0;
        while (head != null) {
            head = head.left;
            level++;
        }
        return level;
    }
//    --------------------------------------------------------------

//    输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表


    public TreeNode convert(TreeNode head) {
        if (head == null) {
            return head;
        }
        TreeNode[] treeNodes = new TreeNode[1];
        convertNode(head, treeNodes);

        TreeNode node = treeNodes[0];

        while (node != null && node.left != null) {
            node = node.left;
        }
        return node;
    }


    private void convertNode(TreeNode head, TreeNode[] treeNode) {

        if (head == null) {
            return;
        }

        if (head.left != null) {
            convertNode(head.left, treeNode);
        }
        treeNode[0] = head.left;
        if (treeNode[0] != null) {
            treeNode[0].right = head;
        }
        treeNode[0] = head;

        if (head.right != null) {
            convertNode(head.right, treeNode);
        }
    }

//    --------------------------------------------------------------
//  输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)

    private ArrayList<ArrayList<Integer>> listAll = new ArrayList<ArrayList<Integer>>();
    private ArrayList<Integer> list = new ArrayList<Integer>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        if(root == null) return listAll;
        list.add(root.val);
        target -= root.val;
        if(target == 0 && root.left == null && root.right == null)
            listAll.add(new ArrayList<Integer>(list));
        FindPath(root.left, target);
        FindPath(root.right, target);
        list.remove(list.size()-1);
        return listAll;
    }

//    --------------------------------------------------------------
//    请实现一个函数来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。

    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    private boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null || t2 == null) {
            return false;
        }
        return (t1.val == t2.val) &&
                isMirror(t1.left, t2.right) &&
                isMirror(t1.right, t2.left);
    }


//    --------------------------------------------------------------

//    给定两个二叉树，编写一个函数来检验它们是否相同。

    public boolean isSame(TreeNode p, TreeNode q) {

        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSame(p.left, q.left) && isSame(p.right, q.right);
    }

//    --------------------------------------------------------------
//   翻转一棵二叉树。


    public TreeNode inv(TreeNode node) {
        if (node == null) {
            return node;
        }

        TreeNode left = inv(node.left);
        TreeNode right = inv(node.right);

        node.left = right;
        node.right = left;
        return node;

    }
//    --------------------------------------------------------------
//    输入两棵二叉树A 和B，判断B 是不是A 的子结构。


    public static boolean HasSubtree(TreeNode root1, TreeNode root2) {
        boolean result = false;
        //当Tree1和Tree2都不为零的时候，才进行比较。否则直接返回false
        if (root2 != null && root1 != null) {
            //如果找到了对应Tree2的根节点的点
            if (root1.val == root2.val) {
                //以这个根节点为为起点判断是否包含Tree2
                result = doesTree1HaveTree2(root1, root2);
            }
            //如果找不到，那么就再去root的左儿子当作起点，去判断时候包含Tree2
            if (!result) {
                result = HasSubtree(root1.left, root2);
            }

            //如果还找不到，那么就再去root的右儿子当作起点，去判断时候包含Tree2
            if (!result) {
                result = HasSubtree(root1.right, root2);
            }
        }
        //返回结果
        return result;
    }

    public static boolean doesTree1HaveTree2(TreeNode node1, TreeNode node2) {
        //如果Tree2已经遍历完了都能对应的上，返回true
        if (node2 == null) {
            return true;
        }
        //如果Tree2还没有遍历完，Tree1却遍历完了。返回false
        if (node1 == null) {
            return false;
        }
        //如果其中有一个点没有对应上，返回false
        if (node1.val != node2.val) {
            return false;
        }

        //如果根节点对应的上，那么就分别去子节点里面匹配
        return doesTree1HaveTree2(node1.left, node2.left) && doesTree1HaveTree2(node1.right, node2.right);
    }


    //    --------------------------------------------------------------

//    输入一棵二叉树的根结点，求该树的深度。从根结点到叶子点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。

    public int depthLargest(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = depthLargest(node.left);
        int right = depthLargest(node.right);
        return left > right ? left + 1 : right + 1;
    }

    //    --------------------------------------------------------------
//    给定一个二叉树，找出其最大深度。二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。


    public static int getMax(TreeNode tree) {
        if (tree == null) {
            return 0;
        } else {
            int left = getMax(tree.left);
            int right = getMax(tree.right);
            return Math.max(left, right) + 1;
        }
    }


    //    --------------------------------------------------------------
// 二叉树的最小深度，给定一个二叉树，找出其最小深度。最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
    public static int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }


//    --------------------------------------------------------------
//    二叉树的右视图，给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。

    public List<Integer> sideRight(TreeNode head) {
        List<Integer> list = new ArrayList<>();
        helper(head, list, 1);
        return list;
    }

    private void helper(TreeNode head, List<Integer> list, int level) {

        if (head == null) {
            return;
        }

        if (list.size() < level) {
            list.add(head.val);
        }
//        先遍历右子树。如果右子树没有了。在遍历点起节点的左子树。
        helper(head.right, list, level + 1);
        helper(head.left, list, level + 1);
    }

//    --------------------------------------------------------------
//    给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）

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
//    --------------------------------------------------------------
//二叉树的锯齿形层次遍历 ，也是一层一层的遍历。先从左到右遍历。在从右到左遍历。一次增加。

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        helperZ(root, list, 0);
        return list;

    }

    private void helperZ(TreeNode root, List<List<Integer>> list, int level) {
        if (root == null) {
            return;
        }

        if (list.size() == level) {
            list.add(new ArrayList<>());
        }

        if (level % 2 == 0) {
            list.get(level).add(root.val);
        } else {
            list.get(level).add(0, root.val);
        }
        helperZ(root.left, list, level + 1);
        helperZ(root.right, list, level + 1);
    }

    //    --------------------------------------------------------------
    // 二叉树的层次遍历 ,返回list
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        helperLevelOrder(root, list, 0);
        return list;

    }

    private void helperLevelOrder(TreeNode root, List<List<Integer>> list, int level) {
        if (root == null) {
            return;
        }

        if (level == list.size()) {
            list.add(new ArrayList<>());
        }

        list.get(level).add(root.val);
        helperLevelOrder(root.left, list, level + 1);
        helperLevelOrder(root.right, list, level + 1);
    }

    //    --------------------------------------------------------------
//  输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
//    核心就是找到节点。
    public static TreeNode construct(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length) {
            return null;
        }
        return construct(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private static TreeNode construct(int[] preorder, int ps, int pe, int[] inorder, int is, int ie) {

        if (ps > pe) {
            return null;
        }

        int val = preorder[ps];
        int index = is;

        while (index < ie && inorder[index] != val) {
            index++;
        }
        if (index > ie) {
            throw new RuntimeException("Invalid input");
        }

        TreeNode node = new TreeNode(0);
        node.val = val;
        node.left = construct(preorder, ps + 1, ps + index - is, inorder, is, index - 1);
        node.right = construct(preorder, ps + index - is + 1, pe, inorder, index + 1, ie);
        return node;
    }

// --------------------------------------------------------------
// 二叉搜索树的最近公共祖先，给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int rVal = root.val;
        int pVal = p.val;
        int qVal = q.val;
        if (pVal > rVal && qVal > rVal) {
            return lowestCommonAncestor(root.right, p, q);
        } else if (pVal < rVal && qVal < rVal) {
            return lowestCommonAncestor(root.left, p, q);

        } else {
            return root;
        }
    }

    // --------------------------------------------------------------
//  二叉树的最近公共祖先
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        //分情况讨论
        //root子树中同时包含p和q, 返回root
        //root中只有p, 返回p
        //root中只有q, 返回q
        //root中既然没有p, 也没有q, 返回null
        if (root == null || root.val == p.val || root.val == q.val) return root;

        TreeNode l = lowestCommonAncestor2(root.left, p, q);
        TreeNode r = lowestCommonAncestor2(root.right, p, q);


        if (l == null) return r;//仅在右子树
        if (r == null) return l;//仅在左子树

        return root;//如果p,q刚好在左右两个子树上
    }

// --------------------------------------------------------------
// 二叉树的所有路径  ， 给定一个二叉树，返回所有从根节点到叶子节点的路径。 ["1->2->5", "1->3"]

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        helper(root, list, "");
        return list;

    }

    private void helper(TreeNode root, List<String> list, String path) {
        if (root != null) {
            path += String.valueOf(root.val);
            if ((root.left == null) && (root.right == null)) {
                list.add(path);
            } else {
                path = path + "->";
                helper(root.left, list, path);
                helper(root.right, list, path);
            }
        }
    }

    // --------------------------------------------------------------
//    给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return sum == root.val;
        }

        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);

    }

    // --------------------------------------------------------------
//    计算给定二叉树的所有左叶子之和。
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null) {
            return sumOfLeftLeaves(root.right);
        }
        if (root.left.left == null && root.left.right == null) {
            return sumOfLeftLeaves(root.right) + root.left.val;
        }
        return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }

    // --------------------------------------------------------------
    //   输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则返回true。否则返回false。
    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence.length == 0) {
            return false;
        }
        if (sequence.length == 1) {
            return true;
        }
        return help(sequence, 0, sequence.length - 1);
    }

    public boolean help(int[] arr, int s, int e) {
        if (s >= e) {
            return true;
        }
        int i = e - 1;
        while (i > s && arr[i] > arr[e]) {
            i--;
        }
        for (int j = 0; j < i; j++) {
            if (arr[j] > arr[e]) {
                return false;
            }
        }
        return help(arr, 0, i) && help(arr, i, e - 1);
    }

    // --------------------------------------------------------------
    // 给定一棵二叉搜索树，请找出其中的第k大的结点。

    static int num;

    public static TreeNode kthNode(TreeNode root, int k) {

        if (root == null || k < 1) {
            return null;
        }

        num = k;
        return kthNodeHelper(root);
    }

    private static TreeNode kthNodeHelper(TreeNode root) {

        TreeNode result = null;
        if (root.left != null) {
            result = kthNodeHelper(root.left);
        }

        if (result == null) {
            if (num == 1) {
                result = root;
            } else {
                num--;
            }
        }

        if (result == null && root.right != null) {
            result = kthNodeHelper(root.right);
        }
        return result;
    }

    // --------------------------------------------------------------
//    二叉搜索树 两个节点差最小是多少。
    List<Integer> list2 = new ArrayList<>();

    public int min(TreeNode tree) {

        inOrder3(tree);
        int diff = Integer.MAX_VALUE;
        for (int i = 0; i < list.size(); i++) {
            if (list2.get(i + 1) - list2.get(i) < diff) {
                diff = list2.get(i + 1) - list2.get(i);
            }
        }
        return diff;
    }

    private void inOrder3(TreeNode tree) {
        if (tree == null) {
            return;
        }
        inOrder3(tree.left);
        list2.add(tree.val);
        inOrder3(tree.right);
    }
// 请实现两个函数，分别用来序列化和反序列化二叉树

    public String serial(TreeNode head) {
        if (head == null) {
            return "#!";
        }
        String val = head.val + "!";
        val = val + serial(head.left);
        val = val + serial(head.right);
        return val;
    }

    public TreeNode recon(String str) {
        String[] valus = str.split("!");
        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i < valus.length; i++) {
            queue.offer(valus[i]);
        }
        return reconHelp(queue);
    }

    private TreeNode reconHelp(Queue<String> queue) {
        String val = queue.poll();
        if (val.equals("#")) {
            return null;
        }
        TreeNode head = new TreeNode(Integer.valueOf(val));
        head.left = reconHelp(queue);
        head.right = reconHelp(queue);
        return head;
    }
//    给定一棵二叉树和其中的一个结点，如何找出中序遍历顺序的下一个结点？

    public static TreeNode getNext(TreeNode node) {
        if (node == null) {
            return null;
        }

        // 保存要查找的下一个节点
        TreeNode target = null;

        if (node.right != null) {
            target = node.right;
            while (target.left != null) {
                target = target.left;
            }

            return target;
        } else if (node.parent != null) {
            target = node.parent;
            TreeNode cur = node;
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
