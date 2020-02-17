package forLeetcode.leetcode_0092_reverse_linked_list_ii;
/// https://leetcode-cn.com/problems/reverse-linked-list-ii/


/*

题目：反转链表 II

反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。

说明:
1 ≤ m ≤ n ≤ 链表长度。

示例:

输入: 1->2->3->4->5->NULL, m = 2, n = 4
输出: 1->4->3->2->5->NULL


*/

public class Solution {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        reverseBetween(l1, 2, 4);
    }

    //    找到m的前一个节点，将m到n的节点翻转，然后和之前的节点在连起来。
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        // 找到翻转链表部分的前一个节点, 1->2->3->4->5->NULL, m = 2, n = 4
//        m为2 ，代表第二个节点。所以pre就是第一个节点
        for (int i = 0; i < m - 1; i++) {
            pre = pre.next;
        }


        // 用双指针,进行链表翻转
        ListNode node = null;
//        此时cur是第二个节点。
        ListNode cur = pre.next;
        for (int i = 0; i < n - m + 1; i++) {
            ListNode tmp = cur.next;
            cur.next = node;
            node = cur;
            cur = tmp;
        }
        // 将翻转部分 和 原链表拼接
        pre.next.next = cur;
        pre.next = node;
        return dummy.next;
    }
}