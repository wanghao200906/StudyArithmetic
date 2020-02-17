package forOffer;

import java.util.LinkedList;

/**
 * 题目：
 *
 * 每年六一儿童节,牛客都会准备一些小礼物去看望孤儿院的小朋友,今年亦是如此。
 * HF作为牛客的资深元老,自然也准备了一些小游戏。
 * 其中,有个游戏是这样的:首先,让小朋友们围成一个大圈。然后,他随机指定一个数m,让编号为0的小朋友开始报数。
 * 每次喊到m-1的那个小朋友要出列唱首歌,然后可以在礼品箱中任意的挑选礼物,并且不再回到圈中,
 * 从他的下一个小朋友开始,继续0…m-1报数…这样下去…直到剩下最后一个小朋友,
 * 可以不用表演,并且拿到牛客名贵的“名侦探柯南”典藏版(名额有限哦!!_)。请你试着想下,哪个小朋友会得到这份礼品呢？(注：小朋友的编号是从0到n-1)
 *
 *
 *
 * 题目另一种说法：
 * 0, 1, … , n-1 这n个数字排成一个圈圈，从数字0开始每次从圆圏里删除第m个数字。求出这个圈圈里剩下的最后一个数字。
 * 当删除第m个数之后。那么m+1那个位置就是0.然后继续往后数m个数。并删除。因为是环形的所以可以一直删除
 *
 * 思路：
 * 创建一个总共有n 个结点的环形链表，然后每次在这个链表中删除第m 个结点。
 */

public class Test_46 {
    public static void main(String[] args) {
        System.out.println(lastRemaining(5, 3));
    }

    public static int lastRemaining(int n, int m) {
        if (n < 1 || m < 1) {
            return -1;
        }
        //用环形链表来模拟圆圈
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }

        //表示删除的标志
        int index = 0;
        while (list.size() > 1) {
            //每一轮移动 m-1 个位置
            index = (index + m - 1) % list.size();
            list.remove(index);
        }
        return list.size() == 1 ? list.get(0) : -1;
    }
}

