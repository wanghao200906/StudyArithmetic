package forLeetcode.leetcode_0283_move_zeroes;

// Leetcode 283. move_zeroes
// https://leetcode-cn.com/problems/move-zeroes/



/*
给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。

示例:

输入: [0,1,0,3,12]
输出: [1,3,12,0,0]
说明:

必须在原数组上操作，不能拷贝额外的数组。
尽量减少操作次数。
 */


public class Solution {

    public static void main(String[] args) {
        int[] ar = {1};
        int[] ar2 = {0, 1, 0, 3, 12};
        int[] cover = cover(ar);
        for (int i = 0; i < cover.length; i++) {
            System.out.println(cover[i]);
        }

    }

    public static int[] cover(int[] arr) {
        for (int i = 0, j = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
        }
        return arr;
    }

}