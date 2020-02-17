package forLeetcode.leetcode_0203_remove_linked_list_elements;
/// Source : https://leetcode.com/problems/remove-linked-list-elements/description/
/// Time Complexity: O(n)
/// Space Complexity: O(1)

/**
 * 删除链表中所有和val相同的元素
 * <p>
 * Example:
 * <p>
 * Input:  1->2->6->3->4->5->6, val = 6
 * Output: 1->2->3->4->5
 */
public class Solution {

    public ListNode removeElements(ListNode head, int val) {

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode cur = dummyHead;
        while (cur.next != null) {
            if (cur.next.val == val) {
                ListNode delNode = cur.next;
                cur.next = delNode.next;
            } else
                cur = cur.next;
        }

        return dummyHead.next;
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 6, 3, 4, 5, 6};
        int val = 6;

        ListNode head = new ListNode(arr);
        System.out.println(head);

        (new Solution()).removeElements(head, val);
        System.out.println(head);
    }
}