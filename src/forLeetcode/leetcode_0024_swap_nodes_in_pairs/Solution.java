package forLeetcode.leetcode_0024_swap_nodes_in_pairs;

/// Source : https://leetcode-cn.com/problems/swap-nodes-in-pairs/


/*


两两交换链表中的节点


给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。

你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。

 

示例:

给定 1->2->3->4, 你应该返回 2->1->4->3.
在真实的面试中遇到过这道题？


*/

import 算法的总结.Link;

public class Solution {

    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(4);
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        swapPairs(a1);
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode swapPairs(ListNode head) {


        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        while (pre.next != null && pre.next.next != null) {
            ListNode start = pre.next;
            ListNode end = pre.next.next;

            start.next = end.next;
            end.next = start;
            pre.next = end;//这一步是改变head的指向。
            pre = start;
        }


        return dummy.next;
    }
}