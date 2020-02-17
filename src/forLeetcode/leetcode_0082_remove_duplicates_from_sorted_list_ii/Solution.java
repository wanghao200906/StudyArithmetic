package forLeetcode.leetcode_0082_remove_duplicates_from_sorted_list_ii;

/// Source :https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/


/*

删除排序链表中的重复元素 II


给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。

示例 1:

输入: 1->2->3->3->4->4->5
输出: 1->2->5
示例 2:

输入: 1->1->1->2->3
输出: 2->3


*/

public class Solution {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = dummy.next;

        while (cur != null && cur.next != null) {

//            如果不相等。都向后移动一位
            if (cur.val != cur.next.val) {
                pre = pre.next;
                cur = cur.next;
            } else {

                int val = cur.val;
//             此时已经知道当前节点和下一个节点的值相同。那么当前节点就要不断地向下移动，直到新节点的值和当前节点值不一样位置
                while (cur != null && cur.val == val) {
                    cur = cur.next;
                }
                pre.next = cur;
            }
        }

        return dummy.next;
    }
}