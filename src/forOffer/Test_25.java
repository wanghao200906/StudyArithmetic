package forOffer;

/**
 * 题目：
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点）
 * ，返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 * <p>
 * 思路：
 * 在不用辅助空间的情况下实现O(n)的时间效率。
 * <p>
 * 第一步：仍然是根据原始链表的每个结点N 创建对应的N’。把N’链接在N的后面。
 * <p>
 * 第二步：设置复制出来的结点的sibling。假设原始链表上的N的sibling指向结点S，那么其对应复制出来的N’是N的next指向的结点，同样S’也是
 * S的next指向的结点。
 * <p>
 * 第三步：把这个长链表拆分成两个链表。把奇数位置的结点用next . 链接起来就是原始链表，把偶数位置的结点用next 链接起来就是复制
 * 出来的链表。
 *
 * <p>
 */
public class Test_25 {
    public static void main(String[] args) {

    }

    public class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

    public RandomListNode Clone(RandomListNode pHead) {
        //0.判断空的情况
        if (pHead == null) {
            return null;
        }

        //1.复制结点
        RandomListNode node = pHead;
        while (node != null) {
            //保存下一个结点next-->新建一个克隆结点-->指定node.next到克隆结点
            //-->克隆结点的next指向next结点-->更新node为next结点
            RandomListNode cloneNode = new RandomListNode(node.label);
            RandomListNode next = node.next;
            node.next = cloneNode;
            cloneNode.next = next;
            node = next;
        }

        //2.复制随机引用
        node = pHead;
        while (node != null) {
            if (node.random != null) {
                node.next.random = node.random.next;
            }
            node = node.next.next;
        }

        //3.分离两个链表
        node = pHead;
        //记录复制的链表的头结点
        RandomListNode newHead = pHead.next;
        while (node != null) {
            RandomListNode currNode = node.next;
            //更新原结点的next
            node.next = currNode.next;
            //更新克隆结点的next
            if (currNode.next != null) {
                currNode.next = currNode.next.next;
            }
            //更新原结点指针
            node = node.next;
        }

        return newHead;
    }
}


