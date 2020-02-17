package forOffer;

/**
 * 题目：
 * <p>
 * 一个链表中包含环，如何找出环的入口结点？
 * 思路：
 * 快满指针，
 * <p>
 */

public class Test_55 {

    public static void main(String[] args) {

    }


    class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode EntryNodeOfLoop(ListNode pHead) {
        //空链表或者一个节点肯定没有环
        if (pHead == null || pHead.next == null) {
            return null;
        }

        ListNode fast = pHead;
        ListNode slow = pHead;
//        //fast一次跳两个节点，slow一次跳一个节点
//    //若有环，一定相遇，在环的某个节点停住
        while (fast != null && slow != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        //一个重新指向头，一个不动，相遇点就是入口节点
        fast = pHead;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;


    }
}

