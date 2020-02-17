package forLeetcode.leetcode_0215_kth_largest_element_in_an_array;

// Leetcode 215.
// https://leetcode-cn.com/problems/kth-largest-element-in-an-array/



/*
数组中的第K个最大元素

在未排序的数组中找到第 k 个最大的元素。
请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。

示例 1:
输入: [3,2,1,5,6,4] 和 k = 2
输出: 5

示例 2:
输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
输出: 4
说明:

你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。

可以用优先队列，也可以用快排
 */


import java.util.PriorityQueue;

public class Solution {

    public static void main(String[] args) {
        int[] arr = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        System.out.println(findKthLargest(arr, 4));
    }

    public static int findKthLargest(int[] nums, int k) {

        // init heap 'the smallest element first'
        PriorityQueue<Integer> heap =
                new PriorityQueue<Integer>((n1, n2) -> n1 - n2);

        // keep k largest elements in the heap
        for (int n : nums) {
            heap.add(n);
            if (heap.size() > k)
                heap.poll();
        }

        // output
        return heap.poll();


    }

}