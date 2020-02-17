package 算法的总结;


import java.util.LinkedList;
import java.util.Stack;

// 0, 1, … , n-1 这n个数字排成一个圈圈，从数字0开始每次从圆圏里删除第m个数字。求出这个圈圈里剩下的最后一个数字。
// 输入两个链表，找出它们的第一个公共结点。
// 两数相加  输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)  输出：7 -> 0 -> 8  原因：342 + 465 = 807 (感觉这里没有卵用呢)
// 删除链表的倒数第N个节点
// 合并两个有序链表
// 两两交换链表中的节点 给定 1->2->3->4, 你应该返回 2->1->4->3.
// 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
// 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。  1->2->3->3->4->4->5  结果 1->2->5
// 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
//    给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
//反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
// 链表用插入排序算法来排序
// 链表的归并排序
// 删除链表中所有和val相同的元素
// 反转链表
//删除链表中的节点
////    奇偶链表 。给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。
//输入个链表的头结点，从尾到头反过来打印出每个结点的值。
// 给定单向链表的一个头指针和节点指针，定义一个函数在O(1)时间删除该节点。  这个其实就是删除某个链表中的某个节点。
// 输入一个链表，输出该链表中倒数第k 个结点。
// 反转链表
// 一个链表中包含环，如何找出环的入口结点？
// 请判断一个链表是否为回文链表
public class Link {
    public static void main(String[] args) {
        LinkedNode a1 = new LinkedNode(1);
        LinkedNode a2 = new LinkedNode(2);
        LinkedNode a3 = new LinkedNode(3);
        LinkedNode a4 = new LinkedNode(4);
        LinkedNode b1 = new LinkedNode(1);
        LinkedNode b2 = new LinkedNode(2);
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
//        b1.next = b2;
        b2.next = a3;
//        System.out.println(findFirstCommonNode(a1, b2).val);


    }


    static class LinkedNode {
        int val;
        LinkedNode next;

        public LinkedNode(int val) {
            this.val = val;
        }
    }

    // 0, 1, … , n-1 这n个数字排成一个圈圈，从数字0开始每次从圆圏里删除第m个数字。求出这个圈圈里剩下的最后一个数字。
    public int lastNum(int num, int m) {
        if (num < 1 || m < 1) {
            return -1;
        }


        LinkedList<Integer> list = new LinkedList<>();

        for (int i = 0; i < num; i++) {
            list.add(i);
        }

        int index = 0;
        while (list.size() > 1) {
            index = (index + m - 1) % list.size();
            list.remove(index);
        }
        return list.size() == 1 ? list.get(0) : -1;
    }

    //     输入两个链表，找出它们的第一个公共结点

    public static int FirstNotRepeatingChar(String str) {
        char[] c = new char[256];
        for (int i = 0; i < str.length(); i++) {
            c[str.charAt(i)]++;
        }
        for (int i = 0; i < str.length(); i++) {
            if (c[str.charAt(i)] == 1) {
                return i;
            }

        }
        return -1;
    }


    // 两数相加  输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)  输出：7 -> 0 -> 8  原因：342 + 465 = 807 (感觉这里没有卵用呢)
//    注意进位。

    public LinkedNode twoSum(LinkedNode l1, LinkedNode l2) {
        LinkedNode dummyNode = new LinkedNode(-1);
        LinkedNode p = l1, q = l2, cur = dummyNode;
        int carry = 0;
        while (p != null || q != null) {
            int v1 = p != null ? p.val : 0;
            int v2 = q != null ? q.val : 0;
            int sum = carry + v1 + v2;
            carry = sum / 10;
            cur.next = new LinkedNode(sum % 10);
            cur = cur.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }

        if (carry > 0) {
            cur.next = new LinkedNode(carry);
        }

        return cur.next;
    }

//    删除链表的倒数第N个节点


