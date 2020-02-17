package forOffer;

import java.util.PriorityQueue;

/**
 * 题目：
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有值排序之后位于中间的数值。
 * 如果数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * 思路：
 *
 * 先用java集合PriorityQueue来设置一个小顶堆和大顶堆
 * 主要的思想是：
 * 因为要求的是中位数，那么这两个堆，
 * 大顶堆用来存较小的数，从大到小排列;
 * 小顶堆存较大的数，从小到大的顺序排序;
 * 显然中位数就是大顶堆的根节点与小顶堆的根节点和的平均数。
 */

public class Test_63 {

    //小顶堆
    private PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((o1, o2) -> o1 - o2);

    //大顶堆
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((o1, o2) -> o2 - o1);

    //记录偶数个还是奇数个
    int count = 0;

    //每次插入小顶堆的是当前大顶堆中最大的数
    //每次插入大顶堆的是当前小顶堆中最小的数
    //这样保证小顶堆中的数永远大于等于大顶堆中的数
    //中位数就可以方便地从两者的根结点中获取了
    public void Insert(Integer num) {
        //个数为偶数的话，则先插入到大顶堆，然后将大顶堆中最大的数插入小顶堆中
        if (count % 2 == 0) {
            maxHeap.offer(num);
            int max = maxHeap.poll();
            minHeap.offer(max);
        } else {
            //个数为奇数的话，则先插入到小顶堆，然后将小顶堆中最小的数插入大顶堆中
            minHeap.offer(num);
            int min = minHeap.poll();
            maxHeap.offer(min);
        }
        count++;
    }

    public Double GetMedian() {
        //当前为偶数个，则取小顶堆和大顶堆的堆顶元素求平均
        if (count % 2 == 0) {
            return new Double(minHeap.peek() + maxHeap.peek()) / 2;
        } else {
            //当前为奇数个，则直接从小顶堆中取元素即可
            return new Double(minHeap.peek());
        }
    }
}

