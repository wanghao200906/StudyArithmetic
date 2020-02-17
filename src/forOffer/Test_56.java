package forOffer;

/**
 * 题目：
 * <p>
 * 在一个排序的链表中，如何删除重复的结点？
 * <p>
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 * <p>
 * 思路：
 * <p>
 * 解决这个问题的第一步是确定删除的参数。当然这个函数需要输入待删除链表的头结点。
 * 头结点可能与后面的结点重复，也就是说头结点也可能被删除，所以在链表头添加一个结点。
 * <p>
 * 接下来我们从头遍历整个链表。如果当前结点的值与下一个结点的值相同，那么它们就是重复的结点，都可以被删除。
 * 为了保证删除之后的链表仍然是相连的而没有中间断开，我们要把当前的前一个结点和后面值比当前结点的值要大的结点相连。
 * 我们要确保prev要始终与下一个没有重复的结点连接在一起。
 */

public class Test_56 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(2);
        l1.next = l2;
        l2.next = l3;
        ListNode listNode = deleteDuplication(l1);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

    }


    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode deleteDuplication(ListNode pHead)
    {
        ListNode dummy=new ListNode(-1);
        dummy.next=pHead;
        ListNode pre=dummy;
        ListNode cur=pHead;
        while(cur!=null&&cur.next!=null){
            if(cur.val==cur.next.val){
                int val=cur.val;
                while(cur!=null&&cur.val==val){
                    cur=cur.next;
                    pre.next=cur;
                }
            }else{
                pre=cur;
                cur=cur.next;
            }
        }
        return dummy.next;
    }

}

