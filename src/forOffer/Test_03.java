package forOffer;

import java.util.Stack;

/**
 * 题目：
 * 输入个链表的头结点，从尾到头反过来打印出每个结点的值。
 * <p>
 * 思路：
 * 使用栈的方式进行。
 * <p>
 * 将链表从头到尾压入栈内，出栈的过程就对应着从尾到头。
 */
public class Test_03 {

    static class Node {
        public Node(int i) {
            this.val = i;
        }

        Node next;
        int val;
    }

    public static void main(String[] args) {


        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        node1.next = node2;
        node2.next = node3;

//        showRevNode(node1);
        showRevNodeByRecursion(node1);
    }


    public static void showRevNode(Node root) {
        Stack<Node> stack = new Stack<>();
        while (root != null) {
            stack.add(root);
            root = root.next;
        }
        while (!stack.isEmpty()) {
            Node pop = stack.pop();
            System.out.println(pop.val);
        }
    }


    public static void showRevNodeByRecursion(Node root) {
        if (root != null) {
            showRevNodeByRecursion(root.next);
            System.out.println(root.val);
        }
    }

}
