package forLeetcode.leetcode_0021_merge_two_sorted_list;

/// Source : https://leetcode-cn.com/problems/merge-two-sorted-lists/


/*

 合并两个有序链表

将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 

示例：

输入：1->2->4, 1->3->4
输出：1->1->2->3->4->4


*/

public class Solution {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {


        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }


        ListNode dummy = new ListNode(-1);
        ListNode list = dummy;
        while (l1 != null && l2 != null) {

            if (l1.val >= l2.val) {
                list.next = l2;
                l2 = l2.next;
            } else {
                list.next = l1;
                l1 = l1.next;
            }
            list = list.next;

        }

        list.next = l1 == null ? l2 : l1;
        return dummy.next;
    }
}