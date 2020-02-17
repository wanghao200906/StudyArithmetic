package forOffer;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * 题目：
 * 输入n个整数，找出其中最小的k个数。
 * <p>
 * 例子说明：
 * <p>
 * 例如输入4 、5 、1、6、2、7、3 、8 这8 个数字，则最小的4 个数字是1 、2、3 、4
 * <p>
 * 思路：
 * 解法一：O(n)时间算法，只有可以修改输入数组时可用。 基于快排
 * <p>
 * 可以基于Partition函数来解决这个问题。如果基于数组的第k个数字来调整，使得比第k个数字小的所有数字都位于数组的左边，比第k个数字大的
 * 所有数字都位于数组的右边。这样调整之后，位于数组中左边的k个数字就是最小的k 个数字（这k 个数字不一定是排序的〉。
 * <p>
 * 解法二： O（nlogk）的算法，精剧适合处理海量数据。
 * <p>
 * 先创建一个大小为k的数据容器来存储最小的k个数字，接下来我们每次从输入的n个整数中读入一个数．如果容器中已有的数字少于k个，则直接把这次读入的整数放
 * 入容器之中：如果容器中己有k 数字了，也就是容器己满，此时我们不能再插入新的数字而只能替换已有的数字。找出这己有的k 个数中的最大值，然后1在这次待插入的整数和最
 * 大值进行比较。如果待插入的值比当前己有的最大值小，则用这个数替换当前已有的最大值：如果待插入的值比当前已有的最大值还要大，那么这个数不可能是最小的k个整数之一
 * ，于是我们可以抛弃这个整数。
 * <p>
 * 因此当容器满了之后，我们要做3 件事情：
 * 一是在k 个整数中找到最大数：
 * 二是有可能在这个容器中删除最大数：
 * 三是有可能要插入一个新的数字。我们可以使用一个大顶堆在O(logk）时间内实现这三步操作。
 */
public class Test_29 {


    public static void main(String[] args) {

        int[] arr=new int[]{4, 5, 1, 6, 2, 7, 3, 8};
        getLeastNumbers(arr, 4);
        System.out.println(action(arr,4));
    }


    /**
     * 第二种解法
     * @param array
     * @param k
     * @return
     */
    public static ArrayList<Integer> action(int[] array, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> (o1 - o2));
        for (int i = 0; i < array.length; i++) {
            queue.add(array[i]);
        }
        ArrayList<Integer> list=new ArrayList<Integer>();
        for (int i=0;i<k;i++){
            list.add(queue.remove());
        }
        return list;
    }

    /**
     * 题目： 输入n个整数，找出其中最小的k个数。
     * 【第一种解法】
     *
     * @param array 输入数组
     * @param k     最小的k个数
     */
    public static void getLeastNumbers(int[] array, int k) {

        if (array == null || k <= 0 || k > array.length) {
            throw new IllegalArgumentException("Invalid args");
        }

        int start = 0;
        int end = array.length - 1;
        int index = partition(array, start, end);

        while (index != k - 1) {
            if (index < k - 1) {
                start = index + 1;
            } else {
                end = index - 1;
            }
            index = partition(array, start, end);
        }

        for (int i = 0; i <= index; i++) {
            System.out.println(array[i]);
        }
    }

    /**
     * 分区算法
     *
     * @param input 输入数组
     * @param start 开始下标
     * @param end   结束下标
     * @return 分区位置
     */
    private static int partition(int[] input, int start, int end) {
        int tmp = input[start];

        while (start < end) {
            while (start < end && input[end] >= tmp) {
                end--;
            }
            input[start] = input[end];

            while (start < end && input[start] <= tmp) {
                start++;
            }
            input[end] = input[start];
        }

        input[start] = tmp;
        return start;
    }




}

