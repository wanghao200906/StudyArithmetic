package forLeetcode.leetcode_0019_remove_nth_node_from_end_of_list;

/// 19 Source :https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/

/*

题目： 删除链表的倒数第N个节点



给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。

示例：

给定一个链表: 1->2->3->4->5, 和 n = 2.

当删除了倒数第二个节点后，链表变为 1->2->3->5.
说明：

给定的 n 保证是有效的。

进阶：

你能尝试使用一趟扫描实现吗？

*/

public class Solution {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummy = new ListNode(-1);

        dummy.next = head;
        ListNode l1 = dummy;
        ListNode l2 = dummy;


        for (int i = 0; i <= n; i++) {
            l2 = l2.next;
        }

        while (l2 != null) {
            l1 = l1.next;
            l2 = l2.next;
        }
        l1.next = l1.next.next;
        return dummy.next;


    }
}