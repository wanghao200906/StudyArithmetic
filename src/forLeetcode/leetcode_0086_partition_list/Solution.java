package forLeetcode.leetcode_0086_partition_list;

/// Source :https://leetcode-cn.com/problems/partition-list/


/*

题目：分隔链表


给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。

你应当保留两个分区中每个节点的初始相对位置。

示例:

输入: head = 1->4->3->2->5->2, x = 3
输出: 1->2->2->4->3->5


*/

public class Solution {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode partition(ListNode head, int x) {
        ListNode before_Node = new ListNode(0);
        ListNode before = before_Node;
        ListNode after_Node = new ListNode(0);
        ListNode after = after_Node;

        while (head != null) {

            if (head.val < x) {
                before.next = head;
                before = before.next;
            } else {
                after.next = head;
                after = after.next;
            }
            head = head.next;
        }


        before.next=after_Node.next;
        after.next=null;

        return before_Node.next;
    }
}