package forLeetcode.leetcode_0002_add_two_numbers;
// Leetcode 2
//https://leetcode-cn.com/problems/add-two-numbers/



/*

两数相加

给出两个非空的链表用来表示两个非负的整数。
其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。

如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

示例：

输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 0 -> 8
原因：342 + 465 = 807 (感觉这里没有卵用呢)


 */


public class Solution {

    public static void main(String[] args) {

        ListNode a1 = new ListNode(5);
        ListNode a2 = new ListNode(4);
        ListNode a3 = new ListNode(3);

        ListNode a4 = new ListNode(5);
        ListNode a5 = new ListNode(6);
        ListNode a6 = new ListNode(4);
        a1.next = a2;
        a2.next = a3;

        a4.next = a5;
        a5.next = a6;

        ListNode listNode = addTwoNumbers(a1, a4);
        System.out.println(7/10);

    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;//是进位
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;//获取进位
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
}