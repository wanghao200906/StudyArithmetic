package 算法的总结;

// 前中后序遍历，递归和迭代
// 层序遍历
// 判断这个数是二叉搜索树
// 判断这个数是平衡二叉树。
// 计算 完全二叉树的所有节点  满二叉树的节点个数 是 2^h-1 h是层级高度
// 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表
// 输入一棵二叉树的根节点和一个整数， 打印出二叉树中，结点值的和，为输入整数，的所有路径。从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
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


import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;


// 前中后序遍历，递归和迭代
// 层序遍历
// 判断这个数是二叉搜索树
// 判断这个数是平衡二叉树。
// 计算 完全二叉树的所有节点  满二叉树的节点个数 是 2^h-1 h是层级高度
// 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表
// 输入一棵二叉树的根节点和一个整数， 打印出二叉树中，结点值的和，为输入整数，的所有路径。从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
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


public class Test {


    class TreeNode {
        int val;
        public TreeNode left;
        public TreeNode right;
    }


    public   class ReflectPoint {
        private int x=2;
        public int y=1;
//        public ReflectPoint(int x, int y) {
//            this.x = x;
//            this.y = y;
//        }

    }


    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
//
//        String str1 = "asd";
//        Class cls1 = str1.getClass();
//        Class cls2 = String.class;
//        Class cls3 = Class.forName("java.lang.String");
//        String str = (String) cls3.newInstance();
//        System.out.println(cls1 == cls2);
//        System.out.println(cls3 == cls2);
//        System.out.println(cls1.isPrimitive());//不是基本类型 false
//        System.out.println(int.class.isPrimitive());//是基本类型 true
//        System.out.println(Integer.class.isPrimitive());//不是基本类型 false
//        System.out.println(Integer.class == int.class);// 肯定不一样 false
//        System.out.println(Integer.TYPE == int.class);// Integer 的type 就是对应的基本类型 true
//        System.out.println(int[].class.isArray());// 是一个数组 true
//        System.out.println(void.class.isPrimitive());// 是基本类型 true

// 总之，只要在源程序中出现的类型，都有各自的class 实例对象。例如 int，void
//        Class cc=Class.forName("算法的总结.Test$ReflectPoint");
//        Field fidley=cc.getDeclaredField("x");
//        int yy= (int) fidley.get(cc);
//        System.out.println(yy);
        ReflectPoint r=new Test().new ReflectPoint();
        System.out.println(r);
    }
}


