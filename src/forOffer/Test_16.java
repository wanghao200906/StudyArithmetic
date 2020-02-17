package forOffer;

/**
 * 题目：
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的结点仍然是按照递增排序的。
 * <p>
 * 思路：
 * **Step1.**定义一个指向新链表的指针，暂且让它指向NULL；
 * <p>
 * **Step2.**比较两个链表的头结点，让较小的头结点作为新链表的头结点；
 * <p>
 * **Step3.**有两种方法。
 * <p>
 * ①递归比较两个链表的其余节点，让较小的节点作为上一个新节点的后一个节点；
 * <p>
 * ②循环比较两个链表的其余节点，让较小的节点作为上一个新节点的后一个节点。直到有一个链表没有节点，然后将新链表的最后一个节点直接指向
 * 剩余链表的节点。
 * <p>
 */
public class Test_16 {
    public static void main(String[] args) {

        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        node4.next = node5;
        node5.next = node6;


        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;


        ListNode merge = merge(node1, node4);

        while (merge != null) {
            System.out.println(merge.value);
            merge = merge.next;

        }

    }


    public static class ListNode {
        public ListNode() {
        }

        public ListNode(int value) {
            this.value = value;
        }

        int value;
        ListNode next;
    }

    /**
     * 输入两个递增排序的链表，合并这两个链表并使新链表中的结点仍然是按照递增排序的
     *
     * @param head1 第一个有序链表
     * @param head2 第二个有序链表
     * @return 合并后的有序链表头
     */
    public static ListNode merge(ListNode head1, ListNode head2) {
        // 如果第一个链表为空，返回第二个链表头结点
        if (head1 == null) {
            return head2;
        }

        // 如果第二个结点为空，返回第一个链表头结点
        if (head2 == null) {
            return head1;
        }

        // 创建一个临时结点，用于添加元素时方便
        ListNode root = new ListNode();
        // 用于指向合并后的新链的尾结点
        ListNode pointer = root;

        // 当两个链表都不为空就进行合并操作
        while (head1 != null && head2 != null) {
            // 下面的操作合并较小的元素
            if (head1.value < head2.value) {
//                head1 是一个链表。此时pointer链表拥有head1的所有值了
                pointer.next = head1;
                head1 = head1.next;
            } else {
                pointer.next = head2;
                head2 = head2.next;
            }

            // 将指针移动到合并后的链表的末尾
//            每次遍历都需要将pointer向后移动一位。因为第一次给pointer赋值的时候就已经把整个链表赋值给了pointer。
//            所以需要移动
            pointer = pointer.next;
            System.out.println();
        }

        // 下面的两个if有且只一个if会内的内容会执行

        // 如果第一个链表的元素未处理完将其，接到合并链表的最后一个结点之后
        if (head1 != null) {
            pointer.next = head1;
        }

        // 如果第二个链表的元素未处理完将其，接到合并链表的最后一个结点之后
        if (head2 != null) {
            pointer.next = head2;
        }

        // 返回处理结果
        return root.next;
    }


    /**
     * 输入两个递增排序的链表，合并这两个链表并使新链表中的结点仍然是按照递增排序的
     * 【使用的是递归的解法，不推荐，递归调用的时候会有方法入栈，需要更多的内存】
     *
     * @param head1 第一个有序链表
     * @param head2 第二个有序链表
     * @return 合并后的有序链表头
     */
    public static ListNode merge2(ListNode head1, ListNode head2) {
        // 如果第一个链表为空，返回第二个链表头结点
        if (head1 == null) {
            return head2;
        }

        // 如果第二个链表为空，返回第一个链表头结点
        if (head2 == null) {
            return head1;
        }

        // 记录两个链表中头部较小的结点
        ListNode tmp = head1;
        if (tmp.value < head2.value) {
            // 如果第一个链表的头结点小，就递归处理第一个链表的下一个结点和第二个链表的头结点
            tmp.next = merge2(head1.next, head2);
        } else {
            // 如果第二个链表的头结点小，就递归处理第一个链表的头结点和第二个链表的头结点的下一个结点
            tmp = head2;
            tmp.next = merge2(head1, head2.next);
        }

        // 返回处理结果
        return tmp;
    }
}


