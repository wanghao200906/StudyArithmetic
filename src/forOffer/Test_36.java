package forOffer;

/**
 * 题目：
 * 输入两个链表，找出它们的第一个公共结点。
 * 思路：
 * <p>
 * 既然公共节点之后的结点都是共有的，两个链表的长度差别只在公共节点之前，
 * 所以可以先得出两个链表的长度之差d，较长的链表先走d步，然后再同时遍历两个链表，直到公共
 * 节点即可。
 */
public class Test_36 {

    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(4);
        ListNode b1 = new ListNode(1);
        ListNode b2 = new ListNode(2);
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
//        b1.next = b2;
        b2.next = a3;
        System.out.println(FindFirstCommonNode(a1, b2).val);


    }

    public static ListNode FindFirstCommonNode(ListNode head1, ListNode head2) {
        ListNode l1 = head1;
        ListNode l2 = head2;
        while (l1 != l2) {
            l1 = l1 == null ? head1 : l1.next;
            l2 = l2 == null ? head2 : l2.next;
        }
        return l1;
    }

    /**
     * 链表结点类
     */
    private static class ListNode {
        int val;
        ListNode next;

        public ListNode() {

        }

        public ListNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return val + "";
        }
    }

}