    public LinkedNode removeNthFromEnd(LinkedNode head, int n) {

        LinkedNode dummy = new LinkedNode(-1);
        dummy.next = head;
        LinkedNode l1 = dummy;
        LinkedNode l2 = dummy;
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

//    合并两个有序链表


    public LinkedNode mergeTwoLists(LinkedNode l1, LinkedNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        LinkedNode dummy = new LinkedNode(-1);
        LinkedNode list = dummy;
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

        if (l1 != null) {
            list.next = l1;
        }
        if (l2 != null) {
            list.next = l2;
        }
        return dummy.next;
    }


    //    两两交换链表中的节点 给定 1->2->3->4, 你应该返回 2->1->4->3.
    public LinkedNode swapPairs(LinkedNode head) {
        LinkedNode dummy = new LinkedNode(-1);
        dummy.next = head;
        LinkedNode pre = dummy;

        while (pre.next != null && pre.next.next != null) {
            LinkedNode s = pre.next;
            LinkedNode e = pre.next.next;

            s.next = e.next;
            e.next = s;
            pre.next = e;
            pre = s;
        }
        return dummy.next;
    }

// 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。

    public LinkedNode rotateRight(LinkedNode head, int k) {
        if (head == null) {
            return head;
        }
        if (head.next == null) {
            return head;
        }

        LinkedNode old = head;
        int n;
        for (n = 1; old != null; n++) {
            old = old.next;
        }
        old.next = head;

        LinkedNode newTail = head;
//
        for (int i = 0; i < (n - k) % (n - 1); i++) {
            newTail = newTail.next;
        }
        LinkedNode newL = newTail.next;
        newTail.next = null;
        return newL;
    }

    // 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。  1->2->3->3->4->4->5  结果 1->2->5

    public LinkedNode deleteDuplicates(LinkedNode head) {
        LinkedNode dummy = new LinkedNode(-1);
        dummy.next = head;
        LinkedNode pre = dummy;
        LinkedNode cur = dummy.next;

        while (cur != null && cur.next != null) {
            if (cur.val != cur.next.val) {
                cur = cur.next;
                pre = pre.next;
            } else {
                int val = cur.val;
                while (cur != null && val == cur.val) {
                    cur = cur.next;
                }
                pre.next = cur;
            }
        }
        return dummy.next;

    }

    //    给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
    public LinkedNode deleteDuplicates2(LinkedNode head) {

        LinkedNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                cur = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }

    //    给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
    public LinkedNode partition(LinkedNode head, int x) {
        LinkedNode beforeNode = new LinkedNode(0);
        LinkedNode before = beforeNode;
        LinkedNode afterNode = new LinkedNode(0);
        LinkedNode after = afterNode;
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
        before.next = afterNode;
        after.next = null;
        return beforeNode.next;

    }
//    反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。

    public LinkedNode reverseBetween(LinkedNode head, int m, int n) {
        if (head == null) {
            return head;
        }
        LinkedNode dummy = new LinkedNode(-1);
        dummy.next = head;
        LinkedNode pre = dummy;
        for (int i = 0; i < m - 1; i++) {
            pre = pre.next;
        }


        LinkedNode node = null;
        LinkedNode cur = pre.next;
        for (int i = 0; i < (n - m + 1); i++) {
            LinkedNode temp = cur.next;
            cur.next = node;
            cur = temp;
            node = cur;
        }
        pre.next.next = cur;
        pre.next = node;

        return dummy.next;
    }
    // 链表用插入排序算法来排序

    public LinkedNode insertionSortList(LinkedNode head) {
        LinkedNode dummy = new LinkedNode(-1);
        dummy.next = head;
        LinkedNode pre = dummy;
        LinkedNode cur = dummy.next;
        LinkedNode lat;
        while (cur != null) {
            lat = cur.next;
            if (lat != null && lat.val < cur.val) {

                while (pre.next != null && pre.next.val < lat.val) {
                    pre = pre.next;
                }

                LinkedNode temp = pre.next;
                pre.next = lat;
                cur.next = lat.next;
                lat.next = temp;
            } else {
                cur = lat;
            }
        }
        return dummy.next;
    }

    //    链表归并排序
    public LinkedNode mergeSortList(LinkedNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        LinkedNode slow = head;
        LinkedNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        LinkedNode right = slow.next;
        slow.next = null;
        LinkedNode leftNode = mergeSortList(head);
        LinkedNode rightNode = mergeSortList(right);
        return mergeTwoList(leftNode, rightNode);

    }

    private LinkedNode mergeTwoList(LinkedNode leftNode, LinkedNode rightNode) {
        LinkedNode dummy = new LinkedNode(-1);
        LinkedNode cur = dummy;
        while (leftNode != null && rightNode != null) {
            if (leftNode.val <= rightNode.val) {
                cur.next = leftNode;
                leftNode = leftNode.next;
            } else {
                cur.next = rightNode;
                rightNode = rightNode.next;
            }
            cur = cur.next;
        }
        if (leftNode != null) {
            cur.next = leftNode;
        }
        if (rightNode != null) {
            cur.next = rightNode;
        }

        return dummy.next;
    }
    // 删除链表中所有和val相同的元素

    public LinkedNode removeElements(LinkedNode head, int val) {
        LinkedNode dummy = new LinkedNode(-1);
        dummy.next = head;
        LinkedNode pre = dummy;
        while (pre.next != null) {
            if (pre.next.val == val) {
                pre.next = pre.next.next;
            } else {
                pre = pre.next;
            }
        }
        return dummy.next;
    }
//    反转链表

    public LinkedNode reverseList(LinkedNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        LinkedNode pre = null;
        LinkedNode cur = head;
        while (cur != null) {
            LinkedNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
//     删除链表中的节点

    public void deleteNode(LinkedNode node) {
//将node后面的值 赋值给node节点。
        node.val = node.next.val;
//        删除node后面的节点。这样结果就等于删除了node节点
        node.next = node.next.next;
    }

//    奇偶链表 。给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。

    public LinkedNode oddEvenList(LinkedNode head) {
        if (head == null) {
            return head;
        }

        LinkedNode left = head;
        LinkedNode right = head.next;
        LinkedNode rightHead = right;
        while (right != null && right.next != null) {
            left.next = right.next;
            left = left.next;
            right.next = left.next;
            right = right.next;
        }
        left.next = rightHead;
        return head;
    }

    //    两数相加 II  (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4) 结果 7 -> 8 -> 0 -> 7
    public LinkedNode addTwoNumbers(LinkedNode l1, LinkedNode l2) {
        LinkedNode left = reverse(l1);
        LinkedNode right = reverse(l2);
        LinkedNode pre = null;
        LinkedNode res = null;
        int carry = 0;
        while (left != null || right != null) {
            int l = left != null ? left.val : 0;
            int r = right != null ? right.val : 0;
            int sum = carry + l + r;
            carry = sum / 10;
            pre = res;
            res = new LinkedNode(sum % 10);
            res.next = pre;
            left = left != null ? left.next : null;
            right = right != null ? right.next : null;
        }

        if (carry > 0) {
            pre = res;
            res = new LinkedNode(carry);
            res.next = pre;
        }

        return res;
    }

    public LinkedNode reverse(LinkedNode head) {
        LinkedNode pre = null;
        LinkedNode cur = head;
        while (cur != null) {
            LinkedNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    //输入个链表的头结点，从尾到头反过来打印出每个结点的值。
    public void showReverse(LinkedNode head) {
        if (head != null) {
            showReverse(head.next);
            System.out.println(head.val);
        }
    }

    // 给定单向链表的一个头指针和节点指针，定义一个函数在O(1)时间删除该节点。  这个其实就是删除某个链表中的某个节点。

    public LinkedNode deleteNode(LinkedNode head, LinkedNode node) {

        if (head == null || node == null) {
            return head;
        }
        if (head == node) {
            return head.next;
        }
        if (node.next == null) {
            LinkedNode temp = head;
            while (temp.next != node) {
                temp = temp.next;
            }
            temp.next = null;
        } else {
            node.val = node.next.val;
            node.next = node.next.next;
        }
        return head;
    }

    //    输入一个链表，输出该链表中倒数第k 个结点。
    public LinkedNode findKthToTail(LinkedNode head, int k) {
        if (head == null || k < 0) {
            return head;
        }
        LinkedNode tmp = head;
        for (int i = 0; i < k; i++) {
            if (tmp.next != null) {
                tmp = tmp.next;
            } else {
                return null;
            }
        }

        while (tmp != null) {
            tmp = tmp.next;
            head = head.next;
        }
        return head;

    }

    //// 一个链表中包含环，如何找出环的入口结点？
    public LinkedNode EntryNodeOfLoop(LinkedNode pHead)
    {
        //空链表或者一个节点肯定没有环
        if(pHead == null || pHead.next == null){
            return null;
        }

        LinkedNode fast=pHead;
        LinkedNode slow=pHead;
        while(fast!=null&&slow!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                break;
            }
        }
        fast=pHead;
        while(fast!=slow){
            fast=fast.next;
            slow=slow.next;
        }
        return fast;


    }
//    是环
    public boolean isLoop(LinkedNode head) {
        if (head == null) {
            return false;
        }
        LinkedNode fast = head;
        LinkedNode slow = head;
        while (fast != null && slow != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {

                return true;
            }
        }
        return false;

    }

    //查找链表中间值
    public int findMid(LinkedNode node) {
        if (node == null) {
            return -1;
        }
//初始化两个node 节点
        LinkedNode first = node;
        LinkedNode second = node;
//        循环first 节点
        while (first != null && first.next != null) {
//            一个 跑两步，一个跑一步。跑两步的为null了。那么跑一步的就是中间节点
            first = first.next.next;
            second = second.next;
        }
        return second.val;

    }

    //获取 环的长度
    public int getLoopLength(LinkedNode node) {
        if (node == null) {
            return -1;
        }
        int length = 0;
//        获取当前节点
        LinkedNode cur = node;
        while (cur != null) {
//            不断地遍历下一个
            cur = cur.next;
            length++;
//            节点和node 节点一致就是一圈
            if (cur == node) {
                return length;
            }
        }
        return length;
    }
//  是回文链表

    public static boolean isPalindrome1(LinkedNode head) {
        Stack<LinkedNode> stack = new Stack<LinkedNode>();
        LinkedNode cur = head;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        while (head != null) {
            if (head.val != stack.pop().val) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

//    复制一个复杂链表。

    public class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }
        RandomListNode node = pHead;
        while (node != null) {

            RandomListNode tnode = new RandomListNode(node.label);
            RandomListNode next = node.next;

            node.next = tnode;
            tnode.next = next;
            node = next;
        }

        node = pHead;
        while (node != null) {
            if (node.random != null) {
                node.next.random = node.random.next;
            }
            node = node.next.next;
        }
        node = pHead;
        RandomListNode newHead = pHead.next;
        while(node!=null){
            RandomListNode cur=node.next;
            node.next=cur.next;
            if(cur.next!=null){
                cur.next=cur.next.next;
            }
            node=node.next;
        }
        return newHead;
    }
}
