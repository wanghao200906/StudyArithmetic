package forLeetcode.leetcode_0445_add_two_numbers_ii;

/// 445
/// https://leetcode-cn.com/problems/add-two-numbers-ii/



/*

两数相加 II

给定两个非空链表来代表两个非负整数。数字最高位位于链表开始位置。
它们的每个节点只存储单个数字。将这两数相加会返回一个新的链表。

 
你可以假设除了数字 0 之外，这两个数字都不会以零开头。

进阶:

如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。

示例:

输入: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
输出: 7 -> 8 -> 0 -> 7

意思就是   7243+ 564=7807

*/

import java.util.HashMap;
import java.util.Map;

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
        System.out.println();

    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode rev1 = reverse(l1);
        ListNode rev2 = reverse(l2);

        ListNode res = null;
        ListNode pre = null;
        int carry = 0;
        while (rev1 != null || rev2 != null) {
            int n1 = rev1 != null ? rev1.val : 0;
            int n2 = rev2 != null ? rev2.val : 0;

            int temp = n1 + n2 + carry;
            carry = temp / 10;
            pre = res;

            res = new ListNode(temp % 10);

            res.next = pre;

            rev1 = rev1 != null ? rev1.next : null;
            rev2 = rev2 != null ? rev2.next : null;

        }


        if (carry > 0) {
            pre = res;
            res = new ListNode(carry);
            res.next = pre;
        }
        return res;
    }

    public static ListNode reverse(ListNode ln) {

        ListNode pre = null;
        ListNode cur = ln;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;

    }

}