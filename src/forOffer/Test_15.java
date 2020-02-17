package forOffer;

/**
 * 题目：
 * 定义一个函数，输入一个链表的头结点，反转链表并输出反转后链表的头结点。
 * 翻转链表
 * <p>
 * 思路：
 * ①遍历。将指向下一个节点的指针指向上一个节点。
 * <p>
 * ②递归。先让指向下一个节点的指针为空，然后递归调用，最后再将指向下一个节点的指针指向上一个节点。
 * <p>
 */
public class Test_15 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        ListNode listNode = reverseHead(node1);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

    }


    public static class ListNode {
        public ListNode(int val) {
            this.val = val;
        }

        int val;
        ListNode next;
    }

    /**
     * 反转单链表
     *
     * @param head
     * @return
     */
    private static ListNode reverseHead(ListNode head) {
        if (head == null) {
            return head;
        }

//        上一个节点
        ListNode pre = null;
//        当前节点
        ListNode cur = head;
        while (cur != null) {
//            拿到cur的下一个节点的值。
            ListNode next = cur.next;
//            将当前节的下一个节点指向上一个节点。 此时是一个闭环。但是开始的还是pre指向了cur
            cur.next = pre;
//            pre 移动到cur ,此时 pre和cur就颠倒了位置 ，虽然还是pre直线给了cur，但是pre和cur的值进行了交换。此时还是一个环
            pre = cur;
//           cur 移动到next节点，此时cur的值是next了。此时pre还是一个闭环
            cur = next;
        }

        return pre;
    }

    /**
     * 递归反转
     *
     * @param current
     * @return
     */
    private static ListNode reverseByRecur(ListNode current) {
        if (current == null || current.next == null) return current;
        ListNode nextNode = current.next;
        current.next = null;
        ListNode reverseRest = reverseByRecur(nextNode);
        nextNode.next = current;
        return reverseRest;
    }
}
